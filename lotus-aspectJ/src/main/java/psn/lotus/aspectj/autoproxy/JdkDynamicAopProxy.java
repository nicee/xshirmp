package psn.lotus.aspectj.autoproxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import psn.lotus.core.util.ClassUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: nicee
 * @since: 2016/1/27
 */
public final class JdkDynamicAopProxy implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -5609072380625677384L;

    private static final Logger logger = LoggerFactory.getLogger(JdkDynamicAopProxy.class);

    private final Class<?> proxy;

    private JdkDynamicAopProxy(Class<?> proxy) {
        Assert.notNull(proxy, "Proxy object could not be null.");

        this.proxy = proxy;
    }

    public Object getProxy() {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        return Proxy.newProxyInstance(classLoader, new Class<?>[]{proxy}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

}
