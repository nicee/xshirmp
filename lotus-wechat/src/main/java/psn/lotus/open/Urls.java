package psn.lotus.open;

/**
 * @author: nicee
 * @since: 2016/1/25
 */
public interface Urls {

    //-------------------------------------- 第三方开放平台基础管理 url --------------------------------------

    String GET_COMPONENT_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";

    //-------------------------------------- 第三方协助制券管理 url --------------------------------------

    /**
     * 上传卡券代理资质
     */
    String UPLOAD_CARD_AGENT_QUALIFICATION = "http://api.weixin.qq.com/cgi-bin/component/upload_card_agent_qualification?access_token=COMPONENT_ACCESS_TOKEN";

    /**
     * 获取审核代理资质结果
     */
    String CHECK_CARD_AGENT_QUALIFICATION = "http://api.weixin.qq.com/cgi-bin/component/check_card_agent_qualification?access_token=COMPONENT_ACCESS_TOKEN";

    /**
     * 上传（子）商户资质
     */
    String UPLOAD_CARD_MERCHANT_QUALIFICATION = "http://api.weixin.qq.com/cgi-bin/component/upload_card_merchant_qualification?access_token=COMPONENT_ACCESS_TOKEN";

    /**
     * 获取（子）商户资质审核结果
     */
    String CHECK_CARD_MERCHANT_QUALIFICATION = "http://api.weixin.qq.com/cgi-bin/component/check_card_merchant_qualification?access_token=COMPONENT_ACCESS_TOKEN";

    /**
     * 上传临时媒体文件
     */
    String MEDIA_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=COMPONENT_ACCESS_TOKEN&type=TYPE";

    /**
     * 卡券开放类目查询
     */
    String GET_APPLY_PROTOCOL = "https://api.weixin.qq.com/card/getapplyprotocol?access_token=COMPONENT_ACCESS_TOKEN";

    /**
     * 获取单个子商户信息
     */
    String GET_CARD_MERCHANT = "http:// api.weixin.qq.com/cgi-bin/component/get_card_merchant？access_token=COMPONENT_ACCESS_TOKEN";

    /**
     * 批量获取子商户信息
     */
    String BATCH_GET_CARD_MERCHANT = "http://api.weixin.qq.com/cgi-bin/component/batchget_card_merchant?access_token=COMPONENT_ACCESS_TOKEN";

}
