package com._520it.crm.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Stockoutcomebillitem;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SearchQuery;
import com._520it.crm.service.IStockoutcomebillitemService;
import com._520it.crm.util.DateUtil;

@Controller
public class ProductResportController {
	@Autowired
	private IStockoutcomebillitemService service;

	@RequestMapping("/productResport")
	public String index() {
		return "productresport";
	}

	@RequestMapping("/productResport_list")
	@ResponseBody
	public List<Map<String,Object>> recharge(SearchQuery qo) {
		if(qo!=null&&qo.getAmount()!=null){
			if("-7".equals(qo.getAmount())){
				Date weekStartDate = DateUtil.getWeekStartDate();
				qo.setStartTime(DateUtil.getStartDate(weekStartDate));
				qo.setEndTime(DateUtil.getEndDate(new Date()));
				System.out.println("星期一:"+weekStartDate);
			}else{
				Date date = DateUtil.getAgoDate(qo.getAmount());//获取到想要比较的时间
				qo.setStartTime(DateUtil.getStartDate(date));
				qo.setEndTime(DateUtil.getEndDate(date));
			}
		}
		List<Map<String,Object>> productResport = service.getProductSale(qo);
		return productResport;
	}
	@RequestMapping("/productResport_load")
	@ResponseBody
	public List<Map<String,Object>> recharge2(SearchQuery qo) {
		if(qo!=null&&qo.getAmount()!=null){
			if("-7".equals(qo.getAmount())){
				Date weekStartDate = DateUtil.getWeekStartDate();
				qo.setStartTime(DateUtil.getStartDate(weekStartDate));
				qo.setEndTime(DateUtil.getEndDate(new Date()));
				System.out.println("星期一:"+weekStartDate);
			}else{
				Date date = DateUtil.getAgoDate(qo.getAmount());//获取到想要比较的时间
				qo.setStartTime(DateUtil.getStartDate(date));
				qo.setEndTime(DateUtil.getEndDate(date));
			}
		}
		List<Map<String,Object>> productResport = service.getProductSale(qo);
		return productResport;
	}

}
