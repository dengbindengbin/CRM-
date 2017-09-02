package com._520it.crm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com._520it.crm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com._520it.crm.domain.IntegralChange;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.IntegralChangeQueryObject;
import com._520it.crm.service.IIntegralChangeService;

@Controller
public class IntegralChangeController {
	@Autowired
	IIntegralChangeService integralChangeService;
	
	@RequestMapping("integralChange")
	public String index(){
		return "integralChange";
	}
	@RequestMapping("integralChange_list")
	@ResponseBody
	public PageResult list(IntegralChangeQueryObject qo){
		if(qo!=null&&qo.getAmount()!=null){
			Date date = DateUtil.getAgoDate(qo.getAmount());//获取到想要比较的时间
			qo.setStartTime(DateUtil.getStartDate(date));
			qo.setEndTime(DateUtil.getEndDate(date));
		}

		PageResult pageResult = null;
		pageResult = integralChangeService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("integralChange_save")
	@ResponseBody
	public AjaxResult save(IntegralChange integralChange){
		AjaxResult result = null;
		try{
		     integralChange.setTime(new Date());
			integralChangeService.insert(integralChange);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("integralChange_update")
	@ResponseBody
	public AjaxResult update(IntegralChange integralChange){
		AjaxResult result = null;
		try{
			integralChangeService.updateByPrimaryKey(integralChange);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("integralChange_delete")
	@ResponseBody
	public AjaxResult delete(Long integralChangeId){
		AjaxResult result = null;
		try{
			integralChangeService.deleteByPrimaryKey(integralChangeId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("/integralChange_load")
	@ResponseBody
	public PageResult load(Long memberId){
		return  integralChangeService.load(memberId);
	}
}
