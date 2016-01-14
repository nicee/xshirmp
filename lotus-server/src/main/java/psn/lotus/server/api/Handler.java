package psn.lotus.server.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public interface Handler extends LifeCycle {

    /**
     * 处理器主体
     *
     * @param request  servlet请求
     * @param response servlet响应
     * @param callback 回调处理
     * @throws Exception
     */
    void handler(HttpServletRequest request, HttpServletResponse response, Callback callback) throws Exception;

}
