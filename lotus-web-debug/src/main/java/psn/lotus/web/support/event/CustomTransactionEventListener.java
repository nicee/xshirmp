package psn.lotus.web.support.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Date;
import java.util.EventListener;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/11 15:46
 */
@Component
public class CustomTransactionEventListener implements EventListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomTransactionEventListener.class);

    @TransactionalEventListener
    public void handleSomeTransactionalEvent(ApplicationEvent event) {
        logger.info("事件已经传播到这了, 传输时间为: " + new Date(event.getTimestamp()));
        String name = null;
        if (event instanceof CustomApplicationEvent) {
            name = ((CustomApplicationEvent) event).getName();
        }
        logger.info("接受到的数据为: " + event.getSource() + ", 数据源名称为: " + name == null ? "未知" : name);
    }

}
