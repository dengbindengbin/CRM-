package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.Warehouse;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.WarehouseQueryObject;
import com._520it.crm.service.IWarehouseService;
import com._520it.crm.util.AjaxResult;

@Controller
public class WarehouseController {
	@Autowired
	IWarehouseService warehouseService;
	
	@RequestMapping("warehouse")
	public String index(){
		return "warehouse";
	}
	@RequestMapping("warehouse_list")
	@ResponseBody
	public PageResult list(WarehouseQueryObject qo){
		PageResult pageResult = null;
		pageResult = warehouseService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("warehouse_listAll")
	@ResponseBody
	public List<Warehouse> listAll(){
		return warehouseService.selectAll();
	}
	
	// 通过中间表获取对应仓库的商品
	@RequestMapping("productByWarehouseId_list")
	@ResponseBody
	public List<Product> list(Long id){
		return warehouseService.selectByWarehouseId(id);
	}
	
	@RequestMapping("/warehouse_changeState")
	@ResponseBody
	public AjaxResult changeState(Long id) {
		try{
			Warehouse warehouse = warehouseService.selectByPrimaryKey(id);
			warehouseService.changeState(id,warehouse.getState());
			return new AjaxResult(true,"设置成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"设置失败!");
	}
	
	@RequestMapping("warehouse_save")
	@ResponseBody
	public AjaxResult save(Warehouse warehouse){
		AjaxResult result = null;
		try{
			warehouseService.insert(warehouse);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("warehouse_update")
	@ResponseBody
	public AjaxResult update(Warehouse warehouse){
		AjaxResult result = null;
		try{
			warehouseService.updateByPrimaryKey(warehouse);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("warehouse_delete")
	@ResponseBody
	public AjaxResult delete(Long warehouseId){
		AjaxResult result = null;
		try{
			warehouseService.deleteByPrimaryKey(warehouseId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}
}
