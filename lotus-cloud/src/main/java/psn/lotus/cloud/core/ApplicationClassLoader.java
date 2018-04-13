package psn.lotus.cloud.core;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @project lotus
 * @time 2018/4/13 13:49
 */
public class ApplicationClassLoader extends URLClassLoader {

    private String appName;

    public ApplicationClassLoader(String appName, URL[] urls, ClassLoader parent) {
        super(urls, parent);
        this.appName = appName;
    }


}
