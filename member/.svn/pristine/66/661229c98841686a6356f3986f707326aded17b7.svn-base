package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Member;
import com._520it.crm.domain.MemberPayment;
import com._520it.crm.mapper.MemberPaymentMapper;
import com._520it.crm.mapper.RechargeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.SearchQuery;
import com._520it.crm.service.IMemberPaymentService;
import com._520it.crm.service.IRechargeService;
@Service
public class RechargeImpl implements IRechargeService {
	@Autowired
	private MemberPaymentMapper memberPaymentMapper;
	@Autowired
	private RechargeMapper rechargeMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return memberPaymentMapper.deleteByPrimaryKey(id);
	}

	public int insert(MemberPayment record) {
		return memberPaymentMapper.insert(record);
	}

	public MemberPayment selectByPrimaryKey(Long id) {
		return memberPaymentMapper.selectByPrimaryKey(id);
	}



	public int updateByPrimaryKey(MemberPayment record) {
		return memberPaymentMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = memberPaymentMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<MemberPayment> result = memberPaymentMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public List<MemberPayment> selectAll(String sn) {
		return memberPaymentMapper.selectAll(sn);
	}

	@Override
	public List<MemberPayment> getMembet(SearchQuery qo) {
		List<MemberPayment> membets = rechargeMapper.getMembet(qo);
		return membets;
	}
}
