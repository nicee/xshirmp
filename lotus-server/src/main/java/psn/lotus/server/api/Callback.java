package psn.lotus.server.api;

import org.apache.http.HttpResponse;

/**
 * 回调处理
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public interface Callback<T> {

    /**
     * 回调主体
     *
     * @param response http响应
     * @param charset  字符编码
     * @return 获取数据
     * @throws Exception
     */
    T callback(HttpResponse response, String charset) throws Exception;

}
