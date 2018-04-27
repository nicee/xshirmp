package psn.lotus.cloud.http;

import psn.lotus.cloud.transport.TerminalType;
import psn.lotus.cloud.transport.TransportChannel;
import psn.lotus.cloud.transport.TransportTerminal;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;

/**
 * @project lotus
 * @time 2018/4/27 13:47
 */
public class HttpServer implements TransportTerminal {

    private TransportChannel channel;
    private InetSocketAddress hostAddress;

    public HttpServer(TransportChannel channel, InetSocketAddress hostAddress) {
        this.channel = channel;
        this.hostAddress = hostAddress;
    }

    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public TerminalType getType() {
        return TerminalType.SERVER;
    }

    @Override
    public TransportChannel getChannel() {
        return channel;
    }

    @Override
    public InetSocketAddress getHostAddress() {
        return hostAddress;
    }

    @Override
    public void send(Object message) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(message.toString().getBytes());
        channel.getChannel().write(buffer);
    }

    @Override
    public void start() throws IOException {
        this.channel.bind(this.hostAddress);
        this.
    }

    @Override
    public void close() {

    }

    @Override
    public CompletableFuture<Boolean> close(int timeout) {
        return null;
    }

}
