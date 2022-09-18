package com.kingsley.study.rpc.rmi.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.kingsley.study.rpc.rmi.service.RmiHelloService;

/**
 * @author kingsley
 * @time 2022/9/14 00:53
 * @desc
 */
public class RmiHelloServiceImpl extends UnicastRemoteObject implements RmiHelloService {

    public static final long serialVersionUID = 100569L;

    public RmiHelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String username) throws RemoteException {
        return "Hello, " + username + "welcome to rmi!";
    }
}
