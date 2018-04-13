package psn.lotus.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @project lotus
 * @time 2018/3/14 14:14
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;

}
