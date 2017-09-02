package com._520it.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.PurchaseOrder;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IPurchaseOrderService {
	int deleteByPrimaryKey(Long id);

	PurchaseOrder selectByPrimaryKey(Long id);

	List<PurchaseOrder> selectAll();

	int updateByPrimaryKey(PurchaseOrder record);

	PageResult queryPage(QueryObject qo);

	void insert(@Param("record")Product record,@Param("wId") Long wId, @Param("sId")Long sId);

	void insert(PurchaseOrder purchaseOrder);

}
