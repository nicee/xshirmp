package psn.lotus.server;

import psn.lotus.server.api.Handler;
import psn.lotus.server.api.LifeCycle;
import psn.lotus.server.api.ServerBuilder;
import psn.lotus.server.handler.HandlerContainerWrapper;

/**
 * 服务器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public class Server extends HandlerContainerWrapper implements LifeCycle {

    private psn.lotus.server.api.HandlerContainer handlerContainer;
    private ServerBuilder builder;

    public Server(ServerBuilder builder, psn.lotus.server.api.HandlerContainer handlerContainer) {
        super(handlerContainer);
        this.handlerContainer = handlerContainer;
        this.builder = builder;
    }

    public void start() throws Exception {
        Handler[] handlers = handlerContainer.getChildren();
        for (Handler handler : handlers) {
            handler.start();
        }
    }

    public void stop() throws Exception {
        Handler[] handlers = handlerContainer.getChildren();
        for (Handler handler : handlers) {
            handler.stop();
        }
    }

}
