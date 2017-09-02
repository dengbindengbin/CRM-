package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Product;
import com._520it.crm.domain.PurchaseOrder;
import com._520it.crm.domain.Stocktaking;
import com._520it.crm.mapper.PurchaseOrderMapper;
import com._520it.crm.mapper.StocktakingMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	@Autowired
	private PurchaseOrderMapper purchaseOrderMapper;
	@Autowired
	private StocktakingMapper stocktakingMapper; 
	
	public int deleteByPrimaryKey(Long id) {
		return purchaseOrderMapper.deleteByPrimaryKey(id);
	}

	public void insert(Product record,Long wId,Long sId) {
		
		// 保存到库存中	
		//获取身份信息
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		// 
		Stocktaking records = new Stocktaking();
			records.setSn(record.getSn());
			records.setName(record.getName());
			records.setNumber(record.getStock());
			records.setUnits(record.getUnits());
			records.setPrice(record.getCostPrice());
			if (record.getKind()!=null) {
				records.setKind(record.getKind().getType_name());
			}
			records.setOperator(((Employee) principal).getRealname());
			records.setEntryTime(new Date());
			records.setWarehouseId(wId);
			records.setSupplierId(sId);
			
			System.out.println("records:"+records);
			stocktakingMapper.insert(records);
		}

	public PurchaseOrder selectByPrimaryKey(Long id) {
		return purchaseOrderMapper.selectByPrimaryKey(id);
	}

	public List<PurchaseOrder> selectAll() {
		return purchaseOrderMapper.selectAll();
	}

	public int updateByPrimaryKey(PurchaseOrder record) {
		return purchaseOrderMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = purchaseOrderMapper.queryPageCount(qo);
		if (count <= 0) {
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<PurchaseOrder> result = purchaseOrderMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count, result);
		return pageResult;
	}

	@Override
	public void insert(PurchaseOrder purchaseOrder) {
		purchaseOrderMapper.insert(purchaseOrder);
	}

	
}
