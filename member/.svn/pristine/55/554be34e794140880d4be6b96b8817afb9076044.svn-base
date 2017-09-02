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
import com._520it.crm.domain.Department;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.DepartmentQueryObject;
import com._520it.crm.service.IDepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	IDepartmentService departmentService;
	
	@RequestMapping("department")
	public String index(){
		return "department";
	}
	@RequestMapping("department_list")
	@ResponseBody
	public PageResult list(DepartmentQueryObject qo){
		PageResult pageResult = null;
		pageResult = departmentService.queryPage(qo);
		return pageResult;
	}
	@RequestMapping("department_save")
	@ResponseBody
	public AjaxResult save(Department department){
		AjaxResult result = null;
		try{
			departmentService.insert(department);
			result = new AjaxResult(true,"保存成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"保存失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("department_update")
	@ResponseBody
	public AjaxResult update(Department department){
		AjaxResult result = null;
		try{
			departmentService.updateByPrimaryKey(department);
			result = new AjaxResult(true,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"更新失败,请联系管理员！");
		}
		return result;
	}
	@RequestMapping("department_delete")
	@ResponseBody
	public AjaxResult delete(Long departmentId){
		AjaxResult result = null;
		try{
			departmentService.deleteByPrimaryKey(departmentId);
			result = new AjaxResult(true,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result = new AjaxResult(false,"删除失败,请联系管理员！");
		}
		return result;
	}

	@RequestMapping("department_listAll")
	@ResponseBody
	public List<Department> listAll(DepartmentQueryObject qo){
		return departmentService.selectAll();
	}
}
