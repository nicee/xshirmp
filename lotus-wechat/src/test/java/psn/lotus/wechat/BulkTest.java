package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.wechat.api.BulkMessageAPI;
import psn.lotus.wechat.param.BulkMessageType;
import psn.lotus.wechat.param.message.GroupRequest;

/**
 * 群发测试
 *
 * @author: nicee
 * @since: 2016/1/21
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml"})
public class BulkTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BulkMessageAPI bulkMessageAPI;

    @Test
    public void testSendCard() {
        //准备数据
        GroupRequest groupRequest = new GroupRequest();
        groupRequest.setIs_to_all(false);
        groupRequest.setGroup_id(0);
        groupRequest.setMsgtype(BulkMessageType.wxcard);
        groupRequest.setCard_id("pVLeQt6tEJywK_mzt-LZacPM2mvs");

        JSONObject result = bulkMessageAPI.sendMessageByGroup(groupRequest);
        System.out.println(result);
    }

}
