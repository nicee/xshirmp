package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.apache.http.protocol.HttpContext;

import java.io.File;
import java.util.Map;

/**
 * http请求接口
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public interface HttpRequest {

    JSONObject doGet(String uri, ResponseHandler handler);

    JSONObject doGet(String uri, HttpContext context, ResponseHandler handler);

    JSONObject doGet(String uri, Map<String, Object> params, ResponseHandler handler);

    JSONObject doGet(String uri, Map<String, Object> params, HttpContext context, ResponseHandler handler);

    JSONObject doPost(String uri, Map<String, Object> params, ResponseHandler handler);

    JSONObject doPost(String uri, Map<String, Object> params, HttpContext context, ResponseHandler handler);

    JSONObject doPost(String uri, String content, ResponseHandler handler);

    JSONObject doPost(String uri, String content, HttpContext context, ResponseHandler handler);

    JSONObject doPost(String uri, File file, ResponseHandler handler);

    JSONObject doPost(String uri, File file, HttpContext context, ResponseHandler handler);

}
