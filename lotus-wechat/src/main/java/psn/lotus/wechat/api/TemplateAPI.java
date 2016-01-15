package psn.lotus.wechat.api;

import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/30
 */
public interface TemplateAPI {



    String getTemplateId(String templateIdShort);

    void sendMessage(Map<String, Object> requestParam);

}
