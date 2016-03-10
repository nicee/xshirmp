package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.CustomerAPI;
import psn.lotus.wechat.param.customer.CustomerMsgRequest;

/**
 * @author: nicee
 * @since: 2016/1/29
 */
@Service
public class CustomerAch extends AbstractBasedAch implements CustomerAPI {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAch.class);

    public void sendMessage(CustomerMsgRequest params) {
        Args.notNull(params, "customer message request params is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_CUSTOMER_MESSAGE_URL);
        JSONObject result = httpRequest.doPost(targetUrl, params.toString(), responseHandler);
        logger.info(result.toJSONString());
    }

    public void getAllWaiter() {
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_KF_LIST);
        JSONObject result = httpRequest.doGet(targetUrl, responseHandler);
        logger.info(result.toJSONString());
    }

}
