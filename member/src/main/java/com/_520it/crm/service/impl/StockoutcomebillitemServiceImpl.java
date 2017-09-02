package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Stockoutcomebillitem;
import com._520it.crm.mapper.StockoutcomebillitemMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BillSearchQuery;
import com._520it.crm.query.SearchQuery;
import com._520it.crm.service.IStockoutcomebillitemService;
@Service
public class StockoutcomebillitemServiceImpl implements IStockoutcomebillitemService {
	@Autowired
	private StockoutcomebillitemMapper stockoutcomebillitemMapper;
	
	public int deleteByPrimaryKey(Long id) {
		return stockoutcomebillitemMapper.deleteByPrimaryKey(id);
	}

	public int insert(Stockoutcomebillitem record) {
		return stockoutcomebillitemMapper.insert(record);
	}

	public Stockoutcomebillitem selectByPrimaryKey(Long id) {
		return stockoutcomebillitemMapper.selectByPrimaryKey(id);
	}

	public List<Stockoutcomebillitem> selectAll() {
		return stockoutcomebillitemMapper.selectAll();
	}

	public int updateByPrimaryKey(Stockoutcomebillitem record) {
		return stockoutcomebillitemMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(SearchQuery qo) {
		Long count = stockoutcomebillitemMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Stockoutcomebillitem> result = stockoutcomebillitemMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}

	@Override
	public List<Map<String,Object>> getMemberResport(SearchQuery qo) {
		List<Map<String,Object>> memberResport = stockoutcomebillitemMapper.getMemberResport(qo);
		return memberResport;
	}

	@Override
	public List<Map<String, Object>> getClient(SearchQuery qo) {
		List<Map<String, Object>> client = stockoutcomebillitemMapper.getClient(qo);
		return client;
	}

	@Override
	public List<Map<String, Object>> getProductSale(SearchQuery qo) {
		List<Map<String, Object>> productSale = stockoutcomebillitemMapper.getProductSale(qo);
		return productSale;
	}

	@Override
	public List<Map<String, Object>> getPayMoney(BillSearchQuery qo) {
		List<Map<String, Object>> payMoney = stockoutcomebillitemMapper.getPayMoney(qo);
		return payMoney;
	}

	@Override
	public List<Map<String, Object>> getPayMoneyOfClient(BillSearchQuery qo) {
		List<Map<String, Object>> payMoneyOfClient = stockoutcomebillitemMapper.getPayMoneyOfClient(qo);
		return payMoneyOfClient;
	}

	@Override
	public List<Map<String, Object>> getPayMoneyOfMember(BillSearchQuery qo) {
		List<Map<String, Object>> payMoneyOfMember = stockoutcomebillitemMapper.getPayMoneyOfMember(qo);
		return payMoneyOfMember;
	}
}
