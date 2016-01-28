package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import psn.lotus.HttpRequest;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.AccessTokenAPI;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: nicee
 * @since: 2016/1/15
 */
@Service
public final class AccessTokenAch implements AccessTokenAPI {

    static final ConcurrentHashMap<String, Object> cached = new ConcurrentHashMap<String, Object>();

    static final String TOKEN_PLACEHOLDER = "ACCESS_TOKEN";
    static final String EXPIRE_END = "EXPIRE_END";

    @Value("${app_id}")
    private String appId;

    @Value("${app_secret}")
    private String appSecret;

    @Autowired
    private HttpRequest httpRequest;

    @Autowired
    private ResponseHandler<JSONObject> responseHandler;

    public String getAccessToken() {
        return validateCached() ? (String) cached.get(TOKEN_PLACEHOLDER) : regetAccessToken();
    }

    public String replaceAccessToken(String srcUrl) {
        return srcUrl.replace(TOKEN_PLACEHOLDER, getAccessToken());
//        return srcUrl.replace(TOKEN_PLACEHOLDER, "ngrQaWW4ZXb2wwBQG26zrAQKUzYWUSU53Ant_o8VM6AEdwz_ws47jWO5Zm_XXCtPbTdirbt2Wehy3FFAsAkYDo5eiS2FIszJxn-aRF5WkW8KNDcACAPSI");
    }

    private boolean validateCached() {
        return (!cached.containsKey(TOKEN_PLACEHOLDER) || System.currentTimeMillis() < (Long) cached.get(EXPIRE_END)) ? false : true;
    }

    private String regetAccessToken() {
        String url = Urls.GET_ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appSecret);
        JSONObject result = httpRequest.doGet(url, responseHandler);
        Integer expireIn = result.getInteger("expires_in");
        String accessToken = result.getString("access_token");
        cached.put(EXPIRE_END, System.currentTimeMillis() + expireIn * 1000 - 20000);
        cached.put(TOKEN_PLACEHOLDER, accessToken);
        return accessToken;
    }

}
