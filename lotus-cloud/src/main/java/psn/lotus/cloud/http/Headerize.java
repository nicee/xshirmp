package psn.lotus.cloud.http;

import java.util.Enumeration;

/**
 * HTTP头部处理接口定义
 *
 * @project lotus
 * @time 2018/4/26 16:59
 */
public interface Headerize {

    /**
     * 获取指定头名值
     *
     * @param name
     * @return
     */
    String getHeader(String name);

    /**
     * 获取头部信息枚举值
     *
     * @return 头部信息枚举值
     */
    Enumeration<String> getHeaderNames();

}
