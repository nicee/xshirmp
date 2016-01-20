package psn.lotus.wechat.param.message;

import psn.lotus.wechat.param.MediaType;

import java.io.Serializable;

/**
 * 分组消息
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public class GroupMessage implements Serializable {

    private static final long serialVersionUID = 4846549603368994164L;

    private boolean is_to_all;

    private Integer group_id;

    private MediaType msgtype;

    private String media_id;

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

    public MediaType getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(MediaType msgtype) {
        this.msgtype = msgtype;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"filter\":{\"is_to_all\":").append(is_to_all).append(",\"group_id\":\"").append(group_id).append("\"},\"").append(msgtype).append("\":{\"media_id\":\"").append(media_id)
                .append("\"},\"msgtype\":\"").append(msgtype).append("\"}");
        return buffer.toString();
    }

}
