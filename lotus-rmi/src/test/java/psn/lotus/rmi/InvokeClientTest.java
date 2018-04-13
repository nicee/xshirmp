package psn.lotus.rmi;

import psn.lotus.rmi.api.HelloService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static psn.lotus.rmi.RegistryServerTest.REGISTRY_PORT;
import static psn.lotus.rmi.RegistryServerTest.SERVICE_NAME;

/**
 * 创建一个client端，并发起一个remote方法调用
 *
 * @project lotus
 * @time 2018/3/14 14:24
 */
public class InvokeClientTest {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(REGISTRY_PORT);
        HelloService helloService = (HelloService) registry.lookup(SERVICE_NAME);
        for (int i = 0; i < 10; i++) {
            System.out.println(helloService.sayHello("world[" + i + "] from client"));
        }
    }

}
