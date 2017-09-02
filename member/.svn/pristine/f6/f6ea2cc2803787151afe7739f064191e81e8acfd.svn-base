package com._520it.crm.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Expend {
	//id
    private Long id;
    //支出分类
    private SmallClassify smallClassify;
    //支出金额
    private  BigDecimal debit;
    //支出时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date spendingtime;
    //支出人员
    private String spendingonstaff;
    //备注
    private String remark;
}