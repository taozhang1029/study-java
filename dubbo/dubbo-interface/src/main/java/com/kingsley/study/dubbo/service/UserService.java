package com.kingsley.study.dubbo.service;

import com.kingsley.study.dubbo.domain.UserAddress;

import java.util.List;

/**
 * @author ZhangTao
 * @date 2022/8/20
 * @desc
 */
public interface UserService {

    List<UserAddress> getUserAddressList(String uerId);

}
