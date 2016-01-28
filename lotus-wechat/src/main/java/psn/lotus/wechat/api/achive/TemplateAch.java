package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.TemplateAPI;
import psn.lotus.wechat.param.template.TemplateRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 模板消息接口实现
 *
 * @author: nicee
 * @since: 2015/12/29
 */
@Service
public final class TemplateAch extends AbstractBasedAch implements TemplateAPI {

    public String getTemplateId(String templateIdShort) {
        Args.notEmpty(templateIdShort, "template short id is empty.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_TEMPLATE_ID_URL);
        Map<String, Object> requestParams = new HashMap<String, Object>();
        requestParams.put("template_id_short", templateIdShort);
        JSONObject jsonObject = httpRequest.doPost(targetUrl, requestParams, responseHandler);
        System.out.print(jsonObject);
        return "";
    }

    public JSONObject sendMessage(TemplateRequest requestParam) {
        Args.notNull(requestParam, "template request params is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_TEMPLATE_URL);
        return httpRequest.doPost(targetUrl, requestParam.toString(), responseHandler);
    }

}
