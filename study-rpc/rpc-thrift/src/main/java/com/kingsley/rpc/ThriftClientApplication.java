package com.kingsley.rpc;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.kingsley.rpc.pojo.User;
import com.kingsley.rpc.service.HelloService;
import com.kingsley.rpc.service.ThriftHelloService;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.logging.Slf4JLoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

/**
 * @author ZhangTao
 * @date 2022/9/20
 * @desc
 */
public class ThriftClientApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InternalLoggerFactory.setDefaultFactory(new Slf4JLoggerFactory());
        ThriftClientManager thriftClientManager = new ThriftClientManager();
        FramedClientConnector connector = new FramedClientConnector(new InetSocketAddress("localhost", 8899));
        ThriftHelloService helloService = thriftClientManager.createClient(connector, ThriftHelloService.class).get();
        User user = new User();
        user.setName("kingsley");
        user.setEmail("taozhang1029@qq.com");
        System.out.println(helloService.sayHello(user));
        thriftClientManager.close();
    }

}
