package psn.lotus.guice;

/**
 * 定义一个接口的实现，用于注入到有使用该接口的地方
 *
 * @project lotus
 * @time 2018/3/1 14:30
 */
public class UserServiceImpl implements IUserService {

    @Override
    public void sayHello() {
        System.out.println("In UserServiceImpl Body...");
    }

}
