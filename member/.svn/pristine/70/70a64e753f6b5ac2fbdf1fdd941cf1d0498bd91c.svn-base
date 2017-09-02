<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺管理</title>
<%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/store.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="store_datagrid">
		<thead>
			<tr>
				<th data-options="field:'manager',width:1,align:'center'">店长</th>
				<th data-options="field:'stocktaking',width:1,align:'center'">库存</th>
				<th data-options="field:'address',width:1,align:'center'">店铺地址</th>
				<th data-options="field:'name',width:1,align:'center'">店铺名称</th>
				<th data-options="field:'tel',width:1,align:'center'">联系电话</th>
				<th data-options="field:'state',width:1,align:'center'">店铺状态</th>
				<th data-options="field:'parent',width:1,align:'center'">所属店铺</th>
				<th data-options="field:'inputtime',width:1,align:'center'">开业时间</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="store_dialog">
		<form id="store_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>店长</td>
				<td><input type="text" name="manager"></td>
			</tr>
			<tr>
				<td>库存</td>
				<td><input type="text" name="stocktaking"></td>
			</tr>
			<tr>
				<td>店铺地址</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>店铺名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>店铺状态</td>
				<td><input type="text" name="state"></td>
			</tr>
			<tr>
				<td>所属店铺</td>
				<td><input type="text" name="parent"></td>
			</tr>
			<tr>
				<td>开业时间</td>
				<td><input type="text" name="inputtime"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="store_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="store_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>