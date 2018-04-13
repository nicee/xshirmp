package psn.lotus.rmi.impl;

import psn.lotus.rmi.api.HelloService;

import java.rmi.RemoteException;

/**
 * @project lotus
 * @time 2018/3/14 14:15
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) throws RemoteException {
        return "hello " + name;
    }

}
