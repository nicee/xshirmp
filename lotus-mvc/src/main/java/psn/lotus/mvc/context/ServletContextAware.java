package psn.lotus.mvc.context;

import javax.servlet.ServletContext;

/**
 * servlet上下容器配置
 *
 * @author: nicee
 * @since: 2016/2/1
 */
public interface ServletContextAware {

    /**
     * 设置servlet上下文容器
     *
     * @param context servlet上下容器
     */
    void setServletContext(ServletContext context);

    /**
     * 获取servlet上下容器
     *
     * @return servlet上下容器
     */
    ServletContext getServletContext();

}
