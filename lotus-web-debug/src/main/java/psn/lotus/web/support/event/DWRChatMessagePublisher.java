package psn.lotus.web.support.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import psn.lotus.web.bean.DWRChatMessage;

import java.util.Date;

/**
 * @project lotus
 * @time 2016/10/31 21:03
 */
@Component
public class DWRChatMessagePublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void onEventPublish() {
        DWRChatMessage message = new DWRChatMessage();
        message.setId(1);
        message.setMessage("Internal generate message was working onDWRChatMessage...");
        message.setTime(new Date());
        ApplicationEvent event = new DWRChatMessageEvent(message);
        applicationEventPublisher.publishEvent(event);
    }

}
