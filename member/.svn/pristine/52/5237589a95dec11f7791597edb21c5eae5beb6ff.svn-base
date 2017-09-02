package com._520it.crm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com._520it.crm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com._520it.crm.domain.MemberPayment;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberPaymentQueryObject;
import com._520it.crm.service.IMemberPaymentService;

@Controller
public class MemberPaymentController {
	@Autowired
	IMemberPaymentService memberPaymentService;
	
	@RequestMapping("memberPayment")
	public String index(){
		return "memberPayment";
	}
	@RequestMapping("memberPayment_list")
	@ResponseBody
	public PageResult list(MemberPaymentQueryObject qo){
		if(qo!=null&&qo.getAmount()!=null){
			Date date = DateUtil.getAgoDate(qo.getAmount());//获取到想要比较的时间
			qo.setStartTime(DateUtil.getStartDate(date));
			qo.setEndTime(DateUtil.getEndDate(date));
		}

		PageResult pageResult = null;
		pageResult = memberPaymentService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("memberPayment_save")
	@ResponseBody
	public AjaxResult save(MemberPayment memberPayment){
		AjaxResult result = null;
		try{

		    memberPayment.setPaymentTime(new Date());
			memberPaymentService.insert(memberPayment);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("memberPayment_update")
	@ResponseBody
	public AjaxResult update(MemberPayment memberPayment){
		AjaxResult result = null;
		try{
			memberPaymentService.updateByPrimaryKey(memberPayment);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("memberPayment_delete")
	@ResponseBody
	public AjaxResult delete(Long memberPaymentId){
		AjaxResult result = null;
		try{
			memberPaymentService.deleteByPrimaryKey(memberPaymentId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("memberPayment_listAll")
	@ResponseBody
	public List<MemberPayment> listAll(String sn){
		List<MemberPayment> result = null;
		try{
			 result = memberPaymentService.selectAll(sn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
