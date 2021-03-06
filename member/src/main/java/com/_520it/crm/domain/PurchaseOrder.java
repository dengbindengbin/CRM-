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


@Setter@Getter@ToString
@AllArgsConstructor
@NoArgsConstructor
@ObjectProp("商品采购")
public class PurchaseOrder {

	@ObjectProp("单据编号")
	private Long id;
	
	@ObjectProp("供应商")
	private String sn ;
	
	@ObjectProp("数量")
	private Long number ;
	
	@ObjectProp("合计")
	private BigDecimal aggregate;
	
	@ObjectProp("支付方式")
	private String payment ;
	
	@ObjectProp("入库状态")
	private Boolean state ;
	
	@ObjectProp("进货日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date intTime;
	
	@ObjectProp("供应商")
	private Long supplierId;
	
	@ObjectProp("商品")
	private Long productId;
	
	@ObjectProp("仓库")
	private Long warehouseId;
}
