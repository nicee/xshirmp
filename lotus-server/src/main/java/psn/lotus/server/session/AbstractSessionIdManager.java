package psn.lotus.server.session;

import psn.lotus.server.api.SessionIdManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 抽象的session id实现
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public abstract class AbstractSessionIdManager implements SessionIdManager {

    static final String __NEW_SESSION_ID = "psn.server.newSessionId";

    private Random random;
    private boolean weakRandom;
    private long seed = 0xffff;

    public AbstractSessionIdManager() {

    }

    public AbstractSessionIdManager(Random random) {
        this.random = random;
    }

    public boolean idInUse(String id) {
        return false;
    }

    public void addSession(HttpSession session) {

    }

    public void removeSession(HttpSession session) {

    }

    public String newSessionId(HttpServletRequest request) {
        synchronized (this) {
            if (request != null) {
                String new_id = (String) request.getAttribute(__NEW_SESSION_ID);
                if (new_id != null && idInUse(new_id))
                    return new_id;
            }

            String id = null;
            while (id == null || id.length() == 0 || idInUse(id)) {
                long r0 = weakRandom
                        ? (hashCode() ^ Runtime.getRuntime().freeMemory() ^ random.nextInt() ^ (((long) request.hashCode()) << 32))
                        : random.nextLong();
                if (r0 < 0)
                    r0 = -r0;

                if (seed > 0 && (r0 % seed) == 1L) {
                    if (random instanceof SecureRandom) {
                        SecureRandom secure = (SecureRandom) random;
                        secure.setSeed(secure.generateSeed(8));
                    } else {
                        random.setSeed(random.nextLong() ^ System.currentTimeMillis() ^ request.hashCode() ^ Runtime.getRuntime().freeMemory());
                    }
                }

                long r1 = weakRandom
                        ? (hashCode() ^ Runtime.getRuntime().freeMemory() ^ random.nextInt() ^ (((long) request.hashCode()) << 32))
                        : random.nextLong();
                if (r1 < 0)
                    r1 = -r1;
                id = Long.toString(r0, 36) + Long.toString(r1, 36);
            }

            request.setAttribute(__NEW_SESSION_ID, id);
            return id;
        }
    }
}
