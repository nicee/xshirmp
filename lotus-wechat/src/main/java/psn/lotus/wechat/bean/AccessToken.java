package psn.lotus.wechat.bean;

import java.io.Serializable;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public class AccessToken implements Serializable {

    private static final long serialVersionUID = -7266796596850087546L;

    private String accessToken;

    private long expiresIn;

    private long endTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        this.setEndTime(System.currentTimeMillis() + this.expiresIn * 1000 - 20000);
    }

    public long getEndTime() {
        return endTime;
    }

    private void setEndTime(long endTime) {
        this.endTime = endTime;
    }

}
