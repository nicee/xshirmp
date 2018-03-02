package psn.lotus.server.api;

import java.util.EventListener;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public interface LifeCycleListener {

    /**
     * 添加监听
     *
     * @param eventListener 监听者
     */
    void addEventListener(LifeCycleEventListener eventListener);

    /**
     * 移除监听
     *
     * @param eventListener 监听者
     */
    void removeEventListener(LifeCycleEventListener eventListener);

    /**
     * 声明事件监听者
     */
    interface LifeCycleEventListener extends EventListener {

        /**
         * 声明周期正在启动
         *
         * @param event 声明周期
         */
        void lifeCycleStarting(LifeCycle event);

        /**
         * 声明周期已经启动
         *
         * @param event 声明周期
         */
        void lifeCycleStarted(LifeCycle event);

        /**
         * 声明周期正在关闭
         *
         * @param event 声明周期
         */
        void lifeCycleStopping(LifeCycle event);

        /**
         * 声明周期已经关闭
         *
         * @param event 声明周期
         */
        void lifeCycleStopped(LifeCycle event);

    }

}
