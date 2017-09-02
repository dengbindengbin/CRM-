package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.Stocktaking;
import com._520it.crm.query.QueryObject;

public interface StocktakingMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Stocktaking record);

	Stocktaking selectByPrimaryKey(Long id);

	List<Stocktaking> selectAll();

	int updateByPrimaryKey(Stocktaking record);

	Long queryPageCount(QueryObject qo);

	List<Stocktaking> queryPageData(QueryObject qo);

	void updateByPrimaryKeys(Stocktaking stocktaking);

	List<Product> selectByWarehouseId(Long id);
}