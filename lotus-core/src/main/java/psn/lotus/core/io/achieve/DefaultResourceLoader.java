/**
 *
 */
package psn.lotus.core.io.achieve;

import psn.lotus.core.io.Resource;
import psn.lotus.core.io.ResourceLoader;
import psn.lotus.core.util.AssertUtils;
import psn.lotus.core.util.ClassUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author nicee
 * @since 2015年9月15日
 */
public class DefaultResourceLoader implements ResourceLoader {

    /**
     * the loader for class file
     */
    private ClassLoader loader;

    /**
     * default constructor
     */
    public DefaultResourceLoader() {
        this.loader = ClassUtils.getDefaultClassLoader();
    }

    /**
     * @param loader target loader object to load class file
     */
    public DefaultResourceLoader(ClassLoader loader) {
        AssertUtils.notNull(loader, "The class of loader must not be null.");
        this.loader = loader;
    }

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.ClassLoaderAware#getClassLoader()
     */
    @Override
    public ClassLoader getClassLoader() {
        return (this.loader != null) ? this.loader : ClassUtils
                .getDefaultClassLoader();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * psn.lotus.core.io.ClassLoaderAware#setClassLoader(java.lang.ClassLoader)
     */
    @Override
    public void setClassLoader(ClassLoader loader) {
        this.loader = loader;
    }

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.ResourceLoader#getResource(java.lang.String)
     */
    @Override
    public Resource getResource(String resPath) throws IOException {
        AssertUtils.notNull(resPath, "The path of resource must not be null.");
        if (resPath.startsWith(FOLD_SEPARATOR_ON_WINDOWS)) {
            // TODO deal with windows relative resource
        } else if (resPath.startsWith(CLASSPATH_PREFIX)) {
            // TODO deal with class path resource
        } else {
            // consider uri resource
            try {
                URI uri = new URI(resPath);
                return new URIResource(uri);
            } catch (URISyntaxException ex) {
                throw new IOException(ex);
            }
        }

        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.ResourceLoader#getResource(java.net.URI)
     */
    @Override
    public Resource getResource(URI uri) {
        // TODO Auto-generated method stub
        return null;
    }

}
