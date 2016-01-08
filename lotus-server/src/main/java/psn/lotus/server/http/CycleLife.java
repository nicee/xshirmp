package psn.lotus.server.http;

import psn.lotus.server.listener.CycleLifeListener;

/**
 * @author: nicee
 * @since: 2016/1/7
 */
public interface CycleLife extends CycleLifeListener {

    /**
     * 启动
     */
    void start();

    /**
     * 暂停
     *
     * @param time 暂停时间
     */
    void pause(long time);

    /**
     * 暂停（默认时间）
     */
    void pause();

    /**
     * 重启
     */
    void restart();

    /**
     * 停止
     */
    void stop();

    /**
     * 是否已启动
     *
     * @return true 是；false 否
     */
    boolean isStarted();

    /**
     * 是否已暂停
     *
     * @return true 是；false 否
     */
    boolean isPause();

    /**
     * 是否停止
     *
     * @return true 是；false 否
     */
    boolean isStop();


}
