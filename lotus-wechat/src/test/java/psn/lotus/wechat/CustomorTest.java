package psn.lotus.wechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.wechat.api.CustomerAPI;
import psn.lotus.wechat.param.CustomerMsgType;
import psn.lotus.wechat.param.customer.CustomerMsgRequest;

/**
 * @author: nicee
 * @since: 2016/2/1
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml"})
public class CustomorTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CustomerAPI customerAPI;

    @Test
    public void testSendText() {
        CustomerMsgRequest message = new CustomerMsgRequest();
        message.setTouser("oVLeQt6uVnF97gWKgxM3nmPo4HPs");
        message.setMsgtype(CustomerMsgType.text);
        message.setContent("测试客服消息");
        customerAPI.sendMessage(message);
    }


    @Test
    public void testSendImage() {
        CustomerMsgRequest message = new CustomerMsgRequest();
        message.setMsgtype(CustomerMsgType.image);
        message.setTouser("oVLeQt6uVnF97gWKgxM3nmPo4HPs");
        message.setMedia_id("nvuPuFybp7PemE1mpvNnzDFE31xufOK9A81HlJLLhaA");
        customerAPI.sendMessage(message);
    }

    @Test
    public void testGetAll() {
        customerAPI.getAllWaiter();
    }



}
