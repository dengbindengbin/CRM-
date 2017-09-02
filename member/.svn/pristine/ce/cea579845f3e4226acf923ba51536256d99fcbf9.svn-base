package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.MemberLevel;
import com._520it.crm.query.QueryObject;

public interface MemberLevelMapper {
    int deleteByPrimaryKey(Long id);
    int insert(MemberLevel record);
    MemberLevel selectByPrimaryKey(Long id);
    List<MemberLevel> selectAll();
    int updateByPrimaryKey(MemberLevel record);
	Long queryPageCount(QueryObject qo);
	List<MemberLevel> queryPageData(QueryObject qo);
}