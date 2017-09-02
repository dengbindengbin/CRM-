package com._520it.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.PurchaseOrder;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PurchaseOrderQueryObject;
import com._520it.crm.service.IPurchaseOrderService;
import com._520it.crm.util.AjaxResult;

@Controller
public class PurchaseOrderController {
	@Autowired
	IPurchaseOrderService purchaseOrderService;

	@RequestMapping("purchaseOrder")
	public String index() {
		return "purchaseOrder";
	}

	@RequestMapping("purchaseOrder_list")
	@ResponseBody
	public PageResult list(PurchaseOrderQueryObject qo) {
		PageResult pageResult = null;
		pageResult = purchaseOrderService.queryPage(qo);
		return pageResult;
	}

	@RequestMapping("purchaseOrder_save")
	@ResponseBody
	public AjaxResult save(PurchaseOrder purchaseOrder) {
		AjaxResult result = null;
		try {
			purchaseOrderService.insert(purchaseOrder);
			result = new AjaxResult(true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "保存失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("purchaseOrder_update")
	@ResponseBody
	public AjaxResult update(PurchaseOrder purchaseOrder) {
		AjaxResult result = null;
		try {
			purchaseOrderService.updateByPrimaryKey(purchaseOrder);
			result = new AjaxResult(true, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "更新失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("purchaseOrder_delete")
	@ResponseBody
	public AjaxResult delete(Long purchaseOrderId) {
		AjaxResult result = null;
		try {
			purchaseOrderService.deleteByPrimaryKey(purchaseOrderId);
			result = new AjaxResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "删除失败,请联系管理员！");
		}
		return result;
	}
}
