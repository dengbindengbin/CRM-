package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.Product;
import com._520it.crm.query.QueryObject;

public interface ProductMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Product record);

	Product selectByPrimaryKey(Long id);

	List<Product> selectAll();

	int updateByPrimaryKey(Product record);

	//
	Long queryPageCount(QueryObject qo);

	List<Product> queryPageData(QueryObject qo);
}