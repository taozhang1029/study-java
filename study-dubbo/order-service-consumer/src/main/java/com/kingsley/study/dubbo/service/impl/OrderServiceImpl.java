package com.kingsley.study.dubbo.service.impl;

import com.kingsley.study.dubbo.domain.UserAddress;
import com.kingsley.study.dubbo.service.OrderService;
import com.kingsley.study.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhangTao
 * @date 2022/8/20
 * @desc 1、将服务提供者注册到注册中心
 * <p>
 * 2、
 */
@Slf4j
@Component
public class OrderServiceImpl implements OrderService {

    @Resource
    private UserService userService;

    public void initOrder(String userId) {
        log.info("开始初始化订单...");
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        log.info("addressList: {}", addressList);
        log.info("订单初始化完毕...");
    }

}
