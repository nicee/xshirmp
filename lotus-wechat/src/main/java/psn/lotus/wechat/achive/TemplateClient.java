package psn.lotus.wechat.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.HttpRequest;
import psn.lotus.wechat.ResponseHttpHandler;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.AccessTokenAPI;
import psn.lotus.wechat.api.TemplateAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
@Service
public final class TemplateClient implements TemplateAPI {

    @Autowired
    private AccessTokenAPI accessTokenAPI;

    @Autowired
    private HttpRequest httpRequest;

    public String getTemplateId(String templateIdShort) {
        Args.notEmpty(templateIdShort, "template short id is empty.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_TEMPLATE_ID_URL);
        Map<String, Object> requestParams = new HashMap<String, Object>();
        requestParams.put("template_id_short", templateIdShort);
        JSONObject jsonObject = httpRequest.doPost(targetUrl, requestParams, ResponseHttpHandler.DEFAULTE_RESPONSE_HANDLER);
        System.out.print(jsonObject);
        return "";
    }

    public void sendMessage(Map<String, Object> requestParam) {
        Args.notNull(requestParam, "template request params is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_TEMPLATE_URL);
        JSONObject jsonObject = httpRequest.doPost(targetUrl, requestParam, ResponseHttpHandler.DEFAULTE_RESPONSE_HANDLER);
        System.out.print(jsonObject);
    }


}
