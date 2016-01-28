package psn.lotus.aspectj.util;

import org.springframework.util.Assert;

/**
 * AOP代理工具类
 *
 * @author: nicee
 * @since: 2016/1/27
 */
public class AopProxyUtils {

    /**
     * 确定一套完整的接口，对于给定的AOP配置代理服务器
     *
     * @param specifiedInterfaces 被指定需要代理的接口
     * @return
     */
    static Class<?> completeProxiedInterfaces(Class<?>[] specifiedInterfaces) {
        Assert.notNull(specifiedInterfaces, "Specified interfaces could not be null.");
        if (specifiedInterfaces.length == 0) {

        }

        return null;
    }

}
