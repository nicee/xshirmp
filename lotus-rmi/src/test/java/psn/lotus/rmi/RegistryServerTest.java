package psn.lotus.rmi;

import psn.lotus.rmi.api.HelloService;
import psn.lotus.rmi.impl.HelloServiceImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 先运行注册实例，绑定可以远程调用的对象
 *
 * @project lotus
 * @time 2018/3/14 14:17
 */
public class RegistryServerTest {

    static final int REGISTRY_PORT = 1099;
    static final String SERVICE_NAME = "helloService";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        final int port = 9333;
        HelloService helloService = new HelloServiceImpl();
        // 在port端口上导出远程调用对象，使得其可以被使用
        UnicastRemoteObject.exportObject(helloService, port);
        // 在本机上指定的端口上创建并导出一个注册实例
        Registry registry = LocateRegistry.createRegistry(REGISTRY_PORT);
        registry.bind(SERVICE_NAME, helloService);
    }

}
