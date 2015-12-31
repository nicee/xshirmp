package psn.lotus.wechat.url;

import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/30
 */
public interface TemplateAPI {

    String SETTING_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";

    String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";

    String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    String getTemplateId(String templateIdShort);

    void sendMessage(Map<String, Object> requestParam);

}
