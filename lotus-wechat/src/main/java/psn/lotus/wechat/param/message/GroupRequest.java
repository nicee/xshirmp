package psn.lotus.wechat.param.message;

import psn.lotus.wechat.param.BulkMessageType;

import java.io.Serializable;

/**
 * 分组消息
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public class GroupRequest implements Serializable {

    private static final long serialVersionUID = 4846549603368994164L;

    private boolean is_to_all;

    private Integer group_id;

    private BulkMessageType msgtype;

    //image/mpnews/voice/video类型消息使用
    private String media_id;

    //text类型消息使用
    private String content;

    //wxcard类型消息使用
    private String card_id;

    public boolean is_to_all() {
        return is_to_all;
    }

    public void setIs_to_all(boolean is_to_all) {
        this.is_to_all = is_to_all;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public BulkMessageType getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(BulkMessageType msgtype) {
        this.msgtype = msgtype;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        buffer.append("{\"filter\":{\"is_to_all\":").append(is_to_all).append(",\"group_id\":\"").append(group_id)
                .append("\"},\"msgtype\":\"").append(msgtype.name()).append("\",\"").append(msgtype.name()).append("\":");
        switch (msgtype) {
            case video:
            case image:
            case mpnews:
            case voice:
            case mpvideo:
                buffer.append("{\"media_id\":\"").append(media_id).append("\"}");
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
