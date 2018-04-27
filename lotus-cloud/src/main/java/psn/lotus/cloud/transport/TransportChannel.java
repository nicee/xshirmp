package psn.lotus.cloud.transport;

import java.net.SocketAddress;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;

/**
 * 定义异步传输代理通道功能，用这个来代理真正的通道的功能
 *
 * @project lotus
 * @time 2018/4/27 15:19
 */
public interface TransportChannel extends AsynchronousByteChannel, NetworkChannel {

    /**
     * 通道是否激活
     *
     * @return true/false
     */
    boolean isActive();

    /**
     * 判断当前通道是否能否写入数据
     *
     * @return true/false
     */
    boolean isWriteable();


    /**
     * 获取传输通道使用的socket通道模型
     *
     * @return socket通道
     */
    SocketChannel getChannel();

    /**
     * 获取通道连接的远程地址，如果是服务端通道，则返回null
     *
     * @return
     */
    SocketAddress getRemoteAddress();

    /**
     * 获取传输处理器，用于处理通道数据的读写操作
     *
     * @return
     */
    TransportHandler getChannelHandler();

    /**
     * 连接remote address，如果是服务端，则抛出异常
     *
     * @param remote 远程地址
     * @return
     */
    CompletableFuture<Void> connect(SocketAddress remote);

    /**
     * 关闭当前通道
     *
     * @return 完成结果
     */
    CompletableFuture disconnect();

}
