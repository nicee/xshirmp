package psn.lotus.core.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: nicee
 * @since: 2015/12/17
 */
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;

    public ApplicationContextHelper() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

}
