package psn.lotus.wechat.error;

import psn.lotus.wechat.WechatException;

/**
 * 微信错误信息码解析
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public interface WechatError<T> {

    /**
     * 解析微信错误码
     *
     * @param response http返回数据对象
     * @throws WechatException 微信错误异常
     */
    void resolveCode(T response) throws WechatException;

}
