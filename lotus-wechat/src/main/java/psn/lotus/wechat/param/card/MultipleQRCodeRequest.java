package psn.lotus.wechat.param.card;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 多张卡券二维码接口POST数据
 *
 * @author: nicee
 * @since: 2016/1/19
 */
public class MultipleQRCodeRequest implements Serializable {

    private static final long serialVersionUID = -3220379286350862381L;

    private final String action_name = "QR_MULTIPLE_CARD";

    private SimpleCard[] card_list;

    public String getAction_name() {
        return action_name;
    }

    public SimpleCard[] getCard_list() {
        return card_list;
    }

    public void setCard_list(SimpleCard[] card_list) {
        this.card_list = card_list;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"action_name\":\"").append(action_name).append("\",");
        buffer.append("\"action_info\":{\"multiple_card\":{\"card_list\":").append(JSONObject.toJSONString(card_list));
        buffer.append("}}}");
        return buffer.toString();
    }

    public static class SimpleCard {

        private String card_id;

        private String code;

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

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }

}
