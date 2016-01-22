package psn.lotus.wechat.param.message;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.BulkMessageType;

import java.io.Serializable;

/**
 * 按open id群发
 *
 * @author: nicee
 * @since: 2016/1/21
 */
public class OpenIdsRequest implements Serializable {

    private static final long serialVersionUID = -2065150978222246840L;

    private String[] touser;

    private BulkMessageType msgtype;

    private String content;

    //image/mpnews/voice/video类型消息使用
    private String media_id;

    //video类型使用
    private String title;
    private String description;

    //wxcard类型使用
    private String card_id;

    public String[] getTouser() {
        return touser;
    }

    public void setTouser(String[] touser) {
        this.touser = touser;
    }

    public BulkMessageType getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(BulkMessageType msgtype) {
        this.msgtype = msgtype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"touser\":[").append(JSONObject.toJSONString(touser)).append("],\"msgtype\":\"").append(msgtype.name())
                .append("\",\"").append(msgtype.name()).append("\":");
        switch (msgtype) {
            case image:
            case mpnews:
            case voice:
                buffer.append("{\"media_id\":\"").append(media_id).append("\"}");
                break;
            case mpvideo:
            case video:
                buffer.append("{\"media_id\":\"").append(media_id).append("\",\"title\":\"");
                buffer.append(title).append("\",\"description\":\"").append(description).append("\"}");
                break;
            case text:
                buffer.append("{\"content\":\"").append(content).append("\"}");
                break;
            case wxcard:
                buffer.append("{\"card_id\":\"").append(card_id).append("\"}");
                break;
        }
        buffer.append("}");
        return buffer.toString();
    }
}
