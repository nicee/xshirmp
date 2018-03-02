package psn.lotus.server.api;

/**
 * 上下文
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public interface Context {

    /**
     * 获取某个对象
     *
     * @param key 键值
     * @return 对象
     */
    Object get(String key);

    /**
     * 添加对象
     *
     * @param key    键值
     * @param object 对象
     */
    void put(String key, Object object);

}
