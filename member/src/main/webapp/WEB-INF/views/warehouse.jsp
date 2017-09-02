<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/warehouse.js"></script>
<style>
.div-height {
	border: 1px;
	width: 650px;
	min-height: 200px
}

.div-height1 {
	border: 1px;
	width: 650px;
	min-height: 100px
}
</style>

</head>
<body>
	<!-- 数据表格 -->
	<table id="warehouse_datagrid">
		<!-- <thead>
			<tr>
				<th data-options="field:'sn',width:1,align:'center'">仓库编码</th>
				<th data-options="field:'wname',width:1,align:'center'">仓库名称</th>
				<th data-options="field:'name',width:1,align:'center'">联系人</th>
				<th data-options="field:'phone',width:1,align:'center'">联系电话</th>
				<th data-options="field:'address',width:1,align:'center'">仓库地址</th>
				<th data-options="field:'state',width:1,align:'center'" >仓库状态</th>
				<th data-options="field:'addDate',width:1,align:'center'">仓库创建时间</th>
				<th data-options="field:'remark',width:1,align:'center'">备注信息</th>
			</tr>
		</thead> -->
	</table>
	<!-- 新增编辑对话框 -->
	<div id="warehouse_dialog">
		<form id="warehouse_form" method="post">
			<table align="center" style="margin-top: 15px;">
				<input type="hidden" name="id">
				<tr>
					<td>仓库编码</td>
					<td>
						<input type="text" name="sn">
					</td>
				</tr>
				<tr>
					<td>仓库名称</td>
					<td>
						<input type="text" name="wname">
					</td>
				</tr>
				<tr>
					<td>联系人</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td>
						<input type="text" name="phone" >
					</td>
				</tr>
				<tr>
					<td>仓库地址</td>
					<td>
						<input type="text" name="address">
					</td>
				</tr>
				<tr>
					<td>仓库状态</td>
					<td>
						<select id="cc" class="easyui-combobox" name="state"
							panelHeight='auto' style="width: 175px;">
							<option value="true">启用</option>
							<option value="false">关闭</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>仓库创建时间</td>
					<td>
						<input type="text" name="addDate" class="easyui-datebox">
					</td>
				</tr>
				<tr>
					<td>备注信息</td>
					<td>
						<input type="text" name="remark">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="warehouse_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
				data-cmd="add">新增仓库</a>
			<a id="warehouse_tb_edit" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" data-cmd="edit">修改</a>
			<a class="easyui-linkbutton"
				data-options="iconCls:'icon-lock',plain:true" data-cmd="changeState">启用/关闭</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
				data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
				data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="warehouse_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true"
			data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
			data-cmd="cancel">取消</a>

	</div>
	<div id="warehouse_dialog_data">
		<div id="cc" class="easyui-layout"
			style="width: 685px; height: 435px;">
			<div data-options="border:false, region:'center',title:'库存商品信息',split:true"
				style="height: 100px;">
				<div id="warehouse_datagrid_data" class="div-height"></div>
			</div>
			<!-- <div data-options="border:false, region:'south',split:true"
				style="height: 85px;">
				<div id="warehouse_datagrid_datas" class="div-height1">
					<table id="warehouse_datagrid_datas">
					</table>
					<div>
						<div><span>仓库名称</span></div>
						<div><span>仓库编码</span></div>
						<div><span>联系人</span></div>
					</div>
					<div>
						<div><span>联系电话</span></div>
						<div><span>地址</span></div>
						<div><span>创建时间</span></div>
					</div>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>