package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.BulkMessageAPI;
import psn.lotus.wechat.param.BulkMessageType;
import psn.lotus.wechat.param.message.GroupRequest;
import psn.lotus.wechat.param.message.OpenIdsRequest;
import psn.lotus.wechat.param.message.PreviewMsgRequest;

/**
 * 群发接口实现
 *
 * @author: nicee
 * @since: 2016/1/21
 */
@Service
public class BulkMessageAch extends AbstractBasedAch implements BulkMessageAPI {

    public JSONObject sendMessageByGroup(GroupRequest groupParam) {
        Args.notNull(groupParam, "Group param could not be null.");
        BulkMessageType type = groupParam.getMsgtype();
        if (type.equals(BulkMessageType.text)) {
            Args.check(groupParam.getContent() != null && !groupParam.getContent().isEmpty(), "Text message could not be empty.");
        } else if (type.equals(BulkMessageType.wxcard)) {
            Args.check(groupParam.getCard_id() != null && !groupParam.getCard_id().isEmpty(), "Card id could not be empty.");
        } else {
            Args.check(groupParam.getMedia_id() != null && !groupParam.getMedia_id().isEmpty(), "Media id is not be set.");
        }
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_MESSAGE_BY_GROUP);
        return httpRequest.doPost(targetUrl, groupParam.toString(), responseHandler);
    }

    public JSONObject sendMessageByOpenIds(OpenIdsRequest openIdsParam) {
        Args.notNull(openIdsParam, "Open ids param could not be null.");
        BulkMessageType type = openIdsParam.getMsgtype();
        if (type.equals(BulkMessageType.text)) {
            Args.notEmpty(openIdsParam.getContent(), "Text message could not be empty.");
        } else if (type.equals(BulkMessageType.wxcard)) {
            Args.notEmpty(openIdsParam.getCard_id(), "Card id could not be empty.");
        } else {
            Args.notEmpty(openIdsParam.getMedia_id(), "Media id is not be set.");
        }
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_MESSAGE_BY_OPEN_IDS);
        return httpRequest.doPost(targetUrl, openIdsParam.toString(), responseHandler);
    }

    public void messagePreview(PreviewMsgRequest msgRequest) {
        Args.notNull(msgRequest, "Preview message params could not be null.");
        BulkMessageType type = msgRequest.getMsgtype();
        if (type.equals(BulkMessageType.text)) {
            Args.notEmpty(msgRequest.getContent(), "Text message could not be empty.");
        } else if (type.equals(BulkMessageType.wxcard)) {
            Args.notEmpty(msgRequest.getCard_id(), "Card id could not be empty.");
            Args.notNull(msgRequest.getCardExt(), "Card extension params could not be null.");
        } else {
            Args.notEmpty(msgRequest.getMedia_id(), "Media id is not be set.");
        }
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.PREVIEW_MSG_URL);
        httpRequest.doPost(targetUrl, msgRequest.toString(), responseHandler);
    }

    public void removeBulkMessage(Integer msgId) {
        Args.notNull(msgId, "message id could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.DELETE_BULK_MESSAGE_URL);
        String reqParam = "{\"msg_id\":" + msgId + "\"}";
        httpRequest.doPost(targetUrl, reqParam, responseHandler);
    }

    public boolean checkMsgSendStatus(Integer msgId) {
        Args.notNull(msgId, "message id could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.CHECK_SEND_STATUS_URL);
        String reqParam = "{\"msg_id\":" + msgId + "\"}";
        JSONObject result = httpRequest.doPost(targetUrl, reqParam, responseHandler);
        return result.getString("msg_status").equals("SEND_SUCCESS");
    }


}
