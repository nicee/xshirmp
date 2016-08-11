package psn.lotus.web.support;

import org.springframework.context.ApplicationEvent;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/11 15:54
 */
public class CustomApplicationEvent extends ApplicationEvent {

    private String name;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomApplicationEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
