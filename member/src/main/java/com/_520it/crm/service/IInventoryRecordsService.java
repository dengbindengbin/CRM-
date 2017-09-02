package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.InventoryRecords;

public interface IInventoryRecordsService {

	int insert(InventoryRecords record);

	List<InventoryRecords> selectAll(Long stocktakingId);

}
