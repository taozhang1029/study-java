package com.kingsley.rpc.service;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import com.kingsley.rpc.pojo.User;

/**
 * @author ZhangTao
 * @date 2022/9/20
 * @desc
 */
@ThriftService("HelloService")
public interface ThriftHelloService extends HelloService {

    @ThriftMethod
    String sayHello(@ThriftField(name = "user") User user);

}
