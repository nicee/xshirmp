package psn.lotus.server.api;

import psn.lotus.server.Server;

/**
 * 连接器
 *
 * @author: nicee
 * @since: 2016/1/15
 */
public interface Connector {

    /**
     * 获取连接名称
     *
     * @return 名称
     */
    String getName();

    /**
     * 设置连接名称
     *
     * @param name 名称
     */
    void setName(String name);

    /**
     * 获取连接服务器
     *
     * @return 服务器
     */
    Server getServer();

    /**
     * 设置服务器
     *
     * @param server 服务器
     */
    void setServer(Server server);

    /**
     * 连接主机地址
     *
     * @return 主机地址
     */
    String getHost();

    /**
     * 设置主机地址
     *
     * @param host 主机地址
     */
    void setHost(String host);

    /**
     * 获取端口
     *
     * @return 端口
     */
    int getPort();

    /**
     * 设置端口
     *
     * @param port 端口
     */
    void setPort(int port);

    /**
     * 获取连接队列最大长度
     *
     * @return 连接队列最大长度
     */
    int getBacklog();

    /**
     * 设置连接队列最大长度
     *
     * @param backlog 连接队列最大长度
     */
    void setBacklog(int backlog);

    /**
     * 打开连接
     *
     * @throws Exception 异常
     */
    void open() throws Exception;

    /**
     * 关闭连接
     *
     * @throws Exception 异常
     */
    void close() throws Exception;

    /**
     * 获取连接者
     *
     * @return 连接者
     */
    Object getConnector();

}
