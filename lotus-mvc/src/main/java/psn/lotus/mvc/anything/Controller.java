package psn.lotus.mvc.anything;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制器
 *
 * @author: nicee
 * @since: 2016/2/1
 */
public interface Controller {

    /**
     * 处理HTTP请求
     *
     * @param request  http请求
     * @param response http响应
     * @return 暂定Object
     * @throws Exception 处理过程发生的异常
     */
    Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
