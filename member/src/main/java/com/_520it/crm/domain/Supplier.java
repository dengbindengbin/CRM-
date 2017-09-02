package com._520it.crm.domain;

import genertor.ObjectProp;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Setter@Getter@ToString
@AllArgsConstructor
@NoArgsConstructor
@ObjectProp("供应商")
public class Supplier {
	
	@ObjectProp("序号")
	private Long id;
	
	@ObjectProp("厂商")
	private String factory;
	
	@ObjectProp("应付欠款")
	private BigDecimal debt ;
	
	@ObjectProp("添加时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addDate;
	
	@ObjectProp("QQ号码")
	private String qq;
	
	@ObjectProp("地址")
	private String address;
	
	@ObjectProp("备注信息")
	private String remark;

	@ObjectProp("联系人")
	private String name;
	
	@ObjectProp("联系电话")
	private String phone;
	
	@ObjectProp("操作人员")
	private String admin;

	
}
