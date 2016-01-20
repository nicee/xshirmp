package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import psn.lotus.wechat.error.WechatError;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * http请求回调处理
 *
 * @author: nicee
 * @since: 2015/12/31
 */
@Component
public final class ResponseHttpHandler implements ResponseHandler<JSONObject> {

    @Autowired
    private WechatError<JSONObject> wechatErrorResolver;

    public JSONObject handleResponse(HttpResponse httpResponse) throws IOException, WechatException {
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
        //TODO != 200 or > 300 ??
        if (statusCode != 200) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusCode, statusLine.getReasonPhrase());
        }

        JSONObject content = (entity == null) ? null : resovleContent(entity);
        if (content != null) {
            wechatErrorResolver.resolveCode(content);
        }
        return content;
    }

    private JSONObject resovleContent(HttpEntity entity) throws IOException {
        Args.notNull(entity, "Entity");
        Args.check(entity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
        InputStream instream = entity.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream, getCharset(entity)));
        StringBuffer buffer = new StringBuffer();
        String readerLine;
        while ((readerLine = reader.readLine()) != null) {
            buffer.append(readerLine);
        }
        JSONObject content = JSONObject.parseObject(buffer.toString());
        return content;
    }

    private Charset getCharset(HttpEntity entity) throws UnsupportedEncodingException {
        Charset charset = null;
        try {
            ContentType reader = ContentType.get(entity);
            if (reader != null) {
                charset = reader.getCharset();
            }
        } catch (UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(e.getMessage());
        }
        if (charset == null) {
            charset = HTTP.DEF_CONTENT_CHARSET;
        }
        return charset;
    }
}
