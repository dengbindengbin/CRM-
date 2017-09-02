package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Store;
import com._520it.crm.mapper.StoreMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IStoreService;
@Service
public class StoreServiceImpl implements IStoreService {
	@Autowired
	private StoreMapper storeMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return storeMapper.deleteByPrimaryKey(id);
	}

	public int insert(Store record) {
		return storeMapper.insert(record);
	}

	public Store selectByPrimaryKey(Long id) {
		return storeMapper.selectByPrimaryKey(id);
	}

	public List<Store> selectAll() {
		return storeMapper.selectAll();
	}

	public int updateByPrimaryKey(Store record) {
		return storeMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = storeMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Store> result = storeMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public List<Store> getParent() {
		List<Store> parent = storeMapper.getParent();
		return parent;
	}
}
