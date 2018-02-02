package psn.lotus.sys;

import java.io.IOException;
import java.io.InputStream;

/**
 * @project lotus
 * @time 2017/9/13 17:00
 */
public class CustomClassLoadTest {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String clazzName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(clazzName);
                if (inputStream == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Class clazz = classLoader.loadClass("psn.lotus.sys.ASMClassTest");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(clazz.isInstance(object));
    }

}
