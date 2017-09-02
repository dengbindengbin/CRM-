package com._520it.crm.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryObject {
	//当前页
	private int page = 1;
	//每页显示的数量
	private int rows = 10;

	public int getStart(){
		return (page-1)*rows;
	}

}
