package com._520it.crm.service;
import java.util.List;

import com._520it.crm.domain.Member;
import com._520it.crm.domain.MemberPayment;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.SearchQuery;

public interface IRechargeService {
	int deleteByPrimaryKey(Long id);
    int insert(MemberPayment record);
    MemberPayment selectByPrimaryKey(Long id);
    int updateByPrimaryKey(MemberPayment record);
	PageResult queryPage(QueryObject qo);
	 List<MemberPayment> getMembet(SearchQuery qo);
    List<MemberPayment> selectAll(String sn);
}
