package psn.lotus.wechat.error;

/**
 * @author: nicee
 * @since: 2015/12/30
 */
public interface WechatErrorResolver {

    Exception resolveCode(String code);

}
