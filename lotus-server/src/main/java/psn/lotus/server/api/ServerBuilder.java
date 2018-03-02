package psn.lotus.server.api;

import psn.lotus.server.Server;

/**
 * 服务器构建接口
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public interface ServerBuilder {

    /**
     * 启动服务器
     *
     * @throws Exception
     */
    Server build(Context context) throws Exception;

}
