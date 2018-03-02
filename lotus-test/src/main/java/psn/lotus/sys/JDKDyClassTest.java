package psn.lotus.sys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @project lotus
 * @time 2016/10/24 17:41
 */
public class JDKDyClassTest {

    private interface Printable {
        void print(String content);
    }

    class Printer implements Printable {

        public void print(String content) {
            System.out.println(content);
        }

    }

    class InvocationHandlerImpl implements InvocationHandler {

        private Printable printable;

        public InvocationHandlerImpl(Printable printable) {
            this.printable = printable;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("You are invoking an method in InvocationHandlerImpl.class, method=[" + method.getName() + "], args=[" + args[0] + "]");
            return method.invoke(printable, args);
        }
    }

    public static void main(String[] args) {
        JDKDyClassTest test = new JDKDyClassTest();
        Printable printable = test.new Printer();
        Class clazz = printable.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
        //获取类实现的所有接口
        Class[] interfaces = clazz.getInterfaces();

        InvocationHandler invocationHandler = test.new InvocationHandlerImpl(printable);
        //构建一个实现代理执行Printer的对象
        Object obj = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        Printable printer = (obj instanceof Printable) ? (Printable) obj : null;
        printer.print("To print strings...");
    }

}
