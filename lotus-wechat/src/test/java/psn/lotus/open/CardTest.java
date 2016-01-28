package psn.lotus.open;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.open.api.CardAPI;
import psn.lotus.open.param.card.SubMerchant;

/**
 * @author: nicee
 * @since: 2016/1/25
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml"})
public class CardTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CardAPI cardAPI;

    @Test
    public void test() {
        SubMerchant[] merchants = cardAPI.getSubMerchants(null);
        System.out.println(JSONObject.toJSONString(merchants));
    }

}
