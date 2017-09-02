package com._520it.crm.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Classify;
import com._520it.crm.domain.SmallClassify;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SmallClassifyQueryObject;
import com._520it.crm.service.ISmallClassifyService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;

@Controller
public class SmallClassifyController {

	@Autowired
	private ISmallClassifyService service;


	@RequestMapping("/smallclassify_selectByClassify")
	@ResponseBody
	@RequiresPermissions("smallclassify:list")
	@PermissionName("分类列表")
	public List<SmallClassify> list(Long parentId){
		return service.selectByClassify(parentId);
	}
	
	@RequestMapping("/smallclassify_query")
	@ResponseBody
	@RequiresPermissions("smallclassify:list")
	@PermissionName("分类列表")
	public PageResult query(SmallClassifyQueryObject qo){
		return service.queryPage(qo);
	}
	
	@RequestMapping("/smallclassify_delete")
	@ResponseBody
	@RequiresPermissions("smallclassify:view")
	@PermissionName("删除数据")
	public AjaxResult deletes(Long id){
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return  new AjaxResult(true,"删除成功");
		}
	}
	@RequestMapping("/smallclassify_save")
	@ResponseBody
	@RequiresPermissions("classify:save")
	@PermissionName("新增支出")
	public AjaxResult save(SmallClassify c){
		//默认是在职状态
		try{
			service.insert(c);
			return new AjaxResult(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"保存失败!");
	}
	
	
	@RequestMapping("/smallclassify_update")
	@ResponseBody
	public AjaxResult update(SmallClassify c){
		try{
			service.updateByPrimaryKey(c);
			return new AjaxResult(true,"更新成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"更新失败!");
	}
	
	
}
