package com._520it.crm.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Cat;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CatQueryObject;
import com._520it.crm.service.ICatService;
import com._520it.crm.util.AjaxResult;

@Controller
public class CatController {
	@Autowired
	ICatService catService;
	
	@RequestMapping("cat")
	public String index(){
		return "cat";
	}
	@RequestMapping("cat_list")
	@ResponseBody
	public PageResult list(CatQueryObject qo){
		PageResult pageResult = null;
		pageResult = catService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("cat_save")
	@ResponseBody
	public AjaxResult save(Cat cat){
		AjaxResult result = null;
		try{
			catService.insert(cat);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("cat_update")
	@ResponseBody
	public AjaxResult update(Cat cat){
		AjaxResult result = null;
		try{
			catService.updateByPrimaryKey(cat);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("cat_delete")
	@ResponseBody
	public AjaxResult delete(Long catId){
		AjaxResult result = null;
		try{
			catService.deleteByPrimaryKey(catId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
