package psn.lotus.mvc.http.internal;

import psn.lotus.mvc.http.HttpInputStream;
import psn.lotus.mvc.http.HttpOutputStream;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: nicee
 * @since: 2016/2/4
 */
public interface HttpExecute extends HttpOutputStream {

    Object execute() throws IOException;

}
