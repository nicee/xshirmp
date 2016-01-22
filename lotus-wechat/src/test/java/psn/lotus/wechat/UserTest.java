package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.wechat.api.UserAPI;

/**
 * @author: nicee
 * @since: 2016/1/21
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml"})
public class UserTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserAPI userAPI;

    @Test
    public void testGroup() {
        JSONObject result = userAPI.getAllGroup();
        System.out.println(result);
    }

}
