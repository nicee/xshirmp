package psn.lotus.cloud.transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;

/**
 * Socket 传输处理
 *
 * @project lotus
 * @time 2018/4/18 13:52
 */
public class Transports {

    // 需要一个异步通道来处理
    private static AsynchronousSocketChannel channel;

    static {
        try {
            channel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createServer() throws Exception {
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9000);
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(), 10);
        AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open(group).bind(socketAddress);

        AsyncAcceptHandler handler = new AsyncAcceptHandler(channel);
        channel.accept(channel, handler);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void createClient() throws Exception {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9000);

        channel.connect(socketAddress, new Object(), new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {

                channel.write(ByteBuffer.wrap("Hello".getBytes()), new Object(), new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        System.out.println("send message ok, message length: " + result);
                        final ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                            @Override
                            public void completed(Integer result, ByteBuffer attachment) {
                                System.out.println("receive message back detail : " + new String(buffer.array()));
                            }

                            @Override
                            public void failed(Throwable exc, ByteBuffer attachment) {
                                System.out.println("fail on: " + exc.getMessage());
                            }
                        });
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("fail on: " + exc.getMessage());
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
    }

}
