package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.card.LandingPageRequest;
import psn.lotus.wechat.param.card.MultipleQRCodeRequest;
import psn.lotus.wechat.param.card.SingleQRCodeRequest;

import java.util.Map;

/**
 * 微信卡券接口
 *
 * @author: nicee
 * @since: 2016/1/19
 */
public interface CardAPI {

    /**
     * 投放单张Card，生成一个二维码，用户扫描获取卡券
     *
     * @param requestParam 单张二维码POST数据
     */
    JSONObject deliveredToSingleQRCode(SingleQRCodeRequest requestParam);

    /**
     * 投放多张Card，生成一个二维码，用户扫描获取卡券
     *
     * @param requestParam 多张二维码POST数据
     */
    JSONObject deliveredToMultipleQRCode(MultipleQRCodeRequest requestParam);

    /**
     * 创建货架，生成的URL只能在微信客户端中打开，用户选择想要的卡券即可
     *
     * @param requestParam 货架POST数据
     * @return 货架描述，包含货架链接(key = url),货架ID(key = page_id)，投放只要使用url即可
     */
    Map<String, String> createLandingPage(LandingPageRequest requestParam);

    /**
     * 根据card id创建对应的图文信息
     *
     * @param cardId 卡券ID
     * @return 图文链接地址
     */
    String getMPNews(String cardId);

}
