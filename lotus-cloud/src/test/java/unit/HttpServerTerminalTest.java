package unit;

import psn.lotus.cloud.http.HttpServer;
import psn.lotus.cloud.transport.TransportChannel;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * HTTP服务器终端测试类
 *
 * @project lotus
 * @time 2018/4/27 17:51
 */
public class HttpServerTerminalTest {

    public static void main(String[] args) {
        InetSocketAddress hostAddress = new InetSocketAddress("127.0.0.1", 9000);
        TransportChannel transportChannel = new
        HttpServer httpServer = new HttpServer(hostAddress);
    }

}
