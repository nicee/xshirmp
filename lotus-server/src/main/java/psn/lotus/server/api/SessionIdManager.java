package psn.lotus.server.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session id管理器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public interface SessionIdManager {

    /**
     * 是否正在使用
     *
     * @param id session id
     * @return true/false
     */
    boolean idInUse(String id);

    /**
     * 添加session
     *
     * @param session http会话bean
     */
    void addSession(HttpSession session);

    /**
     * 移除session
     *
     * @param session http会话bean
     */
    void removeSession(HttpSession session);

    /**
     * 创建一个新的session id
     *
     * @param request servlet请求
     * @return session id
     */
    String newSessionId(HttpServletRequest request);

}
