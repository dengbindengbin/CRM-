package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import genertor.ObjectProp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 1 on 2017/8/28.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ObjectProp("会员充值")
public class MemberPayment {
    @ObjectProp("会员编号")
    private Long id;
    @ObjectProp("会员卡号")
    private String sn;
    @ObjectProp("支付类型")
    private int payment;
    @ObjectProp("充值金额")
    private BigDecimal payMoney;
    @ObjectProp("赠送金额")
    private BigDecimal giveMoney;
    @ObjectProp("充值时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paymentTime;
    @ObjectProp("备注信息")
    private String remark;
    @ObjectProp("变动后总金额")
    private BigDecimal totalMoney;
    @ObjectProp("会员列表")
    private Member member;
}
