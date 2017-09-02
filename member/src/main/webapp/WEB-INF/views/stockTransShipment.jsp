<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存调拨</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/stockTransShipment.js"></script>

<script type="text/javascript">
		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});
		
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#store_datagrid').datagrid('validateRow', editIndex)){
				$('#store_datagrid').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (endEditing()){
				$('#store_datagrid').datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
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
				<input type="hidden" name="store.id">
			</div>
			<div>
				<span>仓库：</span>
				<input id="warehouse" type="text" name="warehouse.id"
					class="easyui-combobox"
					data-options="valueField: 'id',
									textField: 'wname',
									required:true,
									url: '/warehouse_listAll.do',
									panelHeight:'auto',
									" />
			</div>
			<div>
				<span>商店：</span>
				<input id="store" type="text" name="store.id"
					class="easyui-combobox" placeholder="请选择商店"
					data-options="valueField: 'id',
									textField: 'name',
									required:true,
									url: '/store_all.do',
									panelHeight:'auto',
									" />
			</div>

		</div>
		<div data-options="region:'east',split:false" style="width: 50%;">
			<form id="stockTransShipment_form" method="post">
				<table id="store_datagrid">

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
		<div data-options="region:'west',split:false" style="width: 50%;">
			<table id="warehouse_datagrid">

			</table>
			<div id="warehouse_datagrid_tb">
				<a class="easyui-linkbutton" iconCls="icon-redo" plain="true"
					onclick="choosePruduct()">选择</a>
			</div>

		</div>

	</div>
</body>
</html>