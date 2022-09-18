package com.kingsley.rpc.cxf.service.impl;

import com.kingsley.rpc.cxf.service.CxfHelloService;

import javax.jws.WebService;

/**
 * @author ZhangTao
 * @date 2022/9/18
 * @desc
 */
@WebService(endpointInterface = "com.kingsley.rpc.cxf.service.CxfHelloService")
public class CxfHelloServiceImpl implements CxfHelloService {

    @Override
    public String sayHello(String username) {
        return "Hello, " + username + "welcome to cxf!";
    }
}
