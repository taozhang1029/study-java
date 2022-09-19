package com.kingsley.rpc.service.impl;

import com.kingsley.rpc.service.HelloService;

/**
 * @author ZhangTao
 * @date 2022/9/18
 * @desc
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String username) {
        return "Hello, " + username + "welcome to rpc!";
    }
}
