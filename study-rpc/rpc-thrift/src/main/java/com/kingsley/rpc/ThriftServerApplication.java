package com.kingsley.rpc;

import com.facebook.nifty.core.NettyServerConfig;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.kingsley.rpc.service.impl.ThriftHelloServiceImpl;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.logging.Slf4JLoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangTao
 * @date 2022/9/20
 * @desc
 */
public class ThriftServerApplication {

    public static void main(String[] args) {
        InternalLoggerFactory.setDefaultFactory(new Slf4JLoggerFactory());
        ThriftServiceProcessor thriftServiceProcessor = new ThriftServiceProcessor(new ThriftCodecManager(), new ArrayList<>(), new ThriftHelloServiceImpl());
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ThriftServerDef thriftServerDef = ThriftServerDef.newBuilder()
                .listen(8899)
                .withProcessor(thriftServiceProcessor)
                .using(executorService)
                .build();
        ExecutorService bossExecutor = Executors.newCachedThreadPool();
        ExecutorService workerExecutor = Executors.newCachedThreadPool();
        NettyServerConfig serverConfig = NettyServerConfig.newBuilder()
                .setBossThreadExecutor(bossExecutor)
                .setWorkerThreadExecutor(workerExecutor)
                .build();
        ThriftServer server = new ThriftServer(serverConfig, thriftServerDef);
        server.start();

        // workerExecutor.shutdown();
        // bossExecutor.shutdown();
        // executorService.shutdown();
    }

}
