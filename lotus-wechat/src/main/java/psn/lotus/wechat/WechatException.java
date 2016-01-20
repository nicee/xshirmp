package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信异常
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public class WechatException extends RuntimeException {

    private String errcode;

    private String message;

    public WechatException(String errcode, String message) {
        this(errcode, message, null);
    }

    public WechatException(String errcode, String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
