package psn.lotus.web.service;

import psn.lotus.web.bean.User;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/10 10:34
 */
public interface UserService {

    String add(String name, String password);

    User find(String name);

}
