package com._520it.crm.domain;


import genertor.ObjectProp;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ObjectProp("顾客")@ToString
public class Client {
	@ObjectProp("顾客编号")
	private Long id;
	@ObjectProp("顾客名称")
	private String name;
	@ObjectProp("是否会员")
	private Member member;
	private List<Product> products;
}
