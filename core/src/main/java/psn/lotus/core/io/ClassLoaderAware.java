/**
 *
 */
package psn.lotus.core.io;


/**
 * @author nicee
 * @since 2015/9/15
 */
public interface ClassLoaderAware {

    /**
     * @return object to load the class file
     */
    ClassLoader getClassLoader();

    /**
     * @param loader set the loader to put class file into memory
     */
    void setClassLoader(ClassLoader loader);

}
