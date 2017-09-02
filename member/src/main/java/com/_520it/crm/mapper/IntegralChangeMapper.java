package com._520it.crm.mapper;

import com._520it.crm.domain.IntegralChange;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralChangeMapper {
    int deleteByPrimaryKey(Long id);
    int insert(IntegralChange record);
    IntegralChange selectByPrimaryKey(Long id);
    List<IntegralChange> selectAll();
    int updateByPrimaryKey(IntegralChange record);
	Long queryPageCount(QueryObject qo);
	List<IntegralChange> queryPageData(QueryObject qo);

    List<IntegralChange> load(Long memberId);
}