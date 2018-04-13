package unit;

import org.apache.xbean.classloader.JarFileClassLoader;

import java.net.URL;

/**
 * @project lotus
 * @time 2018/4/13 15:15
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        URL[] urls = new URL[1];
        urls[0] = new URL("file:\\E:\\java\\tools\\apache-maven-3.3.9\\repository\\asm\\asm\\3.3\\asm-3.3.jar");
        JarFileClassLoader classLoader = new JarFileClassLoader("local-test", urls);
        Class clazz = classLoader.loadClass("org.objectweb.asm.ByteVector");
        System.out.println(clazz.getName());
    }

}
