<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理</title>
<%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/supplier.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="supplier_datagrid">
		<!-- <thead>
			<tr>
				<th data-options="field:'factory',width:1,align:'center'">厂商</th>
				<th data-options="field:'debt',width:1,align:'center'">应付欠款</th>
				<th data-options="field:'name',width:1,align:'center'">联系人</th>
				<th data-options="field:'phone',width:1,align:'center'">联系电话</th>
				<th data-options="field:'qq',width:1,align:'center'">QQ号码</th>
				<th data-options="field:'address',width:1,align:'center'">地址</th>
				<th data-options="field:'addDate',width:1,align:'center'">添加时间</th>
				<th data-options="field:'remark',width:1,align:'center'">备注信息</th>
			</tr>
		</thead> -->
	</table>
	<!-- 新增编辑对话框 -->
	<div id="supplier_dialog">
		<form id="supplier_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>厂商</td>
				<td><input type="text" name="factory"></td>
			</tr>
			<tr>
				<td>应付欠款</td>
				<td><input type="text" name="debt"></td>
			</tr>
			<tr>
				<td>联系人</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>QQ号码</td>
				<td><input type="text" name="qq"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>操作人员</td>
				<td><select id="cc" class="easyui-combobox" name="admin"
							panelHeight='auto' style="width: 175px;">
							<option>管理员</option>
							<option>BOSS</option>
						</select></td>
			</tr>
			<tr>
				<td>添加时间</td>
				<td><input type="text"  name="addDate" class="easyui-datebox" ></td>
			</tr>
			<tr>
				<td>备注信息</td>
				<td><input type="text" name="remark"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="supplier_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="supplier_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>