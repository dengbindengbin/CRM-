<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>productMenu管理</title>
<%@include file="../../static/common/common.jsp"%>
<!-- <script type="text/javascript"
	src="/static/js/nicescroll/jquery-1.5.2.min.js"></script> -->
<script type="text/javascript" src="../../static/js/product.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url : 'product_list',
			fitColumns:true,
			columns : [  [ 
			  {
				field : 'file',
				title : '商品图片',
				width : 100,
				formatter :imgFormatter
			},{
				field : 'sn',
				title : '商品编码',
				width : 100
			}, {
				field : 'name',
				title : '商品名称',
				width : 100
			}, {
				field : 'weight',
				title : '是否计重',
				width : 100,
				formatter : function (value, row, index) {
					return value ? "是" : "否";
				}
			}, {
				field : 'costPrice',
				title : '商品进价',
				width : 100
			}, {
				field : 'remark',
				title : '备注信息',
				width : 100,
			}, {
				field : 'lowPrice',
				title : '最低售价',
				width : 100,
			}, {
				field : 'units',
				title : '商品单位',
				width : 100,
			}, {
				field : 'integral',
				title : '商品积分',
				width : 100,
			}, {
				field : 'stock',
				title : '商品库存',
				width : 100,
			}, {
				field : 'price',
				title : '商品售价',
				width : 100,
			}, {
				field : 'lowDiscount',
				title : '最高售价',
				width : 100,
			}, {
				field : 'overdue',
				title : '过期时间',
				width : 100,
			}, {
				field : 'kind',
				title : '商品类型',
				width : 100,
				formatter : function (value, row, index) {
					return value ? value.type_name : "";
				}
			} ] ]
		});
		$("#combobox").combobox({
			url : 'kind_listAll',//查询productclass的 namede controller   
			valueField : 'id',//productclass 中的name    
			textField : 'type_name',//随便
			value:['--------请选择类型------------'],//初始值
			onChange : function() {
				var value = $("#combobox").combobox("getValue");
				$('#dg').datagrid('load', {
					"id" : value
				})
			}
			});
		})
		
	// 商品图片格式化
	function imgFormatter(value, row, index) {
		console.log(row.file);
		return value ? "<img alt='ooxx' height='100' src='"+row.file+"'>" : "";
	}
	</script>

</head>
<body class="easyui-layout" split="true">
	<!--    下:-->
	<div data-options="region:'center'" 
		style="padding-left: 0px;padding:5px; background: #eee;">
<!--		下拉框  -->
		<h3>要查询商品的类型：
			<input id="combobox" 
				class="easyui-combobox"  name="type_name"  />
		</h3>
		<table id="dg"></table>
	</div>
</body>
</html>