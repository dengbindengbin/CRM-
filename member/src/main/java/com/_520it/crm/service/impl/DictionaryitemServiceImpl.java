package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Dictionaryitem;
import com._520it.crm.mapper.DictionaryitemMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IDictionaryitemService;
@Service
public class DictionaryitemServiceImpl implements IDictionaryitemService {
	@Autowired
	private DictionaryitemMapper dictionaryitemMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return dictionaryitemMapper.deleteByPrimaryKey(id);
	}

	public int insert(Dictionaryitem record) {
		return dictionaryitemMapper.insert(record);
	}

	public Dictionaryitem selectByPrimaryKey(Long id) {
		return dictionaryitemMapper.selectByPrimaryKey(id);
	}

	public List<Dictionaryitem> selectAll() {
		return dictionaryitemMapper.selectAll();
	}

	public int updateByPrimaryKey(Dictionaryitem record) {
		return dictionaryitemMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = dictionaryitemMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Dictionaryitem> result = dictionaryitemMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public List<Dictionaryitem> queryByDictionId(Long id) {
		return dictionaryitemMapper.queryByDictionId(id);
	}
}
