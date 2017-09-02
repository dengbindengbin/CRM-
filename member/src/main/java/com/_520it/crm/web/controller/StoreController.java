package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Store;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StoreQueryObject;
import com._520it.crm.service.IStoreService;
import com._520it.crm.util.AjaxResult;

@Controller
public class StoreController {
	@Autowired
	IStoreService storeService;
	
	@RequestMapping("store")
	public String index(){
		return "store";
	}
	@RequestMapping("store_list")
	@ResponseBody
	public PageResult list(StoreQueryObject qo){
		PageResult pageResult = null;
		pageResult = storeService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("store_all")
	@ResponseBody
	public List<Store> list(){
		List<Store> selectAll = storeService.selectAll();
		return selectAll;
	}
	@RequestMapping("store_getparent")
	@ResponseBody
	public List<Store>  getParent(){
	List<Store> parent = storeService.getParent();
		return parent;
	}
	@RequestMapping("store_save")
	@ResponseBody
	public AjaxResult save(Store store){
		AjaxResult result = null;
		try{
			storeService.insert(store);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("store_update")
	@ResponseBody
	public AjaxResult update(Store store){
		AjaxResult result = null;
		try{
			storeService.updateByPrimaryKey(store);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("store_delete")
	@ResponseBody
	public AjaxResult delete(Long storeId){
		AjaxResult result = null;
		try{
			storeService.deleteByPrimaryKey(storeId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
