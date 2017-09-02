package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.MemberPayment;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IMemberPaymentService {
	int deleteByPrimaryKey(Long id);
    int insert(MemberPayment record);
    MemberPayment selectByPrimaryKey(Long id);
    int updateByPrimaryKey(MemberPayment record);
	PageResult queryPage(QueryObject qo);

    List<MemberPayment> selectAll(String sn);
}
