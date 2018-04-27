package psn.lotus.cloud.transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

/**
 * 传输终端，可以是服务端，也可是客户端
 *
 * @project lotus
 * @time 2018/4/27 15:28
 */
public interface TransportTerminal {

    /**
     * 获取终端URL
     *
     * @return
     */
    URL getUrl();

    /**
     * 获取终端类型
     *
     * @return 终端类型
     */
    TerminalType getType();

    /**
     * 获取终端使用的传输通道
     *
     * @return 传输通道
     */
    TransportChannel getChannel();

    /**
     * 获取当前终端主机绑定或者监听的网络socket地址(IP:port)
     *
     * @return
     */
    InetSocketAddress getHostAddress();

    /**
     * 终端推送数据给通道的另一端
     *
     * @param message 发送数据
     * @return 发送异步结果
     */
    void send(Object message) throws IOException;

    /**
     * 终端启动
     */
    void start() throws IOException;

    /**
     * 终端关闭
     */
    void close() throws IOException;

    /**
     * 指定一个时间范围内关闭终端
     *
     * @param timeout 超时时间
     * @return 关闭结果
     */
    CompletableFuture<Boolean> close(int timeout);

}
