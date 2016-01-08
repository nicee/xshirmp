package psn.lotus.server.listener;

/**
 * @author: nicee
 * @since: 2016/1/7
 */
public interface CycleLifeListener extends Listener {

    /**
     * 监听启动时
     *
     * @param listener 监听者
     */
    void lifeStartListen(CycleLifeListener listener);

    /**
     * 监听暂停时
     *
     * @param listener 监听者
     */
    void lifePauseListen(CycleLifeListener listener);

    /**
     * 监听重启时
     *
     * @param listener 监听者
     */
    void lifeRestartListen(CycleLifeListener listener);

    /**
     * 监听停止时
     *
     * @param listener 监听者
     */
    void lifeStopListen(CycleLifeListener listener);

}
