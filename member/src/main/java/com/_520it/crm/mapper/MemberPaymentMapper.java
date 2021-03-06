package com._520it.crm.mapper;

import com._520it.crm.domain.MemberPayment;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberPaymentMapper {
    int deleteByPrimaryKey(Long id);
    int insert(MemberPayment record);
    MemberPayment selectByPrimaryKey(Long id);
//    List<MemberPayment> selectAll(sn);
    int updateByPrimaryKey(MemberPayment record);
	Long queryPageCount(QueryObject qo);
	List<MemberPayment> queryPageData(QueryObject qo);

    List<MemberPayment> selectAll(String sn);
}