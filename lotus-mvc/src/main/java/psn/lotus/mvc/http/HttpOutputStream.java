package psn.lotus.mvc.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * HTTP输出流操作
 *
 * @author: nicee
 * @since: 2016/2/4
 */
public interface HttpOutputStream extends HttpMessage {

    /**
     * 获取HTTP请求输出流
     * @return
     * @throws IOException
     */
    OutputStream getOutputStream() throws IOException;

}
