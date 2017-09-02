<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/static/css/demo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>每日销售明细管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/recharge.js"></script>
<!-- <script type="text/javascript" src="/static/js/search.js"></script> -->

</head>
<style type="text/css">
.a {
	background-color: #c7dec6;
	border: 1px solid #000;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
	height: 150px;
	width: 250px;
	padding: 20px;
}
</style >
<style type="text/css">
.b {
	background-color: #c7dec6;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
	height: 50px;
	width: 100%;
	padding: 20px;
}
</style >
<body>
	<table class="b">
		<tr>
			<!-- <td style="width: 300px; padding: 15px 50px; ">
				<div class="easyui-panel" style="width: 100%; padding: 15px 10px;">
					<input id="searchId" class="easyui-searchbox"
						data-options="prompt:'请输入查询信息',menu:'#mm',searcher:doSearch,fit:true">
					<div id="mm">
						<div data-options="name:'client_id',iconCls:'icon-ok'">按会员信息</div>
						<div data-options="name:'serial_number'">按流水单号信息</div>
						<div data-options="name:'productName'">按商品信息</div>
					</div>
				</div>
			</td> -->
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
						onclick="TodaySearch(-7)">本周</a>
					<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
						onclick="AllSearch()">全部</a>
				</div>
			</td>
			<td>支付方式:</td>
			<td>
				<select id="cc" class="easyui-combobox" name="payment"
					panelHeight='auto' style="width: 143px; height: 30px">
					<option value="1">现金</option>
					<option value="2">微信支付</option>
					<option value="3">支付宝支付</option>
					<option value="4">银行卡支付</option>
					<option value="5">让别人支付</option>
				</select>
			</td>
			<td style="padding: 10px;">消费店铺:</td>
			<td>
				
				 <select id="aa" class="easyui-combobox" name="paytype"
					panelHeight='auto' style="width: 143px; height: 30px">
					<option value="葫芦岛分店">葫芦岛分店</option>
					<option value="清风寨分店">清风寨分店</option>
					<option value="小马哥分店">小马哥分店</option>
				</select> 
			</td>
		</tr>
		<div>
				<!--会员详情-->
		<div style="background-color: #8D8D8D" id="memberVo">

			<div id="leftpanel"
				 style="border-radius:20px; border:1px solid #f26d7e; width:19%;height: 100px;margin: 35px 5px 20px 70px; float: left">
				<p style="font-size: medium;height: 1px">累计撤销:</p>
				<p style="color: red;font-size: x-large;text-align: center">
					<i id="bircount" style="font-size: 50px"></i>
				</p>
			</div>
					<div id="centerpanel"
                         style="border-radius:20px;border:1px solid #f26d7e; width:19%;height: 100px;margin: 35px 5px 20px 20px; float: left;">
                        <p style="font-size: medium;height: 1px">累计消费金额:</p>
                        <p style="color: red;font-size: x-large;text-align: center"><i id="usercount" style="font-size: 50px"></i></p>
                    </div>
                    <div id="rightpanel"
                         style="border-radius:20px;border:1px solid #f26d7e; width:19%;height: 100px;margin: 35px 5px 20px 20px; float: left">
                        <p style="font-size: medium;height: 1px">累计充值:</p>
                        <p style="color: red;font-size: x-large;text-align: center"><i id="recelivableCount" style="font-size: 50px"></i></p>
                    </div>
                    <div id="rightpanel"
                         style="border-radius:20px;border:1px solid #f26d7e; width:19%;height: 100px;margin: 35px 5px 20px 20px; float: left">
                        <p style="font-size: medium;height: 1px">会员:</p>
                        <p style="color: red;font-size: x-large;text-align: center"><i id="recelivableName" style="font-size: 50px"></i></p>
                    </div>
		</div>
		</table>
			



		</div>
	</table>
	<!-- 数据表格 -->
	<!-- <table id="stockOutcomeBillItem_datagrid"> -->
	<table id="memberPayment_datagrid">
		<thead>
			<tr>
				<%--		<th data-options="field:'member',width:15,align:'center'">会员列表</th>--%>
				<th data-options="field:'sn',width:15,align:'center'">会员卡号</th>
				<th
					data-options="field:'payment',width:15,align:'center',formatter:paytypeFormatter">支付类型</th>
				<th data-options="field:'payMoney',width:15,align:'center'">充值金额</th>
				<th data-options="field:'giveMoney',width:15,align:'center'">赠送金额</th>
				<th data-options="field:'totalMoney',width:15,align:'center'">变动后总金额</th>
				<th data-options="field:'paymentTime',width:15,align:'center'">充值时间</th>
				<th data-options="field:'remark',width:15,align:'center'">备注信息</th>
			</tr>
		</thead>
	</table>
	</table>

</body>
</html>