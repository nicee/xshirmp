package psn.lotus.server.api;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public interface HandlerContainer {

    /**
     * 获取当前父处理器
     *
     * @return 父处理器
     */
    Handler getParent();

    /**
     * 获取子处理器列表
     *
     * @return 子处理器
     */
    Handler[] getChildren();

    /**
     * 设置处理器
     *
     * @param handlers 处理器
     */
    void setHandlers(Handler[] handlers);

    /**
     * 添加处理器
     *
     * @param handler 处理器
     */
    void addHandler(Handler handler);

    /**
     * 移除处理器
     *
     * @param handler 处理器
     */
    void removeHandler(Handler handler);

}
