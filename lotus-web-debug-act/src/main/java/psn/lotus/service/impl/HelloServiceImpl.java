package psn.lotus.service.impl;

import psn.lotus.service.IHelloService;

/**
 * @project lotus
 * @time 2017/5/26 17:21
 */
public class HelloServiceImpl implements IHelloService {

    public void sayHello(String name) {
        System.out.println("Hello: " + name);
    }

}
