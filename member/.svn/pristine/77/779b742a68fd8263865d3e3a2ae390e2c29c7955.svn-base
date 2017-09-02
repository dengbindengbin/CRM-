<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/static/css/demo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>每日销售明细管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/productresport.js"></script>
<script type="text/javascript">
	function fortime(value,rowData,rowIndex){
		console.debug(rowData);
		//return value.format('yyyy-MM-dd');
	};



</script>
</head>
<style type="text/css">
.a {
	background-color: blue;
	border: 1px solid #000;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
	height: 150px;
	width: 250px;
	padding: 20px;
}
</style>
<style type="text/css">
.b {
	background-color: #c7dec6;
	/* border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px; */
	height: 60px;
	width: 150px;
	padding: 20px;
}
</style>
<body>
	<table>
		<thead>
			<tr>
				<td style="padding: 10px 30px;">
					<a class="easyui-linkbutton" iconCls="icon-abc5" plain="true">导出</a>
				</td>
				<td style="padding: 10px 30px;">
					<div>
						<a class="easyui-linkbutton" iconCls="icon-abc6" plain="true"
							onclick="TodaySearch(0)">今天</a>
						<a class="easyui-linkbutton" iconCls="icon-abc2" plain="true"
							onclick="TodaySearch(-1)">昨天</a>
						<a class="easyui-linkbutton" iconCls="icon-abc3" plain="true"
							onclick="TodaySearch(-7)">本周</a>
						<a class="easyui-linkbutton" iconCls="icon-abc4" plain="true"
							onclick="AllSearch()">全部</a>
					</div>
				</td>

			</tr>
		</thead>
		<tbody>
			<div>
				<tr>
					<!--会员详情-->
				 <p style="font-size: 20px">销售统计</p>
					<div style="background-color: #8D8D8D" id="memberVo">
	
						<div id="leftpanel"
							style="border: 1px solid #f26d7e; width: 19%; height: 100px; margin: 1px 5px 20px 70px; float: left">
							<p style="font-size: medium; height: 1px">销售笔数:</p>
							<p style="color: red; font-size: x-large; text-align: center">
								<i id="bircount1" style="font-size: 50px"></i>
							</p>
						</div>
						<div id="centerpanel"
							style="border: 1px solid #f26d7e; width: 19%; height: 100px; margin: 1px 5px 10px 10px; float: left;">
							<p style="font-size: medium; height: 1px">销售额:</p>
							<p style="color: orange; font-size: x-large; text-align: center">
								<i id="usercount1" style="font-size: 50px"></i>
							</p>
						</div>
						<div id="rightpanel"
							style="border: 1px solid #f26d7e; width: 19%; height: 100px; margin: 1px 5px 20px 20px; float: left">
							<p style="font-size: medium; height: 1px">销售毛利:</p>
							<p style="color: red; font-size: x-large; text-align: center">
								<i id="recelivableCount1" style="font-size: 50px"></i>
							</p>
						</div>
						<div id="rightpanel"
							style="border: 1px solid #f26d7e; width: 19%; height: 100px; margin: 1px 5px 20px 20px; float: left">
							<p style="font-size: medium; height: 1px">毛利率:</p>
							<p style="color: red; font-size: x-large; text-align: center">
								<i id="recelivableName1" style="font-size: 50px"></i>
							</p>
						</div>
					</div>
				</tr>
		</tbody>
	</table>

	<!-- 数据表格 -->
	<!-- <table id="stockOutcomeBillItem_datagrid"> -->
	<table id="memberresport_datagrid">
		<thead>
			<tr>
				<th data-options="field:'psn',width:15,align:'center'">产品条码</th>
				<th
					data-options="field:'pname',width:15,align:'center'">产品名称</th>
				<th data-options="field:'totalnumber',width:15,align:'center'">销售数量</th>
				<th data-options="field:'totalamount',width:15,align:'center'">销售额</th>
				<th data-options="field:'maoli',width:15,align:'center'">销售毛利</th>
				<th data-options="field:'lilv',width:15,align:'center'">毛利率</th>
			<!-- 	<th data-options="field:'intputtime',width:15,align:'center'">消费时间</th> -->
			</tr>
		</thead>
	</table>
	</table>

</body>
</html>