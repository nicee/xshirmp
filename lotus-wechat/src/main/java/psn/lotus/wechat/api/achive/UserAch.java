package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.UserAPI;

/**
 * @author: nicee
 * @since: 2016/1/21
 */
@Service
public class UserAch extends AbstractBasedAch implements UserAPI {

    public JSONObject getAllGroup() {
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.USER_GROUP_URL);
        return httpRequest.doGet(targetUrl, responseHandler);
    }

}
