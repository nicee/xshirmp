package psn.lotus.wechat.api;

/**
 * 获取 access token
 * @author: nicee
 * @since: 2015/12/30
 */
public interface AccessTokenAPI {

    String getAccessToken();

    String replaceAccessToken(String srcUrl);

}
