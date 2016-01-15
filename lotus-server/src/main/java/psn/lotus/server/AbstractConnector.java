package psn.lotus.server;

import psn.lotus.server.api.Connector;

/**
 * 抽象连接器
 *
 * @author: nicee
 * @since: 2016/1/15
 */
public abstract class AbstractConnector extends AbstractLifeCycle implements Connector {

    /**
     * 连接器名称
     */
    private String name;
    /**
     * 主机名称
     */
    private String host;
    /**
     * 目标服务器
     */
    private Server server;
    /**
     * 端口
     */
    private int port;
    /**
     * 队列最大值
     */
    private int backlog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Server getServer() {
        return server;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }

    public void setServer(Server server) {
        this.server = server;
    }

}
