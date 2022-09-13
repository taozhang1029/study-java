package com.kingsley.study.rpc.rmi;

import com.kingsley.study.rpc.rmi.service.HelloService;
import com.kingsley.study.rpc.rmi.service.impl.HelloServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author kingsley
 * @time 2022/9/14 01:01
 * @desc
 */
public class RmiServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        HelloService helloService = new HelloServiceImpl();
        LocateRegistry.createRegistry(8801);
        Naming.bind("rmi://localhost:8801/helloService", helloService);
        System.out.println("RmiServer start up");
    }

}
