package com._520it.crm.domain;

import genertor.ObjectProp;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ObjectProp("仓库")
public class Warehouse {
	
	@ObjectProp("仓库")
	private Long id;
	
	@ObjectProp("仓库名称")
	private String wname;
	
	@ObjectProp("仓库编码")
	private String sn;
	
	@ObjectProp("仓库状态")
	private Boolean state;

	@ObjectProp("仓库地址")
	private String address;

	@ObjectProp("仓库量")
	private BigDecimal number;

	@ObjectProp("仓库创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date addDate;
	
	@ObjectProp("备注信息")
	private String remark;

	@ObjectProp("联系人")
	private String name;

	@ObjectProp("联系电话")
	private String phone;
}
