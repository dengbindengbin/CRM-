package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.InventoryRecords;

public interface InventoryRecordsMapper {

	int insert(InventoryRecords record);

	List<InventoryRecords> selectAll(Long stocktakingId);

}