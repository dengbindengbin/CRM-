package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import genertor.ObjectProp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 1 on 2017/8/26.
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ObjectProp("会员管理")
public class Member {
    public static final int NORMAL = 0;//正常状态
    public static final int LEAVE = 1;//表示挂失
    @ObjectProp("会员编号")
    private Long id;
    @ObjectProp("会员姓名")
    private String name;
    @ObjectProp("会员卡号")
    private String sn;
    @ObjectProp("电话号码")
    private String phone;
    @ObjectProp("会员密码")
    private String password;
    @ObjectProp("生日")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @ObjectProp("性别")
    private int gender;
    @ObjectProp("QQ")
    private String qq;
    @ObjectProp("会员家庭地址")
    private String address;
    @ObjectProp("会员支付方式")
    private int payment;
    @ObjectProp("会员备注")
    private String remark;
    @ObjectProp("会员积分")
    private BigDecimal integral;
    @ObjectProp("已使用积分")
    private BigDecimal usedintegral;
    @ObjectProp("开卡总金额")
    private BigDecimal totalMoney;
    @ObjectProp("卡上余额")
    private BigDecimal totalConsume;
    @ObjectProp("推荐人")
    private Member referrer;
    @ObjectProp("会员等级")
    private MemberLevel level;
    @ObjectProp("过期时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
    //新增字段状态
    private int state;
}
