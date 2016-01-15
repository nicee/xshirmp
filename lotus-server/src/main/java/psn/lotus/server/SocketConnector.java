package psn.lotus.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * @author: nicee
 * @since: 2016/1/15
 */
public class SocketConnector extends AbstractConnector {

    /**
     * socket服务器
     */
    private ServerSocket serverSocket;
    /**
     * 使用旧端口
     */
    private boolean reuseAddress;
    /**
     * 本地分配的端口
     */
    private int localPort;

    public void open() throws Exception {
        if (null == serverSocket || serverSocket.isClosed()) {
            serverSocket = newServerSocket(getHost(), getPort(), getBacklog());
            serverSocket.setReuseAddress(reuseAddress);
            localPort = serverSocket.getLocalPort();
            if (localPort < 1) {
                throw new IllegalArgumentException("port not enough for " + this);
            }
        }
    }

    public void close() throws Exception {
        if(serverSocket != null) {
            serverSocket.close();
        }
        serverSocket = null;
        localPort = -2;
    }

    public Object getConnector() {
        return serverSocket;
    }

    private ServerSocket newServerSocket(String host, int port, int backlog) throws IOException {
        return (host == null) ? new ServerSocket(port, backlog) : new ServerSocket(port, backlog, InetAddress.getByName(host));
    }

    public boolean isReuseAddress() {
        return reuseAddress;
    }

    public void setReuseAddress(boolean reuseAddress) {
        this.reuseAddress = reuseAddress;
    }
}
