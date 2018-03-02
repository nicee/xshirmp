package psn.lotus.server.api;

/**
 * 声明周期管理
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public interface LifeCycle {

    /**
     * 启动
     *
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * 停止
     *
     * @throws Exception
     */
    void stop() throws Exception;


    /**
     * 声明周期状态
     */
    interface LifeStatus {

        /**
         * 是否正在启动
         *
         * @return true/false
         */
        boolean isStarting();

        /**
         * 是否已经启动
         *
         * @return true/false
         */
        boolean isStarted();

        /**
         * 是否正在停止
         *
         * @return true/false
         */
        boolean isStopping();

        /**
         * 是否已经停止
         *
         * @return true/false
         */
        boolean isStopped();

    }

}
