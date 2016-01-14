package psn.lotus.server.handler;

import org.apache.http.HttpResponse;
import psn.lotus.server.api.Callback;

import javax.servlet.http.HttpServletResponse;

/**
 * 服务器处理回调
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public class ServerCallback implements Callback<HttpServletResponse> {

    public HttpServletResponse callback(HttpResponse response, String charset) throws Exception {
        return null;
    }

}
