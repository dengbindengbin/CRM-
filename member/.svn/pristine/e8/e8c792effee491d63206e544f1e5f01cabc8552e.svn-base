package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Classify;
import com._520it.crm.domain.Expend;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClassifyQuery;
import com._520it.crm.query.ExpendQuery;

public interface IClassifyService {
	int deleteByPrimaryKey(Long id);

	int insert(Classify record);

	Classify selectByPrimaryKey(Long id);


	int updateByPrimaryKey(Classify record);

	List<Classify> selectAll(ClassifyQuery qo);
	
	Long count(ClassifyQuery qo);
    
    PageResult queryPageResult(ClassifyQuery qo);

}
