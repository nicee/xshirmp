package psn.lotus.server.handler;

import psn.lotus.server.api.Handler;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public class HandlerContainerWrapper implements psn.lotus.server.api.HandlerContainer {

    private psn.lotus.server.api.HandlerContainer handlerContainer;

    public HandlerContainerWrapper(psn.lotus.server.api.HandlerContainer handlerContainer) {
        this.handlerContainer = handlerContainer;
    }

    public Handler getParent() {
        return handlerContainer.getParent();
    }

    public Handler[] getChildren() {
        return handlerContainer.getChildren();
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
