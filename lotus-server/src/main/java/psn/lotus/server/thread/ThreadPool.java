package psn.lotus.server.thread;

/**
 * @author: nicee
 * @since: 2016/1/7
 */
public interface ThreadPool {

    /**
     * 执行线程池中的某个线程
     *
     * @param runnable 可执行线程
     */
    void dispatch(Runnable runnable);

    /**
     * 将某个线程加入到当前线程池中
     *
     * @param runnable 可执行线程
     */
    void join(Runnable runnable);

    /**
     * 设置线程池中线程最大数量
     *
     * @param max 数值
     */
    void setMaxThreads(int max);

    /**
     * 获取线程池中线程最大数量
     *
     * @return 线程数值
     */
    int getMaxThreads();

    /**
     * 设置线程池中线程最小数量
     *
     * @param min 数值
     */
    void setMinThreads(int min);

    /**
     * 获取线程池中线程最小数量
     *
     * @return 线程数值
     */
    int getMinThreads();

}
