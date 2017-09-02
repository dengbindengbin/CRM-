package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Expend;
import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ExpendQuery;
import com._520it.crm.query.QueryObject;

public interface IExpendService {
		int deleteByPrimaryKey(Long id);

	    int insert(Expend record);

	    Expend selectByPrimaryKey(Long id);

	    int updateByPrimaryKey(Expend record);
	    
	    Long count(ExpendQuery qo);
	    
	    PageResult queryPageResult(ExpendQuery qo);

		List<Expend> selectAll(ExpendQuery qo);
	    
}
