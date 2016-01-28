package psn.lotus.aspectj.config;

import java.io.Serializable;

/**
 * 代理配置项
 *
 * @author: nicee
 * @since: 2016/1/27
 */
public class ProxyConfig implements Serializable {

    private static final long serialVersionUID = -3813603360142014410L;

    private boolean enableProxy = false;

    boolean opaque = false;

    public boolean isEnableProxy() {
        return enableProxy;
    }

    public void setEnableProxy(boolean enableProxy) {
        this.enableProxy = enableProxy;
    }

    public boolean isOpaque() {
        return opaque;
    }

    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

}
