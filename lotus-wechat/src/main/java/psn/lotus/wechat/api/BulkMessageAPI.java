package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.message.GroupRequest;
import psn.lotus.wechat.param.message.OpenIdsRequest;
import psn.lotus.wechat.param.message.PreviewMsgRequest;

/**
 * 群发接口实现
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public interface BulkMessageAPI {

    /**
     * 按组发送信息
     *
     * @param groupParam 组参数
     * @return 响应数据
     */
    JSONObject sendMessageByGroup(GroupRequest groupParam);

    /**
     * 按open id发送消息
     *
     * @param openIdsParam open id参数
     * @return 响应数据
     */
    JSONObject sendMessageByOpenIds(OpenIdsRequest openIdsParam);

    /**
     * 群发信息预览
     *
     * @param msgRequest 预览参数
     */
    void messagePreview(PreviewMsgRequest msgRequest);

    /**
     * 删除群发消息
     *
     * @param msgId 消息ID
     */
    void removeBulkMessage(Integer msgId);

    /**
     * 检查消息发送状态
     *
     * @param msgId 消息ID
     * @return true 发送成功；false 发送失败
     */
    boolean checkMsgSendStatus(Integer msgId);

}
