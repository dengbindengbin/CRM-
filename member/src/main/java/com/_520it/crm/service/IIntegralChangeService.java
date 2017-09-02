package com._520it.crm.service;
import java.util.List;
import com._520it.crm.domain.IntegralChange;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IIntegralChangeService {
	int deleteByPrimaryKey(Long id);
    int insert(IntegralChange record);
    IntegralChange selectByPrimaryKey(Long id);
    List<IntegralChange> selectAll();
    int updateByPrimaryKey(IntegralChange record);
	PageResult queryPage(QueryObject qo);

    PageResult load(Long memberId);
}
