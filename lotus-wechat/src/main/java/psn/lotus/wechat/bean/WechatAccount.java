package psn.lotus.wechat.bean;

import java.io.Serializable;

/**
 * @author: nicee
 * @since: 2015/12/30
 */
public class WechatAccount implements Serializable {

    private String appId;

    private String appSecret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

}
