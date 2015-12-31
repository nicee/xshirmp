package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.apache.http.protocol.HttpContext;

import java.util.Map;

/**
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

}
