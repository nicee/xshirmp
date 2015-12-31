package psn.lotus.wechat.client;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import psn.lotus.wechat.HttpRequest;
import psn.lotus.wechat.ResponseHttpHandler;
import psn.lotus.wechat.url.TemplateAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public final class TemplateClient extends WechatClient implements TemplateAPI {

    public TemplateClient() {
        super();
    }

    public TemplateClient(HttpRequest httpRequest) {
        super(httpRequest);
    }

    public String getTemplateId(String templateIdShort) {
        Args.notEmpty(templateIdShort, "template short id is empty.");
        String targetUrl = replaceAccessToken(GET_TEMPLATE_ID_URL);
        Map<String, Object> requestParams = new HashMap<String, Object>();
        requestParams.put("template_id_short", templateIdShort);
        JSONObject jsonObject = getHttpRequest().doPost(targetUrl, requestParams, ResponseHttpHandler.DEFAULTE_RESPONSE_HANDLER);
        System.out.print(jsonObject);
        return "";
    }

    public void sendMessage(Map<String, Object> requestParam) {
        Args.notNull(requestParam, "template content is null.");
        String targetUrl = replaceAccessToken(SEND_TEMPLATE_URL);
        JSONObject jsonObject = getHttpRequest().doPost(targetUrl, requestParam, ResponseHttpHandler.DEFAULTE_RESPONSE_HANDLER);
        System.out.print(jsonObject);
    }


}
