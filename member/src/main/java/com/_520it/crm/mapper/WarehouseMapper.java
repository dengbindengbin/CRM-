package com._520it.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.Warehouse;
import com._520it.crm.query.QueryObject;

public interface WarehouseMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Warehouse record);

	Warehouse selectByPrimaryKey(Long id);

	List<Warehouse> selectAll();

	int updateByPrimaryKey(Warehouse record);

	Long queryPageCount(QueryObject qo);

	List<Warehouse> queryPageData(QueryObject qo);

	void changeState(@Param("id")Long id,@Param("state")Boolean state);

	List<Product> selectByWarehouseId(Long id);
}