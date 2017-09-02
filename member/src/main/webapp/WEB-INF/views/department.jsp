<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理管理</title>
<%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/department.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="department_datagrid">
		<thead>
			<tr>
				<th data-options="field:'sn',width:10,align:'center'">部门编号</th>
				<th data-options="field:'name',width:10,align:'center'">部门名称</th>
				<th data-options="field:'manager',width:10,align:'center',formatter:managerFormatter">部门经理</th>
				<th data-options="field:'parent',width:10,align:'center',formatter:parentFormatter">上级部门</th>
				<th data-options="field:'state',width:10,align:'center',formatter:stateFormatter">状态</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="department_dialog">
		<form id="department_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>部门编号</td>
				<td><input type="text" name="sn"></td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>部门经理</td>
				<td>
					<input type="text" name="manager.id" class="easyui-combobox"
						   data-options="
							        valueField: 'id',
							        textField: 'username',
							        url: '/employee_listAll',panelHeight:'auto'" />
				</td>
			</tr>
			<tr>
				<td>上级部门</td>
				<td>
					<input type="text" name="parent.id" class="easyui-combobox"
						   data-options="
							        valueField: 'id',
							        textField: 'name',
							        url: '/department_listAll',panelHeight:'auto'" />
				</td>
			</tr>
			<tr>
				<td>状态:</td>
				<td><select id="cc" class="easyui-combobox" name="state"
							panelHeight='auto' style="width: 143px;">
					<option value="true">正常</option>
					<option value="false">非正常</option>
				</select></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="department_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="department_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>