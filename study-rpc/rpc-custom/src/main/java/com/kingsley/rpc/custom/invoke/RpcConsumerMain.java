package com.kingsley.rpc.custom.invoke;

import com.kingsley.rpc.custom.framework.ConsumerProxy;
import com.kingsley.rpc.service.HelloService;

/**
 * @author ZhangTao
 * @date 2022/9/24
 * @desc
 */
public class RpcConsumerMain {

    public static void main(String[] args) throws Exception {
        HelloService helloService = ConsumerProxy.consume(HelloService.class, "127.0.0.1", 8083);
        for (int i = 0; i < 10; i++) {
            System.out.println(helloService.sayHello("kingsley_" + i));
            Thread.sleep(1000);
        }
    }

}
