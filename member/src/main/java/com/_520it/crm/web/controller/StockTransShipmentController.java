package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockTransShipmentController {
	

	@RequestMapping("stockTransShipment")
	public String index() {
		return "stockTransShipment";
	}
}
