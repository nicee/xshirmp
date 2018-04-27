package psn.lotus.cloud.transport;

import java.nio.channels.CompletionHandler;

/**
 * 定义传输通道的处理器，具有处理通道中数据的能力
 *
 * @project lotus
 * @time 2018/4/27 15:53
 */
public interface TransportHandler {

    /**
     * 获取通道读取器
     *
     * @return
     */
    CompletionHandler getReaderHandler();

    /**
     * 获取通道写入器
     *
     * @return
     */
    CompletionHandler getWriteHandler();



}
