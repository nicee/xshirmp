package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.CardAPI;
import psn.lotus.wechat.param.card.LandingPageRequest;
import psn.lotus.wechat.param.card.MultipleQRCodeRequest;
import psn.lotus.wechat.param.card.SingleQRCodeRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡券接口实现
 *
 * @author: nicee
 * @since: 2016/1/19
 */
@Service
public final class CardAch extends AbstractBasedAch implements CardAPI {

    public JSONObject deliveredToSingleQRCode(SingleQRCodeRequest requestParam) {
        Args.notNull(requestParam, "single qrcode request params is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.CARD_DELIVERED_TO_QRCODE_URL);
        return httpRequest.doPost(targetUrl, requestParam.toString(), responseHandler);
    }

    public JSONObject deliveredToMultipleQRCode(MultipleQRCodeRequest requestParam) {
        Args.notNull(requestParam, "multiple qrcode request params is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.CARD_DELIVERED_TO_QRCODE_URL);
        return httpRequest.doPost(targetUrl, requestParam.toString(), responseHandler);
    }

    public Map<String, String> createLandingPage(LandingPageRequest requestParam) {
        Args.notNull(requestParam, "landing page request params is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.CREATE_LANDINGPAGE_URL);
        JSONObject content = httpRequest.doPost(targetUrl, requestParam.toString(), responseHandler);
        Map<String, String> landingPage = new HashMap<String, String>();
        landingPage.put("url", content.getString("url"));
        landingPage.put("page_id", content.getString("page_id"));
        return landingPage;
    }

    public String getMPNews(String cardId) {
        Args.notNull(cardId, "card id is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_MPNEWS_OF_CARD_URL);
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"card_id\":\"").append(cardId).append("\"}");
        JSONObject result = httpRequest.doPost(targetUrl, buffer.toString(), responseHandler);
        return result.getString("content");
    }

}
