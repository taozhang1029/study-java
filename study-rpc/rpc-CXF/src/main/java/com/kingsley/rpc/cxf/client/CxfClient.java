package com.kingsley.rpc.cxf.client;

import com.kingsley.rpc.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhangTao
 * @date 2022/9/18
 * @desc
 */
public class CxfClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:cxf-client.xml");
        HelloService client = context.getBean(HelloService.class);
        System.out.println(client.sayHello("kingsley"));
    }

}
