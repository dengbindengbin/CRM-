package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ProductClassify;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IProductClassifyService {
	int deleteByPrimaryKey(Long id);

	int insert(ProductClassify record);

	ProductClassify selectByPrimaryKey(Long id);

	List<ProductClassify> selectAll();

	int updateByPrimaryKey(ProductClassify record);

	PageResult queryPage(QueryObject qo);

//	List<Long> getKindIdByProductId(Long employeeId);
//
//    List<String> getkindSnByProductId(Long employeeId);
}
