package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Supplier;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;
import com._520it.crm.service.ISupplierService;
import com._520it.crm.util.AjaxResult;

@Controller
public class SupplierController {
	@Autowired
	ISupplierService supplierService;
	
	@RequestMapping("supplier")
	public String index(){
		return "supplier";
	}
	@RequestMapping("supplier_list")
	@ResponseBody
	public PageResult list(SupplierQueryObject qo){
		PageResult pageResult = null;
		pageResult = supplierService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("supplier_listAll")
	@ResponseBody
	public List<Supplier> listAll(){
		return supplierService.selectAll();
	}
	@RequestMapping("supplier_save")
	@ResponseBody
	public AjaxResult save(Supplier supplier){
		AjaxResult result = null;
		try{
			supplierService.insert(supplier);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("supplier_update")
	@ResponseBody
	public AjaxResult update(Supplier supplier){
		AjaxResult result = null;
		try{
			supplierService.updateByPrimaryKey(supplier);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("supplier_delete")
	@ResponseBody
	public AjaxResult delete(Long supplierId){
		AjaxResult result = null;
		try{
			supplierService.deleteByPrimaryKey(supplierId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
