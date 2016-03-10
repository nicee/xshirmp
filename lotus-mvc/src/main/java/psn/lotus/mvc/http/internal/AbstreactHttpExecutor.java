package psn.lotus.mvc.http.internal;

import psn.lotus.mvc.http.metadata.HttpHeaders;

import java.io.IOException;

/**
 * @author: nicee
 * @since: 2016/2/4
 */
public abstract class AbstreactHttpExecutor implements HttpExecute {

    private final HttpHeaders headers = new HttpHeaders();

    public Object execute() throws IOException {
        return null;
    }


}
