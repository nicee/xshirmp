package psn.lotus.server.handler;

import psn.lotus.server.api.Callback;
import psn.lotus.server.api.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理器包装类
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public class SampleHandler implements Handler {

    public SampleHandler() {
    }

    public void destroy() throws Exception {
        System.out.println("Destroy handler....");
    }

    public <T> T handler(HttpServletRequest request, HttpServletResponse response, Callback<T> callback) throws Exception {
        System.out.println("doing handler....");
        return null;
    }

    public void start() throws Exception {
        System.out.println("Start handler....");
    }

    public void stop() throws Exception {
        System.out.println("Stop handler....");
    }

}
