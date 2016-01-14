package psn.lotus.server;

import org.junit.Test;
import psn.lotus.server.api.HandlerContainer;
import psn.lotus.server.api.ServerBuilder;
import psn.lotus.server.handler.HandlerWrapper;
import psn.lotus.server.handler.RealityHandlerContainer;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public class ServerTest {

    @Test
    public void test() throws Exception {
        ServerBuilder builder = new ServerBuildImpl();
        HandlerContainer handlerContainer = new RealityHandlerContainer();
        handlerContainer.addHandler(new HandlerWrapper());
        Server server = new Server(builder, handlerContainer);

        server.start();
        server.stop();
    }

}
