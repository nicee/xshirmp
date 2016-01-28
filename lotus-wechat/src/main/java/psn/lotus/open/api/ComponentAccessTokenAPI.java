package psn.lotus.open.api;

/**
 * 获取component access token
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public interface ComponentAccessTokenAPI {

    /**
     * 获取component access token
     *
     * @return 令牌
     */
    String getComponentAccessToken();

    /**
     * 使用component access token替换默认占位符
     *
     * @param srcUrl 微信接口地址
     * @return 替换令牌后的接口地址
     */
    String replaceComponentAccessToken(String srcUrl);

}
