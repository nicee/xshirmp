package psn.lotus.server.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public interface Handler extends LifeCycle, Destroyable {

    /**
     * 处理器主体
     *
     * @param request  servlet请求
     * @param response servlet响应
     * @param callback 回调处理
     * @throws Exception
     */
    <T> T handler(HttpServletRequest request, HttpServletResponse response, Callback<T> callback) throws Exception;

}
