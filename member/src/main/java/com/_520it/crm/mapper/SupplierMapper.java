package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.Supplier;
import com._520it.crm.query.QueryObject;

public interface SupplierMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Supplier record);

	Supplier selectByPrimaryKey(Long id);

	List<Supplier> selectAll();

	int updateByPrimaryKey(Supplier record);

	Long queryPageCount(QueryObject qo);

	List<Supplier> queryPageData(QueryObject qo);
}