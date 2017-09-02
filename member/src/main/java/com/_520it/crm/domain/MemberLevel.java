package com._520it.crm.domain;

import genertor.ObjectProp;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by l on 2017/7/16.
 */
@Getter
@Setter
@ObjectProp("会员等级")
public class MemberLevel {
    private Long id;
    @ObjectProp("等级名称")
    private String name;
    @ObjectProp("会员折扣")
    private BigDecimal discount;
}
