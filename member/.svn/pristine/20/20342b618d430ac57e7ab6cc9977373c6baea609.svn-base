<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品采购管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/purchaseOrder.js"></script>
<script type="text/javascript">
	$.extend($.fn.datagrid.methods, {
		editCell : function(jq, param) {
			return jq.each(function() {
				var opts = $(this).datagrid('options');
				var fields = $(this).datagrid('getColumnFields', true).concat(
						$(this).datagrid('getColumnFields'));
				for ( var i = 0; i < fields.length; i++) {
					var col = $(this).datagrid('getColumnOption', fields[i]);
					col.editor1 = col.editor;
					if (fields[i] != param.field) {
						col.editor = null;
					}
				}
				$(this).datagrid('beginEdit', param.index);
				for ( var i = 0; i < fields.length; i++) {
					var col = $(this).datagrid('getColumnOption', fields[i]);
					col.editor = col.editor1;
				}
			});
		}
	});

	var editIndex = undefined;
	function endEditing() {
		if (editIndex == undefined) {
			return true
		}
		if ($('#warehouse_datagrid').datagrid('validateRow', editIndex)) {
			$('#warehouse_datagrid').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	function onClickCell(index, field) {
		if (endEditing()) {
			$('#warehouse_datagrid').datagrid('selectRow', index).datagrid(
					'editCell', {
						index : index,
						field : field
					});
			editIndex = index;
		}
	}
</script>

</head>
<body>
	<div id="cc" class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'north',split:false" style="height: 60px;">
			<div>
				<input type="hidden" name="warehouse.id">
				<input type="hidden" name="supplier.id">
			</div>
			<div>
				<span>供应商：</span>
				<input id="supplier" type="text" name="supplier.id"
					class="easyui-combobox"
					data-options="valueField: 'id',
									textField: 'factory',
									required:true,
									url: '/supplier_listAll.do',
									panelHeight:'auto',
									" />
			</div>
			<div>
				<span>仓--库：</span>
				<input id="warehouse" type="text" name="warehouse.id"
					class="easyui-combobox" placeholder="请选择商店"
					data-options="valueField: 'id',
									textField: 'wname',
									required:true,
									url: '/warehouse_listAll.do',
									panelHeight:'auto',
									" />
			</div>

		</div>
		<!-- 购物车 -->
		<div data-options="region:'east',split:false" style="width: 50%;">
			<form id="stockTransShipment_form" method="post">
				<table id="warehouse_datagrid">

				</table>
			</form>
			<div>
				<div style="width: 100%; overflow: hidden;">
					<div class="form-group">
						<span style="font-size: 15px; font-weight: 700;">调拨备注：</span>
						<textarea id="sv_remarks"
							style="width: 150px; height: 18px; text-indent: 5px;"
							placeholder="请输入不超过50个字"></textarea>

						<span style="font-size: 15px; font-weight: 700">总数：</span>
						<label id="sumnumber" style="color: #0026ff; font-size: 16px;"></label>

						<span style="font-size: 15px; font-weight: 700;">合计金额：</span>
						¥
						<label id="summoney" style="color: #ff0000; font-size: 15px;"></label>
						<input type="button" value="调拨" onclick="saveStore()">
						<div class="col-xs-1" style="padding: 0;"></div>
					</div>
				</div>

			</div>
		</div>
		
		<!-- 商品类 -->
		<div data-options="region:'west',split:false" style="width: 50%;">
			<table id="product_datagrid">

			</table>
			<div id="product_datagrid_tb">
				<a class="easyui-linkbutton" iconCls="icon-redo" plain="true"
					onclick="choosePruduct()">选择</a>
			</div>

		</div>

	</div>

</body>
</html>

	<!-- 数据表格 -->
	<!-- <table id="purchaseOrder_datagrid">
		<thead>
			<tr>
				<th data-options="field:'sn',width:1,align:'center'">单据编码</th>
				<th data-options="field:'supplierId',width:1,align:'center'">供应商</th>
				<th data-options="field:'aggregate',width:1,align:'center'">合计</th>
				<th data-options="field:'intTime',width:1,align:'center'">进货日期</th>
				<th data-options="field:'payment',width:1,align:'center'">支付方式</th>
				<th data-options="field:'state',width:1,align:'center'">入库状态</th>
				<th data-options="field:'number',width:1,align:'center'">数量</th>
				<th data-options="field:'warehouseId',width:1,align:'center'">仓库</th>
			</tr>
		</thead>
	</table>
	新增编辑对话框
	<div id="purchaseOrder_dialog">
		<form id="purchaseOrder_form" method="post">
			<table align="center" style="margin-top: 15px;">
				<input type="hidden" name="id">
				<tr>
					<td>合计</td>
					<td>
						<input type="text" name="aggregate">
					</td>
				</tr>
				<tr>
					<td>供应商</td>
					<td>
						<input type="text" name="sn">
					</td>
				</tr>
				<tr>
					<td>进货日期</td>
					<td>
						<input type="text" name="intTime">
					</td>
				</tr>
				<tr>
					<td>支付方式</td>
					<td>
						<input type="text" name="payment">
					</td>
				</tr>
				<tr>
					<td>供应商</td>
					<td>
						<input type="text" name="supplierId">
					</td>
				</tr>
				<tr>
					<td>入库状态</td>
					<td>
						<input type="text" name="state">
					</td>
				</tr>
				<tr>
					<td>数量</td>
					<td>
						<input type="text" name="number">
					</td>
				</tr>
				<tr>
					<td>仓库</td>
					<td>
						<input type="text" name="warehouseId">
					</td>
				</tr>
			</table>
		</form>
	</div>
	数据表格CRUD按钮
	<div id="purchaseOrder_datagrid_tb">
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
	对话框保存取消按钮
	<div id="purchaseOrder_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true"
			data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
			data-cmd="cancel">取消</a>
	</div> -->