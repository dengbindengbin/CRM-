package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import genertor.ObjectProp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 1 on 2017/8/29.
 */
@Setter
@Getter
@ObjectProp("积分充值")
public class IntegralChange {
    private long id;
    @ObjectProp("变动类型")
    private int type;
    @ObjectProp("会员卡号")
    private String sn;
    @ObjectProp("备注")
    private int remark;
    @ObjectProp("变动时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    @ObjectProp("变动数额")
    private BigDecimal changecount;
    @ObjectProp("会员等级")
    private MemberLevel level;
    @ObjectProp("会员名称")
    private Member member;
}
