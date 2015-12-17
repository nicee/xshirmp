package psn.lotus.core.io;

import java.io.IOException;

/**
 * @author: nicee
 * @since: 2015/12/16
 */
public interface ResourcePatternResolver extends ResourceLoader {

    Resource[] getResources(String pathPattern) throws IOException;

}
