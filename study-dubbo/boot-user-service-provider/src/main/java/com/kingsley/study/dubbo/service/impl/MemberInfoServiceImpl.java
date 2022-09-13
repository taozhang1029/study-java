package com.kingsley.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kingsley.study.dubbo.service.MemberInfoService;
import org.springframework.stereotype.Component;

/**
 * @author ZhangTao
 * @date 2022/8/27
 * @desc
 */
@Service
@Component
public class MemberInfoServiceImpl implements MemberInfoService {

    public Boolean isMember(String userId) {
        return null;
    }
}
