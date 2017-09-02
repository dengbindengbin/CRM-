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
@ObjectProp("库存调拨")
public class TransfersRecords {

	@ObjectProp("序号")
	private Long id;
	
	@ObjectProp("调动商品编码")
	private String sn ;
	
	@ObjectProp("调动商品名称")
	private String name;
	
	@ObjectProp("调动商品进价")
	private BigDecimal costPrice;
	
	@ObjectProp("调动交易库存")
	private Long stock;
	
	@ObjectProp("调动商品单位")
	private String units;
	
	@ObjectProp("调动商品类型")
	private String kindName;
	
	@ObjectProp("操作人")
	private String operator;
	
	@ObjectProp("调拨时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date changeTime;
	
	@ObjectProp("仓库")
	private Long warehouseId;
	
	@ObjectProp("商店")
	private Long storeId;
	
}
