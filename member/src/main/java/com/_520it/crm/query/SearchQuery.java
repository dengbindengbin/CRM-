package com._520it.crm.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchQuery extends QueryObject {
	private String value;
	private String name;
	private Date startTime;
	private Date endTime;
	private Date current;
	private String amount;
	private Integer payment;
	private String paytype;
}
