package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.Stocktaking;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IStocktakingService {
	int deleteByPrimaryKey(Long id);

	int insert(Stocktaking record);

	Stocktaking selectByPrimaryKey(Long warehouseId);

	List<Stocktaking> selectAll();

	int updateByPrimaryKey(Stocktaking record);

	PageResult queryPage(QueryObject qo);

	void updateByPrimaryKeys(Stocktaking stocktaking);

	List<Product> selectByWarehouseId(Long id);

}
