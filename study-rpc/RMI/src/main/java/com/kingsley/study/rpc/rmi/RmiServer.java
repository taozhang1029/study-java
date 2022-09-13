package com.kingsley.study.rpc.rmi;

import com.kingsley.study.rpc.rmi.service.HelloService;
import com.kingsley.study.rpc.rmi.service.impl.HelloServiceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @author kingsley
 * @time 2022/9/14 01:01
 * @desc
 */
public class RmiServer {

    public static void main(String[] args) throws IOException, AlreadyBoundException {
        HelloService helloService = new HelloServiceImpl();
        LocateRegistry.createRegistry(8801);
        // 指定通信端口，防止被防火墙拦截
        RMISocketFactory.setSocketFactory(new RMISocketFactory() {
            @Override
            public Socket createSocket(String host, int port) throws IOException {
                return new Socket(host, port);
            }

            @Override
            public ServerSocket createServerSocket(int port) throws IOException {
                if (port <= 0) {
                    port = 8501;
                }
                System.out.println("RMI port: " + port);
                return new ServerSocket(port);
            }
        });
        Naming.bind("rmi://localhost:8801/helloService", helloService);
        System.out.println("RmiServer start up");
    }

}
