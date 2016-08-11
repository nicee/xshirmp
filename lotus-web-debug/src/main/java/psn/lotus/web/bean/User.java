package psn.lotus.web.bean;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xjl
 * @project lotus
 * @time 2016/4/25 16:26
 */
public class User implements Serializable {

    private static final long serialVersionUID = -102528522819113120L;

    @NotNull(message = "姓名不能为null")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
