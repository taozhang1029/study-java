package com.kingsley.study.dubbo;

import com.kingsley.study.dubbo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ZhangTao
 * @date 2022/8/20
 * @desc
 */
@Slf4j
public class OrderServiceStarter {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        OrderService orderService = context.getBean(OrderService.class);
        orderService.initOrder("zjq");
        // 让程序阻塞, 按任意键退出
        System.in.read();
    }

}
