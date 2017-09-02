package com._520it.crm.mapper;

import com._520it.crm.domain.Classify;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClassifyQuery;

import java.util.List;

public interface ClassifyMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Classify record);

    Classify selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Classify record);

	List<Classify> selectAll(ClassifyQuery qo);
	
	Long count(ClassifyQuery qo);
    
    PageResult queryPageResult(ClassifyQuery qo);
}