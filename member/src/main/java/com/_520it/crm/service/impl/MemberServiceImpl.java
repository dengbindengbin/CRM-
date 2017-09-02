package com._520it.crm.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com._520it.crm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Member;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IMemberService;
import com._520it.crm.vo.MemberVo;
@Service
public class MemberServiceImpl implements IMemberService {
	@Autowired
	private MemberMapper memberMapper;

	public int deleteByPrimaryKey(Long id) {
		return memberMapper.deleteByPrimaryKey(id);
	}

	public int insert(Member record) {
		return memberMapper.insert(record);
	}

	public Member selectByPrimaryKey(Long id) {
		return memberMapper.selectByPrimaryKey(id);
	}

	public List<Member> selectAll() {
		return memberMapper.selectAll();
	}

	public int updateByPrimaryKey(Member record) {
		return memberMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = memberMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Member> result = memberMapper.queryPageData(qo);
		for (Member member : result) {
			System.out.println("---->"+member);
		}
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public MemberVo load() {
		MemberVo vo = new MemberVo();
		Long count = memberMapper.queryMemberCount();
		vo.setTotalMembers(count);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		String format = sdf.format(new Date());
		Long numbers= memberMapper.queryBirday(format);
		vo.setMemberName(numbers);

		List<BigDecimal> bigDecimalist = memberMapper.queryTotalAmount();
		BigDecimal sum=new BigDecimal(0);
		for (BigDecimal bigDecimal : bigDecimalist) {
			sum = sum.add(bigDecimal);
		}
		vo.setTotalAmount(sum);
		return vo;
	}

	@Override
	public int memberByPaymentId(Long id, BigDecimal totalMoney) {
		return memberMapper.memberByPaymentId(id,totalMoney);
	}

	@Override
	public int IntegralChangeByPaymentId(Long id, BigDecimal integral) {
		return memberMapper.IntegralChangeByPaymentId(id,integral);
	}

	@Override
	public int memberdeleteIntegral(Long id) {
		return memberMapper.memberdeleteIntegral(id);
	}

	@Override
	public int memberState(Long id,int state) {
		return memberMapper.memberState(id,state);
	}

	@Override
	public int memberUpdatePhone(Long id, String phone) {
		return memberMapper.memberUpdatePhone(id,phone);
	}


}
