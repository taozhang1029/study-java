package com.kingsley.study.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kingsley.study.dubbo.domain.UserAddress;
import com.kingsley.study.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZhangTao
 * @date 2022/8/29
 * @desc
 */
@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

    /**
     * 超时时间默认1秒
     */
    @Reference(timeout = 300, retries = 3)
    private UserService userService;

    @GetMapping("/init")
    public List<UserAddress> init(String userId) {
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        log.info("查询到的用户地址列表：userAddressList = {}", userAddressList);
        return userAddressList;
    }

}
