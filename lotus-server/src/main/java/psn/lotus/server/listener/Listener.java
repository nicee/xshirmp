package psn.lotus.server.listener;

/**
 * @author: nicee
 * @since: 2016/1/8
 */
public interface Listener {

    /**
     * 添加监听
     *
     * @param listener 监听者
     */
    void addListener(Listener listener);

    /**
     * 移除监听
     *
     * @param listener 监听者
     */
    void removeListener(Listener listener);

}
