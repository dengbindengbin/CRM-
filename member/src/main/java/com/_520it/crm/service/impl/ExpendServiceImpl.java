package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Expend;
import com._520it.crm.domain.Role;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.mapper.ExpendMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.query.ExpendQuery;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.service.IExpendService;

@Service
public class ExpendServiceImpl implements IExpendService {
	@Autowired
	private ExpendMapper mapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		mapper.deleteByPrimaryKey(id);
		return 0;
	}

	@Override
	public int insert(Expend record) {
		mapper.insert(record);
		return 0;
	}

	@Override
	public Expend selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Expend> selectAll(ExpendQuery qo) {
		return mapper.selectAll(qo);
	}

	@Override
	public int updateByPrimaryKey(Expend record) {
		mapper.updateByPrimaryKey(record);
		return 0;
	}

	@Override
	public Long count(ExpendQuery qo) {
		mapper.count(qo);
		return null;
	}

	@Override
	public PageResult queryPageResult(ExpendQuery qo) {
		Long count = mapper.count(qo);
		if (count==0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}
		return new PageResult(count, mapper.selectAll(qo));
	}

}
