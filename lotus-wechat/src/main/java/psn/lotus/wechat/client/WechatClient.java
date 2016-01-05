package psn.lotus.wechat.client;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import psn.lotus.wechat.HttpRequest;
import psn.lotus.wechat.HttpRequestFactory;
import psn.lotus.wechat.ResponseHttpHandler;
import psn.lotus.wechat.bean.AccessToken;
import psn.lotus.wechat.bean.WechatAccount;
import psn.lotus.wechat.error.WechatError;
import psn.lotus.wechat.error.WechatErrorResolver;

import java.io.InputStream;
import java.util.Properties;

import static psn.lotus.wechat.error.ErrorMessage.ACCESS_TOKEN_INVALID;
import static psn.lotus.wechat.error.ErrorMessage.LOAD_PROPERTIES_FAILURE;
import static psn.lotus.wechat.url.BaseRequestUrl.GET_ACCESS_TOKEN_URL;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public abstract class WechatClient implements WechatError {

    static final String DEFAULT_CONFIG = "wechat.properties";

    static final Logger logger = LoggerFactory.getLogger(WechatClient.class);

    static final WechatAccount wAccount = new WechatAccount();

    static final AccessToken accessToken = new AccessToken();

    @Autowired
    private WechatErrorResolver errorResolver;

    private boolean loaded = false;

    private HttpRequest httpRequest;

    public WechatClient() {
        this(HttpRequestFactory.getHttpRequest());
    }

    public WechatClient(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        initWxAccount();
    }

    public Exception getError(String code) {
        return errorResolver.resolveCode(code);
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public String replaceAccessToken(String srcUrl) {
        if (!isAccessTokenUsable()) {
            if (logger.isInfoEnabled()) {
                logger.info(ACCESS_TOKEN_INVALID, accessToken.getAccessToken());
            }
            askAccessToken();
        }
        return srcUrl.replace("ACCESS_TOKEN", accessToken.getAccessToken());
    }

    private boolean isAccessTokenUsable() {
        return loaded && System.currentTimeMillis() < accessToken.getEndTime();
    }

    private void askAccessToken() {
        String accessTokenUrl = GET_ACCESS_TOKEN_URL.replace("APPID", wAccount.getAppId()).replace("APPSECRET", wAccount.getAppSecret());
        JSONObject content = httpRequest.doGet(accessTokenUrl, ResponseHttpHandler.DEFAULTE_RESPONSE_HANDLER);
        accessToken.setExpiresIn((Long) content.get("expires_in"));
        //accessToken.setExpiresIn(new Integer(7200));
        //accessToken.setAccessToken("-P15wAOYW3NAW6rzvBdu6J0I0Ew8BQMgenWiCMDuwSYtKZqZO2hqJ0pyBfqe7HyumBHu-HMsRS1qpEfdELnzZ8DA93ij2xKljHqR_gFLGq8OWTdAAASAX");
        accessToken.setAccessToken((String) content.get("access_token"));
        loaded = true;
    }

    private void initWxAccount() {
        ClassLoader classLoader = getClassLoad();
        InputStream inputStream = classLoader.getResourceAsStream(DEFAULT_CONFIG);
        Properties config = loadProperties(inputStream);
        wrapAccount(config);
        config.clear();
    }

    private ClassLoader getClassLoad() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (null == classLoader) {
            classLoader = WechatClient.class.getClassLoader();
        }
        return classLoader;
    }

    private Properties loadProperties(InputStream inputStream) {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            if (logger.isInfoEnabled()) {
                logger.info(LOAD_PROPERTIES_FAILURE, DEFAULT_CONFIG, e);
            }
        }
        return properties;
    }

    private void wrapAccount(Properties config) {
        wAccount.setAppId(config.getProperty("app_id"));
        wAccount.setAppSecret(config.getProperty("app_secret"));
    }

}
