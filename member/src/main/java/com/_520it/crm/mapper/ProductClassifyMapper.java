package com._520it.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.ProductClassify;
import com._520it.crm.query.QueryObject;

public interface ProductClassifyMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ProductClassify record);

	ProductClassify selectByPrimaryKey(Long id);

	List<ProductClassify> selectAll();
		 
	int updateByPrimaryKey(ProductClassify record);

	Long queryPageCount(QueryObject qo);

	List<ProductClassify> queryPageData(QueryObject qo);

	void deleteRelation(Long id);

	void insertRelation(@Param("productId")Long productId,@Param("kendId") Long kendId);
	
	//List<Long> getProductClassifyIdByProductId(Long employeeId);

	//List<String> getProductClassifySnByProductId(Long employeeId);
}