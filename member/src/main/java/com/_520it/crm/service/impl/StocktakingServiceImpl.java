package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.InventoryRecords;
import com._520it.crm.domain.Product;
import com._520it.crm.domain.Stocktaking;
import com._520it.crm.mapper.InventoryRecordsMapper;
import com._520it.crm.mapper.StocktakingMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IStocktakingService;

@Service
public class StocktakingServiceImpl implements IStocktakingService {
	@Autowired
	private StocktakingMapper stocktakingMapper;
	@Autowired
	private InventoryRecordsMapper inventoryRecordsMapper;


	public int deleteByPrimaryKey(Long id) {
		return stocktakingMapper.deleteByPrimaryKey(id);
	}

	public int insert(Stocktaking record) {
		return stocktakingMapper.insert(record);
	}

	public Stocktaking selectByPrimaryKey(Long id) {
		return stocktakingMapper.selectByPrimaryKey(id);
	}

	public List<Stocktaking> selectAll() {
		return stocktakingMapper.selectAll();
	}

	public int updateByPrimaryKey(Stocktaking record) {
		Long changeNumber = record.getChangeNumber();
		record.setCheckTime(new Date());

		InventoryRecords records = new InventoryRecords();
		records.setNumber(record.getNumber());
		records.setChangeNumber(changeNumber);
		records.setEntryTime(record.getCheckTime());
		records.setOperator(record.getOperator());
		records.setStocktakingId(record.getId());
		inventoryRecordsMapper.insert(records);

		record.setNumber(changeNumber);
		record.setChangeNumber(null);
		return stocktakingMapper.updateByPrimaryKey(record);
	}

	/**
	 * 查看库存数量确认
	 */
	@Override
	public void updateByPrimaryKeys(Stocktaking stocktaking) {
		
		stocktaking.setCheckTime(new Date());
				InventoryRecords records = new InventoryRecords();
		records.setNumber(stocktaking.getNumber());
		records.setChangeNumber(null);
		records.setEntryTime(stocktaking.getCheckTime());
		//System.err.println(records.getEntryTime());
		
		records.setOperator(stocktaking.getOperator());
		records.setStocktakingId(stocktaking.getId());
		inventoryRecordsMapper.insert(records);

		stocktakingMapper.updateByPrimaryKeys(stocktaking);
	}

	@Override
	public PageResult queryPage(QueryObject qo) {
		Long count = stocktakingMapper.queryPageCount(qo);
		if (count <= 0) {
			return new PageResult(0L, Collections.EMPTY_LIST);
		}
		List<Stocktaking> result = stocktakingMapper.queryPageData(qo);
		PageResult pageResult = new PageResult(count, result);
		return pageResult;
	}

	
	// 根据warehouseId获取对应的仓库库存
	@Override
	public List<Product> selectByWarehouseId(Long warehouseId) {
		
		return stocktakingMapper.selectByWarehouseId(warehouseId);
	}


}
