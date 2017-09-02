package com._520it.crm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//盘点记录表
@Setter@Getter@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRecords {
	private Long id;
	private Long number ;
	private Long changeNumber ;
	private String operator;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date entryTime;
	private Long stocktakingId;
}
