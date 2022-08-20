package com.kingsley.study.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ZhangTao
 * @date 2022/8/20
 * @desc
 */
@Slf4j
public class UserServiceStarter {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
        context.start();
        // 让程序阻塞, 按任意键退出
        System.in.read();
    }

}
