package com.kingsley.study.rpc.rmi;

import com.kingsley.study.rpc.rmi.service.RmiHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author kingsley
 * @time 2022/9/14 01:07
 * @desc
 */
public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RmiHelloService helloService = (RmiHelloService) Naming.lookup("rmi://localhost:8801/helloService");
        System.out.println("RMI远程过程调用结果：" + helloService.sayHello("kingsley"));
    }

}
