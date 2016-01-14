package psn.lotus.server.event;

import java.io.Serializable;

/**
 * 事件定义
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public abstract class Event implements Serializable {

    private static final long serialVersionUID = 4749016387708067530L;

    /**
     * 事件名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
