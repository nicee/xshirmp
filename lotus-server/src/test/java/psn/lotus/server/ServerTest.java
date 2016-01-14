package psn.lotus.server;

import org.junit.Test;
import psn.lotus.server.api.Callback;
import psn.lotus.server.api.Handler;
import psn.lotus.server.api.HandlerContainer;
import psn.lotus.server.api.ServerBuilder;
import psn.lotus.server.handler.RealityHandlerContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public class ServerTest {

    @Test
    public void test() throws Exception {
        Integer[] nums = {1};
        ServerBuilder builder = new ServerBuildImpl();
        HandlerContainer handlerContainer = new RealityHandlerContainer();
        handlerContainer.setHandler(new Handler[]{
                new Handler() {
                    public void start() throws Exception {
                        System.out.println("Start handler....");
                    }

                    public void stop() throws Exception {
                        System.out.println("Stop handler....");
                    }

                    public void handler(HttpServletRequest request, HttpServletResponse response, Callback callback) throws Exception {
                        System.out.println("doing handler....");
                    }
                }
        });
        Server server = new Server(builder, handlerContainer);

        server.start();
        server.stop();
    }

}
