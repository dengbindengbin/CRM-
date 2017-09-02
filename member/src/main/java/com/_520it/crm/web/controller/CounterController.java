package com._520it.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductClassify;
import com._520it.crm.service.IProductClassifyService;
import com._520it.crm.service.IProductService;

@Controller
public class CounterController {
	@Autowired
	private IProductService ProductService;
	
	@Autowired
	private IProductClassifyService productClassifyService;
	
	
	@RequestMapping("/counter")
	public String count(HttpServletRequest req,HttpServletResponse resp){
		List<Product> products = ProductService.selectAll();
		req.setAttribute("proList", products);
		List<ProductClassify> proClassifyList = productClassifyService.selectAll();
		req.setAttribute("proClassifyList", proClassifyList);
		return "counter";
	}
}
