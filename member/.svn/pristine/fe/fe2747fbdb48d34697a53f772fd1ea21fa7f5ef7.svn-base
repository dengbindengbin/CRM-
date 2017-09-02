<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/static/css/demo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>每日销售明细管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/stockOutcomeBillItem.js"></script>
<!-- <script type="text/javascript" src="/static/js/search.js"></script> -->

</head>
<body>
	<%-- <%@include file="/static/common/search.jsp" %> --%>
	<table>
		<tr>
			<td style="width: 300px; padding: 15px 50px;">
				<div class="easyui-panel" style="width: 100%; padding: 15px 10px;">
					<input id="searchId" class="easyui-searchbox"
						data-options="prompt:'请输入查询信息',menu:'#mm',searcher:doSearch,fit:true">
					<div id="mm">
						<div data-options="name:'client_id',iconCls:'icon-ok'">按会员信息</div>
						<div data-options="name:'serial_number'">按流水单号信息</div>
						<div data-options="name:'productName'">按商品信息</div>
					</div>
				</div>
			</td>
			<td style="padding: 10px 30px;">
				<a class="easyui-linkbutton" iconCls="icon-reload" plain="true">导出</a>
			</td>
			<td style="padding: 10px 30px;">
				<div>
					<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
						onclick="TodaySearch(0)">今天</a>
					<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
						onclick="TodaySearch(-1)">昨天</a>
					<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
						onclick="TodaySearch(-2)">前天</a>
					<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
						onclick="AllSearch()">全部</a>
				</div>
			</td>
			<td>支付方式:</td>
			<td>
				<select id="cc" class="easyui-combobox" name="paytype"
					panelHeight='auto' style="width: 143px;">
					<option value="微信支付">微信支付</option>
					<option value="支付宝支付">支付宝支付</option>
					<option value="现金支付">现金支付</option>
					<option value="信用卡支付">信用卡支付</option>
					<option value="让别人支付">让别人支付</option>
				</select>
			</td>

			<td>消费店铺:</td>
			<td>
				<input name="store.id" type="text" class="easyui-combobox"
					data-options="    
							        valueField: 'id',    
							        textField: 'name',    
							        url: '/store_all',panelHeight:'auto',multiple:false" />
			</td>

		</tr>

	</table>
	<!-- 数据表格 -->
	<table id="stockOutcomeBillItem_datagrid"">
	</table>
	<!-- 新增编辑对话框 -->
	<div id="stockOutcomeBillItem_dialog">
		<form id="stockOutcomeBillItem_form" method="post">
			<table align="center" style="margin-top: 15px;">
				<input type="hidden" name="id">
				<tr>
					<td>销售总金额</td>
					<td>
						<input type="text" name="saleamount">
					</td>
				</tr>
				<tr>
					<td>消费顾客:</td>
					<td>
						<input name="client.id" type="text" class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'name',    
							        url: '/client_all',panelHeight:'auto',multiple:false" />
					</td>
				</tr>
				<tr>
					<td>消费店铺:</td>
					<td>
						<input name="store.id" type="text" class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'name',    
							        url: '/store_all',panelHeight:'auto',multiple:false" />
					</td>
				</tr>
				<tr>
					<td>所属店铺:</td>
					<td>
						<input name="parent.id" type="text" class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'name',    
							        url: '/store_getparent',panelHeight:'auto',multiple:false" />
					</td>
				</tr>
				<tr>
					<td>消费时间</td>
					<td>
						<input type="text" name="intputtime">
					</td>
				</tr>
				<tr>
					<td>支付方式</td>
					<td>
						<input type="text" name="paytype">
					</td>
				</tr>
				<tr>
					<td>总数量</td>
					<td>
						<input type="text" name="number">
					</td>
				</tr>
				<tr>
					<td>单号</td>
					<td>
						<input type="text" name="oddNumbers">
					</td>
				</tr>
				<tr>
					<td>单价</td>
					<td>
						<input type="text" name="saleprice">
					</td>
				</tr>
				<tr>
					<!-- <td>商品名称:</td>
						<td><input id="products_combobox"   name="product.id" type="text"
							class="easyui-combobox"
							data-options="    
							        valueField: 'id',    
							        textField: 'name',    
							        url: '',panelHeight:'auto',multiple:true" />
						</td> -->
				</tr>
				<tr>
					<td>折扣</td>
					<td>
						<input type="text" name="discount">
					</td>
				</tr>
				<tr>
					<td>流水号</td>
					<td>
						<input type="text" name="serialNumber">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="stockOutcomeBillItem_datagrid_tb">
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
	<div id="stockOutcomeBillItem_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true"
			data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
			data-cmd="cancel">取消</a>
	</div>

</body>
</html>