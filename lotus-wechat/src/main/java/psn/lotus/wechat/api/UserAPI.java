package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;

/**
 * 用户管理
 *
 * @author: nicee
 * @since: 2016/1/21
 */
public interface UserAPI {

    /**
     * 获取当前公众号底下所有的分组信息
     *
     * @return
     */
    JSONObject getAllGroup();

}
