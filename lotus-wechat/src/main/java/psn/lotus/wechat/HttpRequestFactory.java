package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static psn.lotus.wechat.error.ErrorMessageOld.*;

/**
 * http请求工厂实现
 *
 * @author: nicee
 * @since: 2015/12/30
 */
@Component
public final class HttpRequestFactory implements HttpRequest {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestFactory.class);

    private static final HttpClientBuilder BUILDER = HttpClientBuilder.create();

    private static boolean init = false;

    public JSONObject doGet(String uri, ResponseHandler handler) {
        return doGet(uri, (HttpContext) null, handler);
    }

    public JSONObject doGet(String uri, HttpContext context, ResponseHandler handler) {
        Args.notNull(uri, "uri must not be null.");
        return execute(new HttpGet(uri), context, handler);
    }

    public JSONObject doGet(String uri, Map<String, Object> params, ResponseHandler handler) {
        return doGet(uri, params, null, handler);
    }

    public JSONObject doGet(String uri, Map<String, Object> params, HttpContext context, ResponseHandler handler) {
        Args.notNull(uri, "uri must not be null.");
        List<NameValuePair> nameValuePairs = wrapParams(params);
        String uriSuffix = URLEncodedUtils.format(nameValuePairs, "utf-8");
        return execute(new HttpGet(uri.concat(uriSuffix)), context, handler);
    }

    public JSONObject doPost(String uri, Map<String, Object> params, ResponseHandler handler) {
        return doPost(uri, params, null, handler);
    }

    public JSONObject doPost(String uri, Map<String, Object> params, HttpContext context, ResponseHandler handler) {
        String requestStr = JSONObject.toJSONString(params);
        return doPost(uri, requestStr, context, handler);
    }

    public JSONObject doPost(String uri, String content, ResponseHandler handler) {
        return doPost(uri, content, null, handler);
    }

    public JSONObject doPost(String uri, String content, HttpContext context, ResponseHandler handler) {
        HttpPost post = new HttpPost(uri);
        post.addHeader("Content-Type", "application/json");
        post.addHeader("charset", "UTF-8");
        post.setEntity(new StringEntity(content, Charset.defaultCharset()));
        return execute(post, context, handler);
    }

    public JSONObject doPost(String uri, File file, ResponseHandler handler) {
        return doPost(uri, file, null, handler);
    }

    public JSONObject doPost(String uri, File file, HttpContext context, ResponseHandler handler) {
        HttpPost post = new HttpPost(uri);
        FileBody fileBody = new FileBody(file);
        HttpEntity httpEntity = MultipartEntityBuilder.create()
//                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
//                .setContentType(ContentType.MULTIPART_FORM_DATA)
                .addPart("media", fileBody)
                .build();
        post.setEntity(httpEntity);
        return execute(post, context, handler);
    }

    private JSONObject execute(HttpUriRequest uri, HttpContext context, ResponseHandler handler) {
        JSONObject wechat = null;
        CloseableHttpClient httpClient = getHttpsClient();
        try {
            CloseableHttpResponse response = httpClient.execute(uri, context);
            if (handler != null) {
                wechat = (JSONObject) handler.handleResponse(response);
            }
        } catch (Exception e) {
            if (logger.isInfoEnabled()) {
                logger.info(SEND_HTTPS_REQUEST_FAILURE, e);
            }
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                if (logger.isInfoEnabled()) {
                    logger.info(CLOSE_HTTP_CLIENT_FAILURE, e);
                }
            }
        }
        return wechat;
    }

    private CloseableHttpClient getHttpsClient() {
        synchronized (BUILDER) {
            if (!init) {
                SSLContext sslContext = createSSLContext();
                BUILDER.setSslcontext(sslContext);
                BUILDER.setMaxConnTotal(10);
                BUILDER.setMaxConnPerRoute(20);
                init = true;
            }
            return BUILDER.build();
        }
    }

    private SSLContext createSSLContext() {
        SSLContext sslContext = null;
        try {
            TrustManager[] trustManagers = {new MyX509TrustManager()};
            sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, trustManagers, new SecureRandom());
        } catch (Exception e) {
            if (logger.isInfoEnabled()) {
                logger.info(CREATE_SSL_CONTEXT_FAILURE, e);
            }
        }
        return sslContext;
    }

    private List<NameValuePair> wrapParams(Map<String, Object> params) {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (null != params) {
            for (String key : params.keySet()) {
                nameValuePairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
        }
        return nameValuePairs;
    }

}
