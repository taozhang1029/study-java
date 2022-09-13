package com.kingsley.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kingsley.study.dubbo.domain.UserAddress;
import com.kingsley.study.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangTao
 * @date 2022/8/20
 * @desc
 */
@Slf4j
@Service(timeout = 800)
@Component
public class UserServiceImpl implements UserService {

    public List<UserAddress> getUserAddressList(String uerId) {
        log.info("RPC调用开始...");
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(
                new UserAddress(1L, "北京市大兴区", uerId, "张三", "13166666666", "Y"),
                new UserAddress(2L, "北京市海淀区", uerId, "张三", "13166666666", "N")
        );
    }

}
