package psn.lotus.wechat.param.message;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.BulkMessageType;

import java.io.Serializable;

/**
 * 群发消息，预览参数
 *
 * @author: nicee
 * @since: 2016/1/22
 */
public class PreviewMsgRequest implements Serializable {

    private static final long serialVersionUID = -8016322607618289805L;

    private String touser;

    private String towxname;

    private BulkMessageType msgtype;

    //image/mpnews/voice/music/mpvideo类型使用
    private String media_id;

    //text类型使用
    private String content;

    //wxcard类型使用
    private String card_id;
    private CardExt cardExt;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTowxname() {
        return towxname;
    }

    public void setTowxname(String towxname) {
        this.towxname = towxname;
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

    public CardExt getCardExt() {
        return cardExt;
    }

    public void setCardExt(CardExt cardExt) {
        this.cardExt = cardExt;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"touser\":\"").append(touser).append("\",\"msgtype\":\"").append(msgtype.name())
                .append("\",\"").append(msgtype.name()).append("\":");
        switch (msgtype) {
            case image:
            case mpnews:
            case video:
            case mpvideo:
                buffer.append("{\"media_id\":\"").append(media_id).append("\"}");
                break;
            case text:
                buffer.append("{\"content\":\"").append(content).append("\"}");
                break;
            case wxcard:
                buffer.append("{\"card_id\":\"").append(card_id).append("\",\"card_ext\":").append(cardExt.toString()).append("}");
                break;
        }
        buffer.append("}");
        return buffer.toString();
    }

    public static class CardExt implements Serializable {

        private static final long serialVersionUID = 1954888433780793885L;

        private String code;

        private String openId;

        private long timestamp;

        private String signature;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

    }
}
