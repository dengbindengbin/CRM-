package com._520it.crm.service;
import java.util.List;
import java.util.Map;

import com._520it.crm.domain.Stockoutcomebillitem;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BillSearchQuery;
import com._520it.crm.query.SearchQuery;

public interface IStockoutcomebillitemService {
	int deleteByPrimaryKey(Long id);
    int insert(Stockoutcomebillitem record);
    Stockoutcomebillitem selectByPrimaryKey(Long id);
    List<Stockoutcomebillitem> selectAll();
    int updateByPrimaryKey(Stockoutcomebillitem record);
	PageResult queryPage(SearchQuery qo);
	List<Map<String,Object>> getMemberResport(SearchQuery qo);
	List<Map<String,Object>> getClient(SearchQuery qo);
	List<Map<String,Object>> getProductSale(SearchQuery qo);
	List<Map<String,Object>> getPayMoney(BillSearchQuery qo);
	List<Map<String,Object>> getPayMoneyOfClient(BillSearchQuery qo);
	List<Map<String,Object>> getPayMoneyOfMember(BillSearchQuery qo);
}
