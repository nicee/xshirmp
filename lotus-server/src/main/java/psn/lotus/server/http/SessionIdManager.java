package psn.lotus.server.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * session id管理
 *
 * @author: nicee
 * @since: 2016/1/7
 */
public interface SessionIdManager extends SessionAware, ClusterSession {

    /**
     * session id是否已包含
     *
     * @param id session id
     * @return true 已包含；false 不包含
     */
    boolean containsId(String id);

    /**
     * session id是否正在使用
     *
     * @param id session id
     * @return true 正在运行；false 未运行或者不存在
     */
    boolean idInUse(String id);

    /**
     * 创建session id
     *
     * @param request http请求
     * @param time    session有效期时间
     * @return session值
     */
    String createSessionId(HttpServletRequest request, long time);

    /**
     * 获取对应session id的所有session
     *
     * @param id session id
     * @return session集合
     */
    Collection<HttpSession> getSession(String id);

    /**
     * 获取所有的session
     *
     * @return session id集合
     */
    Collection<String> getSessionIds();

}
