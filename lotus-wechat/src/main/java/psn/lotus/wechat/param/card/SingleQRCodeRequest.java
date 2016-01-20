package psn.lotus.wechat.param.card;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 单张卡券二维码接口POST数据
 *
 * @author: nicee
 * @since: 2016/1/19
 */
public class SingleQRCodeRequest implements Serializable {

    private static final long serialVersionUID = 7590149430551841701L;

    private final String action_name = "QR_CARD";

    private long expire_seconds;

    private SingleCard card;

    public String getAction_name() {
        return action_name;
    }

    public long getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(long expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public SingleCard getCard() {
        return card;
    }

    public void setCard(SingleCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"action_name\":\"").append(action_name).append("\",");
        buffer.append("\"expire_seconds\":").append(expire_seconds).append(",");
        buffer.append("\"action_info\":{\"card\":").append(JSONObject.toJSONString(card));
        buffer.append("}}");
        return buffer.toString();
    }

    public static class SingleCard {

        private String card_id;

        private String code;

        private String openid;

        private Boolean is_unique_code;

        private Integer outer_id;

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public Boolean getIs_unique_code() {
            return is_unique_code;
        }

        public void setIs_unique_code(Boolean is_unique_code) {
            this.is_unique_code = is_unique_code;
        }

        public Integer getOuter_id() {
            return outer_id;
        }

        public void setOuter_id(Integer outer_id) {
            this.outer_id = outer_id;
        }

    }
}
