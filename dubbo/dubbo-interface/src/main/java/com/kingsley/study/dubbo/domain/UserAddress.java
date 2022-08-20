package com.kingsley.study.dubbo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ZhangTao
 * @date 2022/8/20
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress implements Serializable {

    private Long id;

    private String address;

    private String userId;

    private String consignee;

    private String phoneNum;

    private String isDefault;

}
