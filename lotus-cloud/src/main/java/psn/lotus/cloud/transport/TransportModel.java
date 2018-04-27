package psn.lotus.cloud.transport;

/**
 * 定义异步传输模型
 *
 * @project lotus
 * @time 2018/4/27 15:22
 */
public interface TransportModel {

    /**
     * 获得当前传输终端
     *
     * @return
     */
    TransportTerminal terminal();

    /**
     * 获取当前异步传输使用的通道
     *
     * @return 异步传输通道
     */
    TransportChannel getChannel();

    /**
     * 获取传输终点
     *
     * @return 传输终点
     */
    TransportTerminal[] getEndPoint();

}
