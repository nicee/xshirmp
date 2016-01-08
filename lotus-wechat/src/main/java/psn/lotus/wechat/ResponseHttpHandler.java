package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * @author: nicee
 * @since: 2015/12/31
 */
public final class ResponseHttpHandler implements ResponseHandler<JSONObject> {

    public static final ResponseHandler DEFAULTE_RESPONSE_HANDLER = new ResponseHttpHandler();

    public JSONObject handleResponse(HttpResponse httpResponse) throws IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
        if (statusCode > 300) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusCode, statusLine.getReasonPhrase());
        }
        return entity == null ? null : resovleContent(entity);
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

    private long checkLength(HttpEntity entity) {
        long length = entity.getContentLength();

        return length;
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
