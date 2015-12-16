package psn.lotus.core.io;

import java.io.IOException;

/**
 * @author: nicee
 * @since: 2015/12/16
 */
public interface ResourcePathResolver {

    Resource getResource(String path) throws IOException;

}
