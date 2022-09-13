package com.kingsley.study.rpc.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author kingsley
 * @time 2022/9/14 00:43
 * @desc
 */
public interface HelloService extends Remote {

    String sayHello(String username) throws RemoteException;

}
