package psn.lotus.web.dao;

import org.apache.ibatis.annotations.Param;
import psn.lotus.web.bean.User;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/10 10:22
 */
public interface UserDAO {

    int insert(User user);

    User find(@Param("name") String name);

}
