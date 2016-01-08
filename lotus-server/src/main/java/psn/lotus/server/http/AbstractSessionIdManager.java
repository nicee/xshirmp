package psn.lotus.server.http;

import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 抽象session id管理器
 *
 * @author: nicee
 * @since: 2016/1/8
 */
public abstract class AbstractSessionIdManager implements SessionIdManager, CycleLife {

    static final String SESSION_ID = "psn.lotus.server.session.newId";

    protected Random random;

    protected String workName;

    protected boolean weak;

    public AbstractSessionIdManager() {

    }

    public AbstractSessionIdManager(Random random) {
        this.random = random;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean containsId(String id) {
        return false;
    }

    public boolean idInUse(String id) {
        return false;
    }

    public String createSessionId(HttpServletRequest request, long time) {
        synchronized (this) {
            //1. 从request中获取session id
            if (request != null) {
                String requestId = request.getRequestedSessionId();
                if (requestId != null) {
                    String clusterId = getClusterId(requestId);
                    if (idInUse(clusterId)) {
                        return clusterId;
                    }
                }

                String local = (String) request.getAttribute(SESSION_ID);
                if (local != null && idInUse(local)) {
                    return local;
                }
            }

            //2. 非request，随机创建session id
            return randomSessionId(request, time);
        }
    }

    public void start() {

    }

    public void restart() {

    }

    public void pause() {

    }

    public void pause(long time) {

    }

    public void stop() {

    }

    /**
     * 随机生成session id
     *
     * @param request http request
     * @param time    有效时间
     * @return session id
     */
    private String randomSessionId(HttpServletRequest request, long time) {
        String id = null;
        while (id == null || id.length() == 0 || idInUse(id)) {
            long r0 = weak ? (hashCode() ^ Runtime.getRuntime().totalMemory() ^ random.nextLong() ^ ((long) request.hashCode() << 16) ^ time)
                    : random.nextLong();
            if (r0 < 0) r0 = -r0;
            if (random instanceof SecureRandom) {
                SecureRandom secure = (SecureRandom) random;
                secure.setSeed(secure.generateSeed(8));
            } else {
                random.setSeed(random.nextLong() ^ System.currentTimeMillis() ^ request.hashCode() ^ Runtime.getRuntime().totalMemory());
            }
            long r1 = weak ? (hashCode() ^ Runtime.getRuntime().totalMemory() ^ random.nextLong() ^ ((long) request.hashCode() << 16) ^ time)
                    : random.nextLong();
            if (r1 < 0) r1 = -r1;
            //session id 64 bits
            id = Long.toString(r0, 36).concat(Long.toString(r1, 36));
            if (workName != null) {
                id = workName.concat(id);
            }
        }
        return id;
    }

}
