package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.InventoryRecords;
import com._520it.crm.mapper.InventoryRecordsMapper;
import com._520it.crm.service.IInventoryRecordsService;
@Service
public class InventoryRecordsServiceImpl implements IInventoryRecordsService {
   @Autowired
	private InventoryRecordsMapper inventoryRecordsMapper;
	@Override
	public int insert(InventoryRecords record) {
		
		return inventoryRecordsMapper.insert(record);
	}

	@Override
	public List<InventoryRecords> selectAll(Long stocktakingId) {
		return inventoryRecordsMapper.selectAll(stocktakingId);
	}

}
