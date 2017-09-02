package com._520it.crm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com._520it.crm.domain.Dictionaryitem;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.DictionaryitemQueryObject;
import com._520it.crm.service.IDictionaryitemService;

@Controller
public class DictionaryitemController {
	@Autowired
	IDictionaryitemService dictionaryitemService;
	
	@RequestMapping("dictionaryitem")
	public String index(){
		return "dictionaryitem";
	}
	@RequestMapping("dictionaryitem_list")
	@ResponseBody
	public PageResult list(DictionaryitemQueryObject qo){
		PageResult pageResult = null;
		pageResult = dictionaryitemService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("dictionaryitem_save")
	@ResponseBody
	public AjaxResult save(Dictionaryitem dictionaryitem){
		AjaxResult result = null;
		try{
			dictionaryitemService.insert(dictionaryitem);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("dictionaryitem_update")
	@ResponseBody
	public AjaxResult update(Dictionaryitem dictionaryitem){
		AjaxResult result = null;
		try{
			dictionaryitemService.updateByPrimaryKey(dictionaryitem);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("dictionaryitem_delete")
	@ResponseBody
	public AjaxResult delete(Long dictionaryId){
		AjaxResult result = null;
		try{
			dictionaryitemService.deleteByPrimaryKey(dictionaryId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("/dictionaryitem_queryByDictionId")
	@ResponseBody
	public List<Dictionaryitem> queryByDictionId(Long id){

		return dictionaryitemService.queryByDictionId(id);
	}
}
