package psn.lotus.core.io;

import java.io.IOException;
import java.net.URI;

/**
 * @author nicee
 * @since 2105/9/15
 */
public interface ResourceLoader extends ClassLoaderAware {

    /**
     * prefix string of class path.
     */
    String CLASSPATH_PREFIX = "classpath:";

    /**
     * separator of fold on windows
     */
    String FOLD_SEPARATOR_ON_WINDOWS = "/";

    /**
     * @param resPath path of resource
     * @return target resource
     * @throws IOException obtain resource from respath failure, would occur IOException
     */
    Resource getResource(String resPath) throws IOException;

    /**
     * @param uri u
     * @return target resource
     * @throws IOException obtain resource from URI failure, would occur IOException
     */
    Resource getResource(URI uri) throws IOException;

}
