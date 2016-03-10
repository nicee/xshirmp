package psn.lotus.mvc.context;

import javax.servlet.ServletContext;

/**
 * 应用程序上下文
 *
 * @author: nicee
 * @since: 2016/2/1
 */
public interface ApplicationContext extends ServletContext {

    /**
     * 获取上下文ID
     *
     * @return ID
     */
    String getId();

    /**
     * 获取应用名称
     *
     * @return 应用名称
     */
    String getApplicationName();

    /**
     * 获取上下文名称
     *
     * @return 名称
     */
    String getDisplayName();

    /**
     * 应用起始时间
     *
     * @return 起始时间
     */
    long getStartDate();


}
