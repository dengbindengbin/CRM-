<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存盘点管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/stocktaking.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="stocktaking_datagrid">
		<!-- <thead>
			<tr>
				<th data-options="field:'name',width:1,align:'center'">商品名称</th>
				<th data-options="field:'kind',width:1,align:'center'">商品类型</th>
				<th data-options="field:'number',width:1,align:'center'">库存数量</th>
				<th data-options="field:'units',width:1,align:'center'">商品单位</th>
				<th data-options="field:'entryTime',width:1,align:'center'">入库时间</th>
				<th data-options="field:'checkTime',width:1,align:'center'">上次盘点时间</th>
				<th data-options="field:'operator',width:1,align:'center'">操作人员</th>
				<th data-options="field:'operation3',width:1,align:'center',formatter:operation3Formatter"></th>
				<th data-options="field:'operation1',width:1,align:'center',formatter:operation1Formatter">操作</th>
				<th data-options="field:'operation2',width:1,align:'center',formatter:operation2Formatter"></th>
			</tr>
		</thead> -->
	</table>
	
	<div id="stocktaking_datagrid_tb">
		<div>
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-silver',plain:true"
				data-cmd="exportFile">导出</a>
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">全部</a>
			<!-- 关键字查询 -->
			<input type="text" name="keyword" />
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true"
				data-cmd="searchForm">查询</a>
		</div>
	</div>
	
	<div id="stocktaking_dialog">
		<form id="stocktaking_form" method="post">
			<table align="center" style="margin-top: 15px;">
				<input type="hidden" name="id">
				<tr>
					<td>商品名称</td>
					<td>
						<input type="text" name="name" style="color: green" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>原有库存</td>
					<td>
						<input type="text" name="number" style="color: red" readonly="readonly" >
					</td>
				</tr>
				<tr>
					<td>更改数量</td>
					<td>
						<input type="text" name="changeNumber">
					</td>
				</tr>
				<tr>
					<td>操作人员</td>
					<td>
						<input type="text" name="operator" style="color: green" readonly="readonly" >
					</td>
				</tr>
				<tr>
					<td>备注信息</td>
					<td>
						<input type="text" name="remark" >
					</td>
				</tr>
			</table>
		</form>
		<!-- 对话框保存取消按钮 -->
		<div id="stocktaking_dialog_btt">
			<a class="easyui-linkbutton" iconCls="icon-save" plain="true"
				data-cmd="save">保存</a>
			<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
				data-cmd="cancel">取消</a>
		</div>
	</div>
	<div id="inventoryRecords_dialog_data">
		<div id="cc" class="easyui-layout"
			style="width: 600px; height: 400px;">
			<div data-options="border:false, region:'center',title:'库存商品信息',split:true"
				style="height: 100px;">
				<div id="inventoryRecords_datagrid_data" ></div>
			</div>
		</div>
	</div>

</body>
</html>