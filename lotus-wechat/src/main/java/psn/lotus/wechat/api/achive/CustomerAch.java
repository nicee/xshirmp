package psn.lotus.wechat.api.achive;

import org.apache.http.util.Args;
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

    public void sendMessage(CustomerMsgRequest params) {
        Args.notNull(params, "customer message request params is null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_CUSTOMER_MESSAGE_URL);
        httpRequest.doPost(targetUrl, params.toString(), responseHandler);
    }

}
