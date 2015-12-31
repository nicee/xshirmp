package psn.lotus.wechat;

/**
 * @author: nicee
 * @since: 2015/12/30
 */
public class WechatException extends RuntimeException {

    private String message;

    public WechatException(String message) {
        this(message, null);
    }

    public WechatException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
