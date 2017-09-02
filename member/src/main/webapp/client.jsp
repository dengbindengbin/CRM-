<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/client.js"></script>
</head>
<script type="text/javascript">
	function formember(value,row,index){
			if(value){
				return "是";
			}
		return "否";
	}
</script>
<body>
	<!-- 数据表格 -->
	<table id="client_datagrid">
		<thead>
			<tr>
				<th data-options="field:'name',width:1,align:'center'">顾客名称</th>
				<th data-options="field:'member',width:1,align:'center',formatter:formember">是否会员</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="client_dialog">
		<form id="client_form" method="post">
			<table align="center" style="margin-top: 15px;">
				<input type="hidden" name="id">
				<tr>
					<td>是否会员</td>
					<td>
						<input id="meId" type="text" name="member.id" class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'name',    
							        url: 'member_list',panelHeight:'auto'" />
					</td>
				</tr>
				<tr>
					<td>顾客名称</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="client_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
				data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true"
				data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
				data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
				data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="client_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true"
			data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
			data-cmd="cancel">取消</a>
	</div>
</body>
</html>