package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Classify;
import com._520it.crm.domain.Department;
import com._520it.crm.mapper.ClassifyMapper;
import com._520it.crm.mapper.DepartmentMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClassifyQuery;
import com._520it.crm.query.ExpendQuery;
import com._520it.crm.service.IClassifyService;
import com._520it.crm.service.IDepartmentService;

@Service
public class ClassisyServiceImpl implements IClassifyService{
	@Autowired
	private ClassifyMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Classify record) {
		mapper.insert(record);
		return 0;
	}

	@Override
	public Classify selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Classify> selectAll(ClassifyQuery qo) {
		return mapper.selectAll(qo);
	}

	@Override
	public int updateByPrimaryKey(Classify record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Long count(ClassifyQuery qo) {
		mapper.count(qo);
		return null;
	}

	@Override
	public PageResult queryPageResult(ClassifyQuery qo) {
		Long count = mapper.count(qo);
		if (count==0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}
		return new PageResult(count, mapper.selectAll(qo));
	}

}
