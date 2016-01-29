package psn.lotus.wechat.api;

import psn.lotus.wechat.param.customer.CustomerMsgRequest;

/**
 * 客服服务
 *
 * @author: nicee
 * @since: 2016/1/29
 */
public interface CustomerAPI {

    /**
     * 发送客服信息
     *
     * @param params POST数据
     */
    void sendMessage(CustomerMsgRequest params);

}
