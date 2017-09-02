<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="../../static/js/product.js"></script>

<script type="text/javascript">
</script>
</head>
<body>
		
	<!-- 数据表格 -->
	<table id="product_datagrid">
<!-- 				<thead> -->
<!-- 					<tr> -->
<!-- 						<th data-options="field:'sn',width:1,align:'center'">商品编码</th> -->
<!-- 						<th data-options="field:'costPrice',width:1,align:'center'">商品进价</th> -->
<!-- 						<th data-options="field:'weight',width:1,align:'center'">是否计重</th> -->
<!-- 						<th data-options="field:'remark',width:1,align:'center'">备注信息</th> -->
<!-- 						<th data-options="field:'lowPrice',width:1,align:'center'">最低售价</th> -->
<!-- 						<th data-options="field:'kind',width:1,align:'center'">商品类型</th> -->
<!-- 						<th data-options="field:'units',width:1,align:'center'">商品单位</th> -->
<!-- 						<th data-options="field:'integral',width:1,align:'center'">商品积分</th> -->
<!-- 						<th data-options="field:'stock',width:1,align:'center'">商品库存</th> -->
<!-- 						<th data-options="field:'price',width:1,align:'center'">商品售价</th> -->
<!-- 						<th data-options="field:'lowDiscount',width:1,align:'center'">最高售价</th> -->
<!-- 						<th data-options="field:'overdue',width:1,align:'center'">过期时间</th> -->
<!-- 						<th data-options="field:'file',width:1,align:'center'">商品图片</th> -->
<!-- 						<th data-options="field:'name',width:1,align:'center'">商品名称</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
	</table>
	<!-- 新增编辑对话框 -->
	<div id="product_dialog">
		<form id="product_form" method="post" enctype="multipart/form-data">

			<input type="hidden" name="id">
			<table id="productTable" align="center" style="margin-top: 15px;">
				<tr>
					<td>商品名称</td>
					<td>
						<input type="text" name="name">
					</td>
					<td>商品图片</td>
					<td name="qwe" >
						<span name="file"></span>
						 <img  id="filePath" width="50px" height="50px" > 
						<input id="tableFile" type="file" name="img"/>
						
					</td>
				</tr>
			
				<tr>
					<td>商品编码</td>
					<td><input type="text" name="sn"></td>
					<td>商品进价</td>
					<td><input type="text" name="costPrice"></td>
				</tr>
				<tr>
					<td>是否计重</td>
					<td><select id="cc" class="easyui-combobox" name="weight"
						panelHeight='auto' style="width: 143px;">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td>备注信息</td>
					<td><input type="text" name="remark"></td>
				</tr>
				<tr>
					<td>最低售价</td>
					<td><input type="text" name="lowPrice"></td>
					<td>商品类型</td>
					<td><input id="kind_combobox" type="text" name="kind.id"
						class="easyui-combobox"
						data-options="    
							        valueField: 'id',    
							        textField: 'type_name',    
							        url: '/kind_listAll',
							        panelHeight:'auto',
							        multiple:false" />
					</td>
				</tr>
				
				<tr>
					<td>商品单位</td>
					<td><input type="text" name="units"></td>
					<td>商品积分</td>
					<td><input type="text" name="integral"></td>
				</tr>
				
				<tr>
					<td>商品库存</td>
					<td><input type="text" name="stock"></td>
					<td>商品售价</td>
					<td><input type="text" name="price"></td>
				</tr>
				
				<tr>
					<td>最高售价</td>
					<td><input type="text" name="lowDiscount"></td>
					<td>过期时间</td>
					<td><input type="text" name="overdue" class="easyui-datebox"></td>
				</tr>
				
			</table>
		</form>
	</div>
	
	<!-- 数据表格CRUD按钮 -->
	<div id="product_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
				data-cmd="add">新增 </a> 
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				data-cmd="edit">編輯
			</a> 
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
				data-cmd="del">刪除 
			</a> 
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" 
				data-cmd="reload">刷新 
			</a> 
			<!-- 关键字查询 -->
			<input type="text" name="keyword" /> 
			<a href="#"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true" data-cmd="searchForm">查询 
			</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="product_dialog_bt">
		<a id="productDialogBt" class="easyui-linkbutton" iconCls="icon-save" plain="true"
			data-cmd="save">保存</a> <a class="easyui-linkbutton"
			iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>