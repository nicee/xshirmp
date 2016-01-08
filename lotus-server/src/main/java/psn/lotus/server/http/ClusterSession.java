package psn.lotus.server.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * 管理集群session
 *
 * @author: nicee
 * @since: 2016/1/7
 */
public interface ClusterSession {

    /**
     * 使集群中所有session id失效
     *
     * @param id 目标session id
     * @return true 成功；false 失败
     */
    boolean invalidateAll(String id);

    /**
     * 获取集群节点名称
     *
     * @param nodeId 集群nodeid
     * @return 集群节点名称
     */
    String getClusterId(String nodeId);

    /**
     * 获取集群节点对应的session id
     *
     * @param clusterId 集群节点id
     * @param request   http请求
     * @return session id
     */
    String getNodeId(String clusterId, HttpServletRequest request);

    /**
     * 获取集群节点上session集合
     *
     * @param nodeId 集群节点id
     * @return session集合
     */
    Collection<HttpSession> getSessionsOnNode(String nodeId);

}
