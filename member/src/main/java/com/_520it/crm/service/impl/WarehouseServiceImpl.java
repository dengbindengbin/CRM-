package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.Warehouse;
import com._520it.crm.mapper.WarehouseMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IWarehouseService;
@Service
public class WarehouseServiceImpl implements IWarehouseService {
	@Autowired
	private WarehouseMapper warehouseMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return warehouseMapper.deleteByPrimaryKey(id);
	}

	public int insert(Warehouse record) {
		return warehouseMapper.insert(record);
	}

	public Warehouse selectByPrimaryKey(Long id) {
		return warehouseMapper.selectByPrimaryKey(id);
	}

	public List<Warehouse> selectAll() {
		return warehouseMapper.selectAll();
	}

	public int updateByPrimaryKey(Warehouse record) {
		return warehouseMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = warehouseMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Warehouse> result = warehouseMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public void changeState(Long id,Boolean state) {
		warehouseMapper.changeState(id,state);
	}

	@Override
	public List<Product> selectByWarehouseId(Long id) {
		return warehouseMapper.selectByWarehouseId(id);
	}
}
