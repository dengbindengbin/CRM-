package com._520it.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.Warehouse;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IWarehouseService {
	int deleteByPrimaryKey(Long id);

	int insert(Warehouse record);

	Warehouse selectByPrimaryKey(Long id);

	List<Warehouse> selectAll();

	int updateByPrimaryKey(Warehouse record);

	PageResult queryPage(QueryObject qo);

	void changeState(@Param("id")Long id,@Param("state")Boolean state);

	List<Product> selectByWarehouseId(Long id);
}
