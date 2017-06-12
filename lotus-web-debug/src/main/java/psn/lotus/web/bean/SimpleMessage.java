package psn.lotus.web.bean;

import java.io.Serializable;

/**
 * @project lotus
 * @time 2017/6/6 13:55
 */
public class SimpleMessage implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
