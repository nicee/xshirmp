package psn.lotus.open.api.achive;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import org.springframework.stereotype.Service;
import psn.lotus.open.Urls;
import psn.lotus.open.api.CardAPI;
import psn.lotus.open.param.card.AgentQualification;
import psn.lotus.open.param.card.AuditResult;
import psn.lotus.open.param.card.SubMerchant;
import psn.lotus.open.param.card.SubQualification;

import java.io.File;

/**
 * @author: nicee
 * @since: 2016/1/25
 */
@Service("OpenCardAch")
public final class CardAch extends AbstractBasedAch implements CardAPI {

    public void applyAgentQualification(AgentQualification qualification) {
        String targetUrl = componentAccessTokenAPI.replaceComponentAccessToken(Urls.UPLOAD_CARD_AGENT_QUALIFICATION);
        JSONObject result = httpRequest.doPost(targetUrl, qualification.toString(), responseHandler);
        System.out.println(result);
    }

    public AuditResult getAuditResultOfAgent() {
        String targetUrl = componentAccessTokenAPI.replaceComponentAccessToken(Urls.CHECK_CARD_AGENT_QUALIFICATION);
        JSONObject result = httpRequest.doGet(targetUrl, responseHandler);
        return AuditResult.getResult(result.getString("result"));
    }

    public void applySubQualification(SubQualification qualification) {
        String targetUrl = componentAccessTokenAPI.replaceComponentAccessToken(Urls.UPLOAD_CARD_MERCHANT_QUALIFICATION);
        JSONObject result = httpRequest.doPost(targetUrl, qualification.toString(), responseHandler);
        System.out.println(result);
    }

    public AuditResult getAuditResultOfSub(String subAppId) {
        String targetUrl = componentAccessTokenAPI.replaceComponentAccessToken(Urls.CHECK_CARD_MERCHANT_QUALIFICATION);
        JSONObject result = httpRequest.doGet(targetUrl, responseHandler);
        return AuditResult.getResult(result.getString("result"));
    }

    public String uploadImgIfRequire(File file) {
        //TODO 可借鉴wechat包下的实现
        return null;
    }

    public JSONObject getApplyProtocol() {
        String targetUrl = componentAccessTokenAPI.replaceComponentAccessToken(Urls.GET_APPLY_PROTOCOL);
        return httpRequest.doGet(targetUrl, responseHandler);
    }

    public SubMerchant getSubMerchantDetail(String appid) {
        Args.notNull(appid, "APP ID of sub merchant could not be null.");
        String targetUrl = componentAccessTokenAPI.replaceComponentAccessToken(Urls.GET_CARD_MERCHANT);
        String param = "{\"appid\":\"" + appid + "\"}";
        JSONObject result = httpRequest.doPost(targetUrl, param, responseHandler);
        return JSONObject.toJavaObject(result, SubMerchant.class);
    }

    public SubMerchant[] getSubMerchants(String next) {
        String targetUrl = componentAccessTokenAPI.replaceComponentAccessToken(Urls.BATCH_GET_CARD_MERCHANT);
        next = (next == null) ? "" : next;
        String param = "{\"next_get\":\"" + next + "\"}";
        JSONObject result = httpRequest.doPost(targetUrl, param, responseHandler);
        JSONArray array = result.getJSONArray("list");
        return JSONArray.toJavaObject(array, SubMerchant[].class);
    }


}
