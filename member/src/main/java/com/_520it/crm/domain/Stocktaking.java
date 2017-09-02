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
@ObjectProp("库存盘点")
public class Stocktaking {

	@ObjectProp("序号")
	private Long id;

	@ObjectProp("商品名称")
	private String name;

	
	@ObjectProp("商品类别")
	private String kind;

	@ObjectProp("库存数量")
	private Long number;
	
	@ObjectProp("商品价格")
	private BigDecimal price;
	
	@ObjectProp("更改数量")
	private Long changeNumber;
	
	@ObjectProp("商品单位")
	private String units;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ObjectProp("入库时间")
	private Date entryTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ObjectProp("盘点时间")
	private Date checkTime;

	@ObjectProp("操作人员")
	private String operator;
	
	@ObjectProp("备注信息")
	private String remark;
	
	@ObjectProp("商品编码")
	private String sn;
	
	@ObjectProp("供应商")
	private Long supplierId;
	
	@ObjectProp("商店")
	private Long storeId;
	
	@ObjectProp("仓库")
	private Long warehouseId;
	
	
}
