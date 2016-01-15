package psn.lotus.wechat;

/**
 * 微信接口url
 *
 * @author: nicee
 * @since: 2016/1/15
 */
public interface Urls {

    /**
     * 获取access token
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //-------------------------------------- 消息管理 url --------------------------------------

    /**
     *
     */
    String SETTING_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";

    String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";

    String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";


}
