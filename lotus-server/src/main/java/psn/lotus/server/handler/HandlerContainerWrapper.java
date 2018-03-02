package psn.lotus.server.handler;

import org.springframework.util.Assert;
import psn.lotus.server.api.Handler;
import psn.lotus.server.api.HandlerContainer;

/**
 * 处理器容器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public class HandlerContainerWrapper implements HandlerContainer {

    private HandlerContainer handlerContainer;

    public HandlerContainerWrapper(HandlerContainer handlerContainer) {
        Assert.notNull(handlerContainer, "Handler container could not be null.");
        this.handlerContainer = handlerContainer;
    }

    public Handler[] getHandlers() {
        return (null == handlerContainer) ? new Handler[0] : handlerContainer.getHandlers();
    }

    public void setHandlers(Handler[] handlers) {
        handlerContainer.setHandlers(handlers);
    }

    public void addHandler(Handler handler) {
        handlerContainer.addHandler(handler);
    }

    public void removeHandler(Handler handler) {
        handlerContainer.removeHandler(handler);
    }

}
