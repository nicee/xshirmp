package psn.lotus.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import psn.lotus.web.bean.User;
import psn.lotus.web.dao.UserDAO;
import psn.lotus.web.support.CustomApplicationEvent;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/10 10:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    //M1.
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public String add(String name, String password) {
        User user = new User();

        user.setName(name);
        user.setPassword(password);

        //M1. 在此方法内部进行业务逻辑操作
//        String result = check(name) ? "新增失败, 已经存在’" + name + "‘用户." :
//                ((userDAO.insert(user) == 1) ? "新增成功，创建一个'" + name + "‘用户." : "新增失败, 数据库操作异常");
        //显示调用异常创建
        // createException();

        //M2. 函数调用方式执行业务逻辑操作
        String result = doAdd(user);

        return result;
    }

    // 用于判断当前用户是否已经存在, true 存在
    private boolean check(String name) {
        return userDAO.find(name) != null;
    }

    //M2
    // @Transactional(readOnly = false, rollbackFor = Exception.class)
    @TransactionalEventListener()
    private String doAdd(User user) {
        String name = user.getName();
        String info = check(name) ? "新增失败, 已经存在’" + name + "‘用户." :
                ((userDAO.insert(user) == 1) ? "新增成功，创建一个'" + name + "‘用户." : "新增失败, 数据库操作异常");

        //发布一个事件
        publishApplicationEvent(user);

        //显示调用异常创建
//        createException();

        return info;
    }

    private void createException() {
        throw new NullPointerException("创建一个空指针异常来测试事务回退...");
    }

    private void publishApplicationEvent(User user) {
        ApplicationEvent event = new CustomApplicationEvent(user, "测试事务事件传播...");
        applicationEventPublisher.publishEvent(event);
    }

}
