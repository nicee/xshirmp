package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import psn.lotus.wechat.HttpRequest;
import psn.lotus.wechat.api.AccessTokenAPI;

/**
 * 基类
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public abstract class AbstractBasedAch {

    @Autowired
    protected AccessTokenAPI accessTokenAPI;

    @Autowired
    protected HttpRequest httpRequest;

    @Autowired
    protected ResponseHandler<JSONObject> responseHandler;

}
