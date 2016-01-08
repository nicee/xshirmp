package psn.lotus.server.http;

import psn.lotus.server.listener.CycleLifeListener;
import psn.lotus.server.listener.Listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * @author: nicee
 * @since: 2016/1/8
 */
public class HashSessionIdManager extends AbstractSessionIdManager {

    private final Map<String, Set<WeakReference<HttpSession>>> sessions = new HashMap<String, Set<WeakReference<HttpSession>>>();

    public HashSessionIdManager() {

    }

    public HashSessionIdManager(Random random) {
        super(random);
    }

    public boolean invalidateAll(String id) {
        return false;
    }

    public String getClusterId(String nodeId) {
        int dot = nodeId.lastIndexOf(".");
        return dot > 0 ? nodeId.substring(0, dot) : nodeId;
    }

    public String getNodeId(String clusterId, HttpServletRequest request) {
        String worker = (null == request) ? null : (String) request.getAttribute("psn.lotus.server.JVMRoute");
        if (null != worker) {
            clusterId += '.' + worker;
        }
        if (null != workName) {
            clusterId += workName;
        }
        return clusterId;
    }

    public Collection<HttpSession> getSessionsOnNode(String nodeId) {
        String clusterId = getClusterId(nodeId);

        return null;
    }

    public void stop() {
        sessions.clear();
        super.stop();
    }

    public boolean isStarted() {
        return false;
    }

    public boolean isPause() {
        return false;
    }

    public boolean isStop() {
        return false;
    }

    public void lifeStartListen(CycleLifeListener listener) {

    }

    public void lifePauseListen(CycleLifeListener listener) {

    }

    public void lifeRestartListen(CycleLifeListener listener) {

    }

    public void lifeStopListen(CycleLifeListener listener) {

    }

    public void addListener(Listener listener) {

    }

    public void removeListener(Listener listener) {

    }

    public void addSession(HttpSession session) {
        String id = getClusterId(session.getId());
        WeakReference<HttpSession> src = new WeakReference<HttpSession>(session);
        synchronized (this) {
            Set<WeakReference<HttpSession>> tmp = sessions.get(id);
            tmp.add(src);
            if (tmp == null) {
                tmp = new HashSet<WeakReference<HttpSession>>();
                sessions.put(id, tmp);
            }
        }
    }

    public void removeSession(HttpSession session) {
        String id = getClusterId(session.getId());
        synchronized (this) {
            Set<WeakReference<HttpSession>> tmp = sessions.get(id);
            if (null != tmp) {
                Iterator<WeakReference<HttpSession>> it = tmp.iterator();
                while (it.hasNext()) {
                    WeakReference<HttpSession> ref = it.next();
                    HttpSession s = ref.get();
                    if (null == s) {
                        it.remove();
                        continue;
                    }
                    if (s.equals(session)) {
                        it.remove();
                        break;
                    }
                }
                if (tmp.isEmpty()) {
                    sessions.remove(id);
                }
            }
        }
    }

    public HttpSession getCurrentSession(HttpServletRequest request) {
        return request.getSession();
    }

    public Collection<String> getSessionIds() {
        return Collections.unmodifiableCollection(sessions.keySet());
    }

    public Collection<HttpSession> getSession(String id) {
        List<HttpSession> session = new ArrayList<HttpSession>();
        Set<WeakReference<HttpSession>> weakReference = sessions.get(id);
        if (null != weakReference) {
            for (WeakReference<HttpSession> ref : weakReference) {
                session.add(ref.get());
            }
        }
        return session;
    }

}
