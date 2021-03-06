<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/static/css/demo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>每日销售明细管理</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/stockoutcombillresport.js"></script>
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
.table {
	border-collapse: collapse;
	border-spacing: 0;
	border-left: 1px solid #888;
	border-top: 1px solid #888;
	background: #efefef;
}

.td {
	border-right: 1px solid #888;
	border-bottom: 1px solid #888;
	padding: 5px 15px;
}

.tr {
	border-right: 1px solid #888;
	border-bottom: 1px solid #888;
	padding: 5px 15px;
	font-weight: bold;
	background: #ccc;
}

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
		</table>
		<hr size="5">
		<div style="margin:20px 0;"></div>
		<table>
		<tr>
			<td>
		<div id="cc" style="width:200px;height:650px;padding-right: 20px" class="easyui-layout" >
		<div data-options="region:'center',split:false,collapsible:false" style="width:150px;">
		<table class="table" id="table1" style="border: 1px">
				<tr class="tr">
					<td style="text-align: center !important;" colspan="3">葫芦岛分店</td>
				</tr>
				<tr class="tr">
					<td style="text-align: right !important;" colspan="3">收银对账单</td>
				</tr>
				<tr class="tr">
					<td style="text-align: right !important;" colspan="3">填充时间</td>
				</tr class="tr">
				<tr class="tr">
					<td style="text-align: right !important;">散客消费</td>
					<td id="c6" style="text-align: center !important;" colspan="2">2 人</td>
				</tr>
				<tr class="tr">
					<td style="text-align: right !important;">会员消费</td>
					<td id="m6" style="text-align: center !important;" colspan="2">1 人</td>
				</tr>
				<tr class="tr">
					<td style="vertical-align: middle; text-align: right !important;"
						rowspan="1">
					<td style="text-align: center !important;" colspan="2">1 个(银卡)</td>
				</tr class="tr">
				<tr class="tr">
					<td style="vertical-align: middle; text-align: right !important;"
						rowspan="4">会员充值金额</td>
					<td id="a1" style="text-align: center !important;">￥100</td>
					<td  style="text-align: center !important;">现金</td>
				</tr class="tr">
				<tr class="tr">
					<td id="a2" style="text-align: center !important;">￥0</td>
					<td  style="text-align: center !important;">微信</td>
				</tr>
				<tr>
					<td id="a3" style="text-align: center !important;">￥0</td>
					<td  style="text-align: center !important;">支付宝</td>
				</tr>
				<tr>
					<td id="a4" style="text-align: center !important;">￥0</td>
					<td  style="text-align: center !important;">银行卡</td>
				</tr>
				<!-- <tr>
					<td style="vertical-align: middle; text-align: right !important;"
						rowspan="4">充次储值金额</td>
					<td style="text-align: center !important;">￥0</td>
					<td style="text-align: center !important;">现金</td>
				</tr>
				<tr>
					<td style="text-align: center !important;">￥0</td>
					<td style="text-align: center !important;">微信</td>
				</tr>
				<tr>
					<td style="text-align: center !important;">￥0</td>
					<td style="text-align: center !important;">银行卡</td>
				</tr>
				<tr>
					<td style="text-align: center !important;">￥0</td>
					<td style="text-align: center !important;">支付宝</td>
				</tr> -->
				<tr>
					<td id="a5" style="text-align: center !important;" colspan="3">会员总收入
						：￥100</td>
				</tr>
		</table>
	</div>
	</div>
	</td>
	<td>
	<div id="cc2" style="width:300px;height:650px; padding-left: 30px" class="easyui-layout" >
		<div data-options="region:'center'" style="padding:10px">
			<table class="table" id="table1" style="border: 1px">
				<tbody>
					<tr>
						<td style="text-align: left !important;" colspan="3">
							<span>消费数据统计</span>
						</td>
					</tr>
					<tr>
						<td style="vertical-align: middle; text-align: right !important;"
							rowspan="7">散客消费</td>
						<td id="c1" style="text-align: center !important;">￥30.00</td>
						<td style="text-align: center !important;">现金</td>
					</tr>
					<tr>
						<td id="c2" style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">微信</td>
					</tr>
					<tr>
						<td id="c3" style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">银行卡</td>
					</tr>
					<tr>
						<td id="c4" style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">支付宝</td>
					</tr>
					<tr>
						<td  style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">美团</td>
					</tr>
					<tr>
						<td style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">口碑</td>
					</tr>
					<tr>
						<td style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">闪惠</td>
					</tr>
					<tr>
						<td  style="text-align: right !important;">散客消费总额</td>
						<td id="c5" style="text-align: center !important;" colspan="2">￥30.00</td>
					</tr>
					<tr>
						<td style="vertical-align: middle; text-align: right !important;"
							rowspan="9">会员消费</td>
						<td id="m1" style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">现金</td>
					</tr>
					<tr>
						<td id="m2" style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">微信</td>
					</tr>
					<tr>
						<td id="m3" style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">银行卡</td>
					</tr>
					<tr>
						<td id="m4" style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">支付宝</td>
					</tr>
					<tr>
						<td style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">美团</td>
					</tr>
					<tr>
						<td style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">口碑</td>
					</tr>
					<tr>
						<td style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">闪惠</td>
					</tr>
					<tr>
						<td style="text-align: center !important;">￥0.00</td>
						<td style="text-align: center !important;">赊账</td>
					</tr>
					<tr>
						<td  style="text-align: right !important;">会员消费总额</td>
						<td id="m5" style="text-align: center !important;" colspan="2">￥16.00</td>
					</tr>
					<tr>
						<td id="m7" style="text-align: center !important;" colspan="3">时间
							：2017/8/31 12:03:54</td>
					</tr>
				</tbody>
			</table>
	</div>  
</div>  </td>
		</tr>
		</table>
	<script type="text/javascript">
		$("#table1 tr").addClass("tr");
		$("#table1 td").addClass("td");
	</script>
</body>
</html>