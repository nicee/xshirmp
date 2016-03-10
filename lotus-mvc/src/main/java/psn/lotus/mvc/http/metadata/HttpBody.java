package psn.lotus.mvc.http.metadata;

import java.io.InputStream;

/**
 * HTTP请求body
 *
 * @author: nicee
 * @since: 2016/2/4
 */
public class HttpBody {

    private final InputStream input;

    public HttpBody(InputStream input) {
        this.input = input;
    }

    public InputStream getInput() {
        return input;
    }

}
