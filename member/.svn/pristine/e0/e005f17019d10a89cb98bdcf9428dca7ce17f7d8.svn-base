package com._520it.crm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com._520it.crm.domain.Department;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com._520it.crm.domain.Dictionary;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.DictionaryQueryObject;
import com._520it.crm.service.IDictionaryService;

@Controller
public class DictionaryController {
	@Autowired
	IDictionaryService dictionaryService;
	
	@RequestMapping("dictionary")
	public String index(){
		return "dictionary";
	}
	@RequestMapping("dictionary_list")
	@ResponseBody
	public PageResult list(DictionaryQueryObject qo){
		PageResult pageResult = null;
		pageResult = dictionaryService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("dictionary_save")
	@ResponseBody
	public AjaxResult save(Dictionary dictionary){
		AjaxResult result = null;
		try{
			dictionaryService.insert(dictionary);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("dictionary_update")
	@ResponseBody
	public AjaxResult update(Dictionary dictionary){
		AjaxResult result = null;
		try{
			dictionaryService.updateByPrimaryKey(dictionary);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("dictionary_delete")
	@ResponseBody
	public AjaxResult delete(Long dictionaryId){
		AjaxResult result = null;
		try{
			dictionaryService.deleteByPrimaryKey(dictionaryId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/dictionary_listAll")
	@ResponseBody
	public List<Dictionary> list(){
		return dictionaryService.selectAll();
	}
}
