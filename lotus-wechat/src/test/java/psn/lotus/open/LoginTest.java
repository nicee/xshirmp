package psn.lotus.open;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.HttpRequest;

import java.net.URL;
import java.util.UUID;

/**
 * @author: nicee
 * @since: 2016/1/27
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml"})
public class LoginTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected HttpRequest httpRequest;

    @Autowired
    protected ResponseHandler<JSONObject> responseHandler;

    @Deprecated
    @Test(enabled = false)
    public void testCode() {
        String appId = "wxfd795ae97fb9aaf5";
        String redirectUri = "http%3A%2F%2Fwww.wxloong.com%2Fwx%2F%23%2FgetRedirectAuth";
        String state = UUID.randomUUID().toString();
        String srcUrl = "https://open.weixin.qq.com/connect/qrconnect?appid=" + appId + "&redirect_uri=" + redirectUri +
                "&response_type=code&scope=snsapi_login&state=" + state + "#wechat_redirect";

        JSONObject result = httpRequest.doGet(srcUrl, responseHandler);

        System.out.println(result);
    }

    @Test
    public void test() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls);
        }
    }

}
