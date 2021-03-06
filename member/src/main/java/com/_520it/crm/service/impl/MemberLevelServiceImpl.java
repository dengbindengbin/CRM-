package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.MemberLevel;
import com._520it.crm.mapper.MemberLevelMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IMemberLevelService;
@Service
public class MemberLevelServiceImpl implements IMemberLevelService {
	@Autowired
	private MemberLevelMapper memberLevelMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return memberLevelMapper.deleteByPrimaryKey(id);
	}

	public int insert(MemberLevel record) {
		return memberLevelMapper.insert(record);
	}

	public MemberLevel selectByPrimaryKey(Long id) {
		return memberLevelMapper.selectByPrimaryKey(id);
	}

	public List<MemberLevel> selectAll() {
		return memberLevelMapper.selectAll();
	}

	public int updateByPrimaryKey(MemberLevel record) {
		return memberLevelMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = memberLevelMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<MemberLevel> result = memberLevelMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
