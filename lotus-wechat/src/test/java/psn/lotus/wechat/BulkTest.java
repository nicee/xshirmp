package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.wechat.api.BulkMessageAPI;
import psn.lotus.wechat.param.BulkMessageType;
import psn.lotus.wechat.param.message.GroupRequest;
import psn.lotus.wechat.param.message.PreviewMsgRequest;

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

    @Test
    public void testPreview() {
        //
        PreviewMsgRequest param = new PreviewMsgRequest();
        param.setTouser("oVLeQt6uVnF97gWKgxM3nmPo4HPs");

        //测试文本
        param.setContent("预览测试消息<a href='http://www.baidu.com'>这是一个测试链接</a>");
        param.setMsgtype(BulkMessageType.text);

        //测试卡券下发
        /*param.setMsgtype(BulkMessageType.wxcard);
        param.setCard_id("pVLeQtxjPRU_hKusJ0zSMxbeu7yg");
        PreviewMsgRequest.CardExt cardExt = new PreviewMsgRequest.CardExt();
        cardExt.setCode("12345678");
        cardExt.setOpenId("oVLeQt6uVnF97gWKgxM3nmPo4HPs");
        cardExt.setTimestamp(System.currentTimeMillis());
        cardExt.setSignature(UUID.randomUUID().toString());
        param.setCardExt(cardExt);*/

        //测试图文
//        param.setMsgtype(BulkMessageType.mpnews);
//        param.setMedia_id("vrflnsZATR7Z9Tr29VHgXEflky3m-HzemR3uZprxFH8");

        //测试图片
        /*param.setMsgtype(BulkMessageType.image);
        param.setMedia_id("nvuPuFybp7PemE1mpvNnzJmsVAWs0-g5aCeXrm_ygdc");*/

        bulkMessageAPI.messagePreview(param);


    }

    @Test
    public void testStatus(){
        Integer msgId = 3123;
        //检查发送状态
        if (bulkMessageAPI.checkMsgSendStatus(msgId)) {
            System.out.println("预览消息发送成功");
        }
    }

}
