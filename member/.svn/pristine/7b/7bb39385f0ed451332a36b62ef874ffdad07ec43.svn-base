<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存调拨管理</title>
<%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/transfersRecords.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="transfersRecords_datagrid">
		<thead>
			<tr>
				<th data-options="field:'costPrice',width:1,align:'center'">调动商品进价</th>
				<th data-options="field:'sn',width:1,align:'center'">调动商品编码</th>
				<th data-options="field:'stock',width:1,align:'center'">调动交易库存</th>
				<th data-options="field:'store',width:1,align:'center'">商店</th>
				<th data-options="field:'changeTime',width:1,align:'center'">调拨时间</th>
				<th data-options="field:'name',width:1,align:'center'">调动商品名称</th>
				<th data-options="field:'kindName',width:1,align:'center'">调动商品类型</th>
				<th data-options="field:'warehouse',width:1,align:'center'">仓库</th>
				<th data-options="field:'operator',width:1,align:'center'">操作人</th>
				<th data-options="field:'units',width:1,align:'center'">调动商品单位</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="transfersRecords_dialog">
		<form id="transfersRecords_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>调动商品进价</td>
				<td><input type="text" name="costPrice"></td>
			</tr>
			<tr>
				<td>调动商品编码</td>
				<td><input type="text" name="sn"></td>
			</tr>
			<tr>
				<td>调动交易库存</td>
				<td><input type="text" name="stock"></td>
			</tr>
			<tr>
				<td>商店</td>
				<td><input type="text" name="store"></td>
			</tr>
			<tr>
				<td>调拨时间</td>
				<td><input type="text" name="changeTime"></td>
			</tr>
			<tr>
				<td>调动商品名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>调动商品类型</td>
				<td><input type="text" name="kindName"></td>
			</tr>
			<tr>
				<td>仓库</td>
				<td><input type="text" name="warehouse"></td>
			</tr>
			<tr>
				<td>操作人</td>
				<td><input type="text" name="operator"></td>
			</tr>
			<tr>
				<td>调动商品单位</td>
				<td><input type="text" name="units"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="transfersRecords_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="transfersRecords_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>