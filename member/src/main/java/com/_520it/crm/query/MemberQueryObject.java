package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class MemberQueryObject extends QueryObject {
     //会员等级的查询
    private Long levelId;
    //关键字查询
    private String name;
    private String value;
}
