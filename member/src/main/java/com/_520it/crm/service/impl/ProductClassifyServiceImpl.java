package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.ProductClassify;
import com._520it.crm.mapper.ProductClassifyMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IProductClassifyService;

@Service
public class ProductClassifyServiceImpl implements IProductClassifyService {
	@Autowired
	private ProductClassifyMapper kindMapper;

	public int deleteByPrimaryKey(Long id) {
		// 先删除中间表关系
		kindMapper.deleteRelation(id);
		return kindMapper.deleteByPrimaryKey(id);
	}

	public int insert(ProductClassify record) {
		int count = kindMapper.insert(record);
		return count;
	}

	public ProductClassify selectByPrimaryKey(Long id) {
		return kindMapper.selectByPrimaryKey(id);
	}

	public List<ProductClassify> selectAll() {
		return kindMapper.selectAll();
	}

	public int updateByPrimaryKey(ProductClassify record) {
		return kindMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = kindMapper.queryPageCount(qo);
		if (count <= 0) {
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<ProductClassify> result = kindMapper.queryPageData(qo);
		return new PageResult(count, result);
	}

	


//	
//	@Override
//	public List<Long> getKindIdByProductId(Long employeeId) {
//		return kindMapper.getProductClassifyIdByProductId(employeeId);
//	}
//
//	@Override
//	public List<String> getkindSnByProductId(Long employeeId) {
//		return kindMapper.getProductClassifySnByProductId(employeeId);
//	}


}
