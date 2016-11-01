package psn.lotus.web.support.event;

import org.springframework.context.ApplicationEvent;

/**
 * @project lotus
 * @time 2016/10/31 17:52
 */
public class DWRChatMessageEvent extends ApplicationEvent {

    private static final long serialVersionUID = -7476646123496499523L;

    public DWRChatMessageEvent(Object source) {
        super(source);
    }

}
