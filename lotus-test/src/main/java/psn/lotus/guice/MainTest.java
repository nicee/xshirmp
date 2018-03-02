package psn.lotus.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @project lotus
 * @time 2018/3/1 14:31
 */
public class MainTest {

    public static void main(String[] args) {
        // 初始化Guice注入容器，解析注入依赖关系
        Injector injector = Guice.createInjector(new ApplicationModule());
        // 从容器中获取某个接口的实例对象
        IUserService userService = injector.getInstance(IUserService.class);
        // 调用功能
        userService.sayHello();
    }

}
