package unit;

import psn.lotus.cloud.transport.Transports;

/**
 * @project lotus
 * @time 2018/4/18 14:10
 */
public class SocketServerRunner {

    public static void main(String[] args) throws Exception {
        Transports.createServer();
    }

}
