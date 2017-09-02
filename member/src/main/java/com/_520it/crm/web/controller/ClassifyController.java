package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Classify;
import com._520it.crm.domain.Department;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClassifyQuery;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.IClassifyService;
import com._520it.crm.service.IDepartmentService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class ClassifyController {

	@Autowired
	private IClassifyService service;


	@RequestMapping("/classify_selectAll")
	@ResponseBody
	@RequiresPermissions("classify:list")
	@PermissionName("分类列表")
	public PageResult lists(ClassifyQuery qo){
		return service.queryPageResult(qo);
	}
	
	@RequestMapping("/classify_selectByPrimaryKey")
	@ResponseBody
	@RequiresPermissions("classify:selectByPrimaryKey")
	public Classify lists(Long id){
		return service.selectByPrimaryKey(id);
	}
	
	@RequestMapping("/classify_select")
	@ResponseBody
	@RequiresPermissions("classify:list")
	@PermissionName("分类列表")
	public List<Classify> index(ClassifyQuery qo){
		return service.selectAll(qo);
	}
	
	@RequestMapping("/classify")
	@RequiresPermissions("classify:list")
	@PermissionName("分类列表")
	public String index(){
		return "classify";
	}
	
	@RequestMapping("/classify_delete")
	@ResponseBody
	@RequiresPermissions("classify:view")
	@PermissionName("删除数据")
	public AjaxResult delete(Long id){
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return  new AjaxResult(true,"删除成功");
		}
	}
	@RequestMapping("/classify_save")
	@ResponseBody
	@RequiresPermissions("classify:save")
	@PermissionName("新增支出")
	public AjaxResult save(Classify c){
		//默认是在职状态
		try{
			service.insert(c);
			return new AjaxResult(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"保存失败!");
	}
	
	
	@RequestMapping("/classify_update")
	@ResponseBody
	public AjaxResult update(Classify c){
		try{
			service.updateByPrimaryKey(c);
			return new AjaxResult(true,"更新成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"更新失败!");
	}
}
