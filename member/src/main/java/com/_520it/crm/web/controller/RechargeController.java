package com._520it.crm.web.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.MemberPayment;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SearchQuery;
import com._520it.crm.service.IMemberPaymentService;
import com._520it.crm.service.IMemberService;
import com._520it.crm.service.IRechargeService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.DateUtil;

@Controller
public class RechargeController {
	@Autowired
	private IRechargeService rechargeService;
	
	@RequestMapping("/recharge")
	public String index(){
		return "recharge";
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/recharge_list")
	@ResponseBody
	public List<MemberPayment> list(SearchQuery qo) throws ParseException{
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
		List<MemberPayment> membet = rechargeService.getMembet(qo);
		return membet;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/recharge_change")
	@ResponseBody
	public List<MemberPayment> list2(String sn) throws ParseException{
		 List<MemberPayment> selectAll = rechargeService.selectAll(sn);
		return selectAll;
	}
}
