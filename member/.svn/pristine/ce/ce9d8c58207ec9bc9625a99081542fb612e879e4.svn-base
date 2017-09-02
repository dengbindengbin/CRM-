package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductClassify;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductQueryObject;
import com._520it.crm.service.IProductClassifyService;
import com._520it.crm.util.AjaxResult;

@Controller
public class ProductClassifyController {
	@Autowired
	IProductClassifyService kindService;

	@RequestMapping("/kind")
	public String index() {
		return "kind";
	}

	@RequestMapping("/kind_save")
	@ResponseBody
	public AjaxResult save(ProductClassify kind) {
		AjaxResult result = null;
		try {
			kindService.insert(kind);
			result = new AjaxResult(true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "保存失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/kind_list")
	@ResponseBody
	public PageResult list(ProductQueryObject qo) {
		PageResult pageResult = null;
		pageResult = kindService.queryPage(qo);
		return pageResult;
	}

	@RequestMapping("/kind_listAll")
	@ResponseBody
	public List<ProductClassify> selectAll() {
		System.out.println(kindService.selectAll());
		return kindService.selectAll();
	}

	@RequestMapping("/kind_update")
	@ResponseBody
	public AjaxResult update(ProductClassify kind) {
		AjaxResult result = null;
		try {
			kindService.updateByPrimaryKey(kind);
			result = new AjaxResult(true, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "更新失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/kind_delete")
	@ResponseBody
	public AjaxResult delete(Long kindId) {
		AjaxResult result = null;
		try {
			kindService.deleteByPrimaryKey(kindId);
			result = new AjaxResult(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult(false, "删除失败,请联系管理员！");
		}
		return result;
	}
	
	
}
