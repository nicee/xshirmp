package psn.lotus.server;

import psn.lotus.server.api.Handler;
import psn.lotus.server.api.HandlerContainer;
import psn.lotus.server.api.LifeCycle;
import psn.lotus.server.api.ServerBuilder;
import psn.lotus.server.handler.AbstractHandlerContainer;

/**
 * 服务器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public class Server extends AbstractHandlerContainer implements LifeCycle {

    private HandlerContainer handlerContainer;
    private ServerBuilder builder;

    public Server(ServerBuilder builder, HandlerContainer handlerContainer) {
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
