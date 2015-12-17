package psn.lotus.core.io;

import java.io.IOException;
import java.net.URI;

/**
 * @author nicee
 * @since 2015/09/15
 */
public abstract interface Resource extends StreamResource {

    /**
     * @return whether resource exists.
     */
    boolean exists();

    /**
     * @return The resource descriptor, unique resource identify.
     */
    String getDescriptor();

    /**
     * @return Uniform Resource Identifier
     * @throws IOException if uri of resource is null, will throw it.
     */
    URI getUri() throws IOException;

    /**
     * @return absolute path of resource
     */
    String getPath();

    /**
     * @return name of resource
     */
    String getName();

}
