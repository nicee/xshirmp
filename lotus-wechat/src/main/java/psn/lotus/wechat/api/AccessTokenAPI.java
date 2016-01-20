package psn.lotus.wechat.api;

/**
 * 获取 access token
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public interface AccessTokenAPI {

    /**
     * 获取access token
     *
     * @return 令牌
     */
    String getAccessToken();

    /**
     * 使用access token替换默认占位符
     *
     * @param srcUrl 微信接口地址
     * @return 替换令牌后的接口地址
     */
    String replaceAccessToken(String srcUrl);

}
