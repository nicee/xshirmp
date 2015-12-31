package psn.lotus.wechat.error;

/**
 * @author: nicee
 * @since: 2015/12/30
 */
public interface WechatError {

    Exception getError(String code);

}
