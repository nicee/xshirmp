package psn.lotus.cloud.transport;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

/**
 * @project lotus
 * @time 2018/4/18 16:15
 */
public class AsyncAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {

    private final AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncAcceptHandler(AsynchronousServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            result.read(buffer).get(100, TimeUnit.SECONDS);
            // 回写
            buffer.flip();
            result.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String message = new String(buffer.array());
        System.out.println("receive message length: " + message.length() + ", detail: " + message);

        // 继续监听下个连接
        serverSocketChannel.accept(serverSocketChannel, this);
    }

    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
        System.out.println("fail on : " + exc.getMessage());
    }

}
