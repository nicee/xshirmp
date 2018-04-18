package psn.lotus.cloud.core;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * 这是一个具备自定义名称的class loader定义
 *
 * @project lotus
 * @time 2018/4/16 9:37
 */
public abstract class NamedClassLoader extends URLClassLoader {

    private final String name;

    public NamedClassLoader(String name, URL[] urls) {
        super(urls);
        this.name = name;
    }

    public NamedClassLoader(String name, URL[] urls, ClassLoader parent) {
        super(urls, parent);
        this.name = name;
    }

    public NamedClassLoader(String name, URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
        this.name = name;
    }

}
