package psn.lotus.server.handler;

import org.apache.http.HttpResponse;
import org.springframework.util.Assert;
import psn.lotus.server.AbstractLifeCycle;
import psn.lotus.server.api.Callback;
import psn.lotus.server.api.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象处理器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public abstract class AbstractHandler extends AbstractLifeCycle implements Handler {

    /**
     * 实际的处理器
     */
    private Handler handler;

    public AbstractHandler(Handler handler) {
        Assert.notNull("handler could not be null.");
        this.handler = handler;
    }

    public Object handler(HttpServletRequest request, HttpServletResponse response, Callback callback) throws Exception {
        Assert.notNull("handler could not be null.");
        if (callback == null) {
            callback = DefaultCallback.getInstance();
        }
        return handler.handler(request, response, callback);
    }

    public void start() throws Exception {
        super.start();
    }

    public void stop() throws Exception {
        super.stop();
    }

    private static final class DefaultCallback implements Callback {

        static final Callback callback = new DefaultCallback();

        private DefaultCallback() {
        }

        public Object callback(HttpResponse response, String charset) throws Exception {
            return null;
        }

        public static final Callback getInstance() {
            return callback;
        }
    }

}
