package psn.lotus.web.support.event;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import psn.lotus.web.bean.DWRChatMessage;

import javax.servlet.ServletContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.EventListener;

/**
 * @project lotus
 * @time 2016/10/31 20:19
 */
@Component
public class DWRChatMessageEventListener implements EventListener {

    private static final Logger logger = LoggerFactory.getLogger(DWRChatMessageEventListener.class);

    @Autowired
    private ServletContext ctx;

    @TransactionalEventListener
    public void onChatMessageEvent(ApplicationEvent event) {
        logger.info("事件已经传播到这了, 传输时间为: " + new Date(event.getTimestamp()));
        if (event instanceof DWRChatMessageEvent) {
            DWRChatMessage source = (DWRChatMessage) event.getSource();
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
            String time = dateFormat.format(source.getTime());
            String message = source.getMessage();

            Collection<ScriptSession> sessiones = Browser.getTargetSessions();
            for (ScriptSession session : sessiones) {
                ScriptBuffer sb = new ScriptBuffer();
                sb.appendScript("showMessage({msg: '")
                        .appendScript(message)
                        .appendScript("', time: '")
                        .appendScript(time)
                        .appendScript("')}");

                System.out.println(sb.toString());
                session.addScript(sb);
            }
        }

    }
}
