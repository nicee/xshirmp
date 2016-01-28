package psn.lotus.open.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psn.lotus.HttpRequest;
import psn.lotus.open.api.ComponentAccessTokenAPI;

/**
 * @author: nicee
 * @since: 2016/1/25
 */
public abstract class AbstractBasedAch {

    @Autowired
    protected ComponentAccessTokenAPI componentAccessTokenAPI;

    @Autowired
    protected HttpRequest httpRequest;

    @Autowired
    protected ResponseHandler<JSONObject> responseHandler;

}
