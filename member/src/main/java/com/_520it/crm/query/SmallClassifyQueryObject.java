package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class SmallClassifyQueryObject extends QueryObject {
	private String keywords;
	private Long parentId;
}
