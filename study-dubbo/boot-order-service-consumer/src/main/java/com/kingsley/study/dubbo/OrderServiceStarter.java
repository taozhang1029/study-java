package com.kingsley.study.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhangTao
 * @date 2022/8/20
 * @desc
 */
@Slf4j
@EnableDubbo
@SpringBootApplication
public class OrderServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceStarter.class, args);
    }

}
