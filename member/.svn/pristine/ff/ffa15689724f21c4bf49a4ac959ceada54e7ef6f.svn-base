package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.InventoryRecords;
import com._520it.crm.service.IInventoryRecordsService;

@Controller
public class InventoryRecordsController {

	@Autowired
	private IInventoryRecordsService recordsService;
	
	
	@RequestMapping("inventoryRecords")
	public String index() {
		return "inventoryRecords";
	}
	
	@RequestMapping("inventoryRecords_list")
	@ResponseBody
	public List<InventoryRecords> lists(Long stocktakingId) {
		
		return recordsService.selectAll(stocktakingId);
	}
}
