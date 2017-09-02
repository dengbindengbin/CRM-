package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IRoleService;
import com._520it.crm.util.AjaxResult;

@Controller
public class RoleController {

	@Autowired
	private IRoleService service;

	@RequestMapping("/role")
	public String index(){
		return "role";
	}

	@RequestMapping("/role_save")
	@ResponseBody
	public AjaxResult save(Role role){
		try{
			service.insert(role);
			return new AjaxResult(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"保存失败!");
	}

	@RequestMapping("/role_list")
	@ResponseBody
	public PageResult list(QueryObject qo){
		return service.queryPageResult(qo);
	}
	@RequestMapping("/role_listAll")
	@ResponseBody
	public List<Role> selectAll( ){
		return service.selectAll();
	}

	@RequestMapping("/role_update")
	@ResponseBody
	public AjaxResult update(Role role){
		try{
			service.updateByPrimaryKey(role);
			return new AjaxResult(true,"更新成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"更新失败!");
	}

	@RequestMapping("/getRolesIdByEmployeeId")
	@ResponseBody
	public List<Long> getRolesIdByEmployeeId(Long employeeId) {
		return service.getRolesIdByEmployeeId(employeeId);
	}
}
