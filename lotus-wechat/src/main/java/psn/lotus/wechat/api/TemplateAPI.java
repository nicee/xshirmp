package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.template.TemplateRequest;

/**
 * 模板消息微信接口
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public interface TemplateAPI {

    /**
     * 创建并获取模板ID
     *
     * @param templateIdShort 微信固定模板简短ID
     * @return 模板ID
     */
    String getTemplateId(String templateIdShort);

    /**
     * 发送模板消息
     *
     * @param requestParam 模板请求数据
     */
    JSONObject sendMessage(TemplateRequest requestParam);

}
