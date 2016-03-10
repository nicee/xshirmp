package psn.lotus.mvc.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * http请求流操作
 *
 * @author: nicee
 * @since: 2016/2/4
 */
public interface HttpInputStream extends HttpMessage {

    /**
     * 获取http请求输入流
     *
     * @return 输入流
     */
    InputStream getInputStream() throws IOException;

}
