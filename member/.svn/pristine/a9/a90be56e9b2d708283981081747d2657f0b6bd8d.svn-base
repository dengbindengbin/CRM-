package com._520it.crm.domain;

import genertor.ObjectProp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ObjectProp("店铺")
public class Store {
	@ObjectProp("店铺编码")
	private Long id;
	@ObjectProp("店铺名称")
	private String name;
	@ObjectProp("联系电话")
	private String tel;
	@ObjectProp("店铺状态")
	private Boolean state;
	@ObjectProp("店铺地址")
	private String address;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@ObjectProp("开业时间")
	private Date inputtime;
	@ObjectProp("库存")
	private Stocktaking stocktaking;
	@ObjectProp("所属店铺")
	private Store parent;
	@ObjectProp("店长")
	private Employee manager;
}
