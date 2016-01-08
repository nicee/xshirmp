package psn.lotus.server.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Http Session基础管理
 *
 * @author: nicee
 * @since: 2016/1/7
 */
public interface SessionAware {

    /**
     * 添加session
     *
     * @param session http session
     */
    void addSession(HttpSession session);

    /**
     * 移除session
     *
     * @param session http session
     */
    void removeSession(HttpSession session);

    /**
     * 获取当前session
     *
     * @param request http session
     * @return http session
     */
    HttpSession getCurrentSession(HttpServletRequest request);

}
