package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.message.GroupMessage;

/**
 * 群发接口实现
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public interface BulkMessageAPI {

    JSONObject sendMessageByGroup(GroupMessage message);
    
}
