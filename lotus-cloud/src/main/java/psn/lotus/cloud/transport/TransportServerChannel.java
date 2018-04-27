package psn.lotus.cloud.transport;

import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;

/**
 * @project lotus
 * @time 2018/4/27 17:56
 */
public class TransportServerChannel extends AsynchronousServerSocketChannel implements TransportChannel {

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean isWriteable() {
        return false;
    }

    @Override
    public SocketChannel getChannel() {
        return null;
    }

    @Override
    public SocketAddress getRemoteAddress() {
        return null;
    }

    @Override
    public TransportHandler getChannelHandler() {
        return null;
    }

    @Override
    public CompletableFuture<Void> connect(SocketAddress remote) {
        return null;
    }

    @Override
    public CompletableFuture disconnect() {
        return null;
    }
}
