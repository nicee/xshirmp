package psn.lotus.server.handler;

import org.springframework.util.Assert;
import psn.lotus.server.api.Handler;
import psn.lotus.server.api.HandlerContainer;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public class RealityHandlerContainer implements HandlerContainer {

    private final ConcurrentLinkedDeque<Handler> handlers = new ConcurrentLinkedDeque<Handler>();

    public RealityHandlerContainer() {

    }

    public Handler getParent() {
        return null;
    }

    public Handler[] getChildren() {
        Handler[] arrHandler = new Handler[handlers.size()];
        return handlers.toArray(arrHandler);
    }

    public void setHandlers(Handler[] handlers) {
        Assert.notNull(handlers, "handlers could not be null.");
        for (Handler handler : handlers) {
            this.handlers.add(handler);
        }
    }

    public void addHandler(Handler handler) {
        Assert.notNull(handler, "handlers could not be null.");
        handlers.add(handler);
    }

    public void removeHandler(Handler handler) {
        Assert.notNull(handler, "handlers could not be null.");
        handlers.remove(handler);
    }

}
