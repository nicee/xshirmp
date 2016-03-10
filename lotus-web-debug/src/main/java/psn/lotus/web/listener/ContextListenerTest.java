package psn.lotus.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

/**
 * @author: nicee
 * @since: 2016/3/10
 */
public class ContextListenerTest implements ServletContextListener {

    static final Logger logger = LoggerFactory.getLogger(ContextListenerTest.class);

    public void contextInitialized(ServletContextEvent sce) {
        logger.info("进入了Root上下文初始化步骤.... event = " + sce.getServletContext().getServerInfo());
        ServletContext servletContext = sce.getServletContext();
        if (servletContext != null) {
            logger.info("---> 获取Web默认配置项属性");
            Enumeration<String> attrs = servletContext.getAttributeNames();
            while (attrs.hasMoreElements()) {
                String attr = attrs.nextElement();
                logger.info("key = {}, value = {}", attr, servletContext.getAttribute(attr));
            }

            logger.info("---> 获取web.xml中context-param中指定的配置项属性");
            attrs = servletContext.getInitParameterNames();
            while (attrs.hasMoreElements()) {
                String attr = attrs.nextElement();
                logger.info("key = {}, value = {}", attr, servletContext.getInitParameter(attr));
            }
        }

        logger.info("---> 获取Spring MVC ROOT上下文对象");
        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        logger.info("key = {}, value = {}", attr, servletContext.getAttribute(attr));


    }

    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("进入了Root上下文关闭环节.... event = " + sce.getServletContext().getServerInfo());
    }

}
