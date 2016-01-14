package psn.lotus.server.handler;

import psn.lotus.server.api.Handler;
import psn.lotus.server.api.HandlerContainer;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public abstract class AbstractHandlerContainer implements HandlerContainer {

    private HandlerContainer handlerContainer;

    public AbstractHandlerContainer(HandlerContainer handlerContainer) {
        this.handlerContainer = handlerContainer;
    }

    public Handler getParent() {
        return handlerContainer.getParent();
    }

    public Handler[] getChildren() {
        return handlerContainer.getChildren();
    }

    public void setHandler(Handler[] handlers) {
        handlerContainer.setHandler(handlers);
    }

}
