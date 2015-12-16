/**
 *
 */
package psn.lotus.core.io.achieve;

import psn.lotus.core.util.AssertUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author nicee
 * @since 2015/9/16
 */
public class URIResource extends AbstractResource {

    /**
     * source data of resource
     */
    private final URI uri;

    /**
     * source data of resource, style of url
     */
    private final URL url;

    /**
     * @param uri source data of resource
     * @throws MalformedURLException uri is not a valid of url
     */
    public URIResource(URI uri) throws MalformedURLException {
        AssertUtils.notNull(uri, "URI must not be null.");
        this.uri = uri;
        this.url = uri.toURL();
    }

    /* (non-Javadoc)
     * @see psn.lotus.core.io.Resource#getDescriptor()
     */
    @Override
    public String getDescriptor() {
        return "URI : [" + uri.toString() + "]";
    }

    /* (non-Javadoc)
     * @see psn.lotus.core.io.StreamResource#getInputStream()
     */
    @Override
    public InputStream getInputStream() throws IOException {

        return null;
    }

}
