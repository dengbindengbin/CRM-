package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.SmallClassify;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.SmallClassifyQueryObject;

public interface ISmallClassifyService {
	int deleteByPrimaryKey(Long id);

	int insert(SmallClassify record);

	SmallClassify selectByPrimaryKey(Long id);

	List<SmallClassify> selectAll();

	int updateByPrimaryKey(SmallClassify record);
	
	List<SmallClassify> selectByClassify(Long parentId);
	
	PageResult queryPage(SmallClassifyQueryObject qo);
	
	Long queryPageCount(SmallClassifyQueryObject qo);

}
