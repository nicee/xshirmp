package psn.lotus.server;

import psn.lotus.server.api.Connector;
import psn.lotus.server.api.Handler;
import psn.lotus.server.api.HandlerContainer;
import psn.lotus.server.handler.ConcurrentHandlerContainer;
import psn.lotus.server.handler.HandlerWrapper;
import psn.lotus.server.handler.SampleHandler;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public class ServerTest {

//    @Test
    public void test() throws Exception {
        HandlerContainer handlerContainer = new ConcurrentHandlerContainer();
        Handler handler = new HandlerWrapper(new SampleHandler());
        handlerContainer.addHandler(handler);
        Server server = new Server(handlerContainer);

        Connector connector = new SocketConnector();
        server.setConnector(connector);

        server.start();
        server.stop();
    }

}
