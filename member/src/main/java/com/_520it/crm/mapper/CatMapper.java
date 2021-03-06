package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.Cat;
import com._520it.crm.query.QueryObject;

public interface CatMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Cat record);
    Cat selectByPrimaryKey(Long id);
    List<Cat> selectAll();
    int updateByPrimaryKey(Cat record);
	Long queryPageCount(QueryObject qo);
	List<Cat> queryPageData(QueryObject qo);
}