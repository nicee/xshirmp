package psn.lotus.cloud.http;

import java.util.Map;

/**
 * 参数处理接口定义
 *
 * @project lotus
 * @time 2018/4/26 16:25
 */
public interface Parameterize {

    /**
     * 获取参数名称获取对应参数值
     *
     * @param name 参数名
     * @return 参数值
     */
    String getParameter(String name);

    /**
     * 获取参数名称对应的参数值，如果一个参数名有多个值的话，此方法返回一个数组
     *
     * @param name 参数名
     * @return 参数值数组
     */
    String[] getParameterValues(String name);

    /**
     * 获取所有参数名以及参数值信息
     *
     * @return <参数名, 参数值/>
     */
    Map<String, String[]> getParameterMap();

}
