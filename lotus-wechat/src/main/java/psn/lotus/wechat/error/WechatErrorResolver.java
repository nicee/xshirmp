package psn.lotus.wechat.error;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import psn.lotus.wechat.WechatException;

/**
 * 微信错误码解析实现
 *
 * @author: nicee
 * @since: 2016/1/19
 */
@Component
public final class WechatErrorResolver implements WechatError<JSONObject> {

    private static final Logger logger = LoggerFactory.getLogger(WechatErrorResolver.class);

    public void resolveCode(JSONObject response) throws WechatException {
        if (response == null || !response.containsKey("errcode")) return;
        String errCode = response.getString("errcode");
        if (!errCode.equals("0")) {
            String errMsg = response.getString("errmsg");
            if (logger.isErrorEnabled()) {
                logger.error("微信接口调用失败，错误码为{}，错误原因为{}", errCode, errMsg);
            }
            throw new WechatException(errCode, errMsg);
        }
    }

}
