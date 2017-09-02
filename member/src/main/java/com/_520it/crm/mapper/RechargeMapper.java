package com._520it.crm.mapper;

import java.math.BigDecimal;
import java.util.List;

import com._520it.crm.domain.Member;
import com._520it.crm.domain.MemberPayment;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.SearchQuery;

import org.apache.ibatis.annotations.Param;

public interface RechargeMapper {
    int deleteByPrimaryKey(Long id);
    int insert(MemberPayment record);
    MemberPayment selectByPrimaryKey(Long id);
//    List<MemberPayment> selectAll(sn);
    int updateByPrimaryKey(MemberPayment record);
	Long queryPageCount(QueryObject qo);
	List<MemberPayment> queryPageData(QueryObject qo);

    List<MemberPayment> selectAll(String sn);
    List<MemberPayment> getMembet(SearchQuery qo);
}