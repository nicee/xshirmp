package psn.lotus.server;

import psn.lotus.server.api.*;
import psn.lotus.server.handler.HandlerContainerWrapper;

/**
 * 服务器
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public class Server extends HandlerContainerWrapper implements LifeCycle {

    private HandlerContainer handlerContainer;
    private Connector connector;
    private ServerBuilder builder = new ServerBuildImpl();

    public Server(HandlerContainer handlerContainer) {
        super(handlerContainer);
        this.handlerContainer = handlerContainer;
    }

    public HandlerContainer getHandlerContainer() {
        return handlerContainer;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public ServerBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(ServerBuilder builder) {
        this.builder = builder;
    }

    public void start() throws Exception {
        Handler[] handlers = handlerContainer.getHandlers();
        for (Handler handler : handlers) {
            handler.start();
        }
        connector.open();
    }

    public void stop() throws Exception {
        Handler[] handlers = handlerContainer.getHandlers();
        for (Handler handler : handlers) {
            handler.stop();
        }
        connector.close();
    }

}
