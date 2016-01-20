package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.wechat.api.CardAPI;
import psn.lotus.wechat.param.card.LandingPageRequest;
import psn.lotus.wechat.param.card.MultipleQRCodeRequest;
import psn.lotus.wechat.param.card.MultipleQRCodeRequest.SimpleCard;
import psn.lotus.wechat.param.card.SingleQRCodeRequest;
import psn.lotus.wechat.param.card.SingleQRCodeRequest.SingleCard;

import java.awt.*;
import java.net.URI;
import java.util.Map;

/**
 * 卡券接口测试
 *
 * @author: nicee
 * @since: 2016/1/19
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml"})
public class CardTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CardAPI cardAPI;

    @Test
    public void testQRCodeSingle() throws Exception {
        SingleQRCodeRequest request = new SingleQRCodeRequest();
        request.setExpire_seconds(2000);

        SingleCard singleCard = new SingleCard();
        singleCard.setCard_id("pVLeQt6tEJywK_mzt-LZacPM2mvs");
        singleCard.setIs_unique_code(false);
        singleCard.setOuter_id(1);

        request.setCard(singleCard);
        JSONObject result = cardAPI.deliveredToSingleQRCode(request);
        System.out.println(result.toJSONString());
        Desktop.getDesktop().browse(new URI(result.getString("show_qrcode_url")));
    }

    @Test
    public void testQRCodeMultiple() throws Exception {
        MultipleQRCodeRequest request = new MultipleQRCodeRequest();

        SimpleCard card = new SimpleCard();
        card.setCard_id("pVLeQt6tEJywK_mzt-LZacPM2mvs");

        request.setCard_list(new SimpleCard[]{card});
        JSONObject result = cardAPI.deliveredToMultipleQRCode(request);
        System.out.println(result.toJSONString());
        Desktop.getDesktop().browse(new URI(result.getString("show_qrcode_url")));
    }

    @Test
    public void testCreateLandingPage() {
        LandingPageRequest request = new LandingPageRequest();
        request.setBanner("http://a.hiphotos.baidu.com/image/h%3D200/sign=febfa19b4ded2e73e3e9812cb700a16d/f7246b600c338744233d6163560fd9f9d72aa031.jpg");
        request.setPage_title("货架测试");
        request.setCan_share(true);
        request.setScene(LandingPageRequest.Scene.SCENE_H5);

        LandingPageRequest.ThumbCard thumbCard = new LandingPageRequest.ThumbCard();
        thumbCard.setCard_id("pVLeQt6tEJywK_mzt-LZacPM2mvs");
        thumbCard.setThumb_url("http://f.hiphotos.baidu.com/image/h%3D300/sign=560bd04b044f78f09f0b9cf349300a83/63d0f703918fa0eca51c2a12219759ee3c6ddbd2.jpg");

        request.setCard_list(new LandingPageRequest.ThumbCard[]{thumbCard});
        Map<String, String> result = cardAPI.createLandingPage(request);
        System.out.println(JSONObject.toJSONString(result));
    }


    @Test
    public void testGetMPNews() {
        String cardId = "pVLeQt6tEJywK_mzt-LZacPM2mvs";
        String link = cardAPI.getMPNews(cardId);
        System.out.println(link);
    }

}
