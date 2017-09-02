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
import com._520it.crm.domain.Stocktaking;
import com._520it.crm.domain.Store;
import com._520it.crm.domain.TransfersRecords;
import com._520it.crm.mapper.TransfersRecordsMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IStocktakingService;
import com._520it.crm.service.IStoreService;
import com._520it.crm.service.ITransfersRecordsService;
@Service
public class TransfersRecordsServiceImpl implements ITransfersRecordsService {
	@Autowired
	private TransfersRecordsMapper transfersRecordsMapper;

	@Autowired
	private IStocktakingService stocktakingService;
	
	public void insert(Product record,Long wId,Long sId) {
		//获取身份信息
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		// 调拨记录
		TransfersRecords records = new TransfersRecords();
			records.setSn(record.getSn());
			records.setName(record.getName());
			records.setCostPrice(record.getCostPrice());
			records.setStock(record.getStock());
			records.setUnits(record.getUnits());
			records.setKindName(record.getKind().getType_name());
			
			records.setOperator(((Employee) principal).getRealname());
			records.setChangeTime(new Date());
			records.setWarehouseId(wId);
			records.setStoreId(sId);
			transfersRecordsMapper.insert(records);
		}

	public List<TransfersRecords> selectAll() {
		return transfersRecordsMapper.selectAll();
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = transfersRecordsMapper.queryPageCount(qo);
		if(count<=0){
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<TransfersRecords> result = transfersRecordsMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count,result);
		return pageResult;
	}
}
