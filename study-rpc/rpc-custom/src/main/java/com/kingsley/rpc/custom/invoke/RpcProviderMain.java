package com.kingsley.rpc.custom.invoke;

import com.kingsley.rpc.custom.framework.ProviderReflect;
import com.kingsley.rpc.service.HelloService;
import com.kingsley.rpc.service.impl.HelloServiceImpl;

import java.io.IOException;

/**
 * @author ZhangTao
 * @date 2022/9/24
 * @desc
 */
public class RpcProviderMain {

    public static void main(String[] args) throws IOException {
        HelloService helloService = new HelloServiceImpl();
        ProviderReflect.provider(helloService, 8083);
    }
}
