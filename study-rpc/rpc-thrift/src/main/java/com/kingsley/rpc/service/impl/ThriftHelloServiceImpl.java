package com.kingsley.rpc.service.impl;

import com.kingsley.rpc.pojo.User;
import com.kingsley.rpc.service.ThriftHelloService;

/**
 * @author ZhangTao
 * @date 2022/9/20
 * @desc
 */
public class ThriftHelloServiceImpl implements ThriftHelloService {

    @Override
    public String sayHello(String username) {
        return "Hello, " + username + ", welcome to thrift!";
    }

    @Override
    public String sayHello(User user) {
        return this.sayHello(user.getName());
    }
}
