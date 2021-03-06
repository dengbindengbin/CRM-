<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>积分充值管理</title>
<%@include file="/static/common/common.jsp" %>
	<link rel="stylesheet" href="/static/plugins/layui/css/layui.css"  media="all">
	<script type="text/javascript" src="/static/plugins/layui/layui.js"></script>
    <script type="text/javascript" src="/static/js/integralChange.js"></script>
	<script type="text/javascript">
        $(function () {
            $(".tips").mouseenter(function () {
                layer.tips($(this).data("content"),$(this),{
                    tips:[2,'#182699'],
                    maxWidth:200,
                    time:1200
                })
            })
        })
	</script>
</head>
<body>


<div id="cc" class="easyui-layout" data-options="fit:true">
	<!-- 西边布局 -->
	<div data-options="region:'west',title:'会员的详细信息',split:true" style="width: 700px;background-color: whitesmoke">
		<form class="layui-form" action="#" id="memberPaymentMsg">
			<input type="hidden" name="id" />
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						会员卡号 :<input name="sn" style="border: 0px;height: 30px" readonly>
					</li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						会员姓名  :<input name="name" style="border: 0px;height: 30px" readonly>
					</li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						会员等级  :<input name="level" style="border: 0px;height: 30px" readonly/>
                        <i class="layui-icon tips" style="font-size: 30px" data-content=" 1:代表是普通会员
                        2：代表是黄金会员
                        3：代表是白金会员
                        4：代表是钻石会员
                        5：代表是终身会员

      ">&#xe63a;</i>
                    </li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						会员生日  :<input name="birthday" style="border: 0px;height: 30px" readonly/>
					</li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						卡片余额 :<font style='color: #ff568f'>￥</font>
						<input name="totalMoney" style="border: 0px;height: 30px" readonly>
					</li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						当前积分  :<input name="integral" style="border: 0px;height: 30px" readonly>
						<i class="layui-icon tipintegral">&#xe611;</i>
					</li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						使用积分  :<input name="usedintegral" style="border: 0px;height: 30px" readonly>
					</li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						过期时间  :<input name="deadline" style="border: 0px;height: 30px" readonly>
					</li>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
						消费金额  :<input name="totalConsume" style="border: 0px;height: 30px" readonly>
					</li>
				</div>
			</div>
		</form>
	</div>



	<!-- 东边布局 -->
	<div data-options="region:'center',title:'会员积分的充值'" style="padding:5px;background:#eee;">
		<button class="layui-btn layui-btn-primary layui-btn-radius" style="float: left;margin-left: 200px" onclick="openMemberMsg()">
			<i class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#xe613;</i>
		</button>
		<i class="layui-icon tips" style="font-size: 30px; color: #1E9FFF;" data-content="亲，主人，点击左边的按钮，可以弹出会员信息表
        ，双击后，可以获取到会员的信息信息哦，快来试试吧">&#xe607;</i>
		<br/>
		<form method="post" id="integralChangeyment_form" class="layui-form">
			<table align="center">
		<div id="setting_dialog" method="post" class="layui-form">
			<div class="layui-form-item" pane="">
				<label class="layui-form-label">选择类型
				</label>
				<div>
					<input type="radio" name="type" value="0" title="增加">
					<input type="radio" name="type" value="1" title="扣除">
					<input type="radio" name="type" value="" title="不增不减" disabled>
				</div>
			</div>
		</div>
	   <div class="layui-form-item" style="width: 500px">
			<label class="layui-form-label">备注信息</label>
			   <div class="layui-input-block">
				  <select name="payment" lay-filter="aihao">
					  <option value="1">订单消费</option>
						<option value="2" selected="">扣除积分</option>
						<option value="3">清零积分</option>
					</select>
				</div>
		 </div>
		<div class="layui-form-item">
			<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<li>
					变动数额  :<input name="changecount" placeholder="请输入变动数额" style="border: 0px;height: 30px" >
				</li>
			</div>
		</div>
	    </table>
		</form>
		<br/>
		<br/>
		<button class="layui-btn layui-btn-big" style="background-color: darkorange;float: left;margin-left: 100px" onclick="RemoveIntegral()">积分清零</button>
		<button class="layui-btn layui-btn-warm" style="background-color: darkorange;float: left;margin-left: 100px" onclick="confirm ()">确认</button>
	</div>

	<!-- 南边布局 -->
	<div data-options="region:'south',title:'会员充值记录表',split:true" style="height:250px;background-color: whitesmoke">
		<!-- 数据表格 -->
		<table id="integralChange_datagrid">
			<thead>
			<tr>
				<th data-options="field:'member',width:10,align:'center',formatter:memberFormatter">会员名称</th>
				<th data-options="field:'changecount',width:10,align:'center'">变动数额</th>
				<th data-options="field:'sn',width:10,align:'center'">会员卡号</th>
				<th data-options="field:'time',width:10,align:'center'">变动时间</th>
				<th data-options="field:'level',width:10,align:'center',formatter:levelFormatter">会员等级</th>
				<th data-options="field:'remark',width:10,align:'center',formatter:remarkFormatter">备注</th>
				<th data-options="field:'type',width:10,align:'center',formatter:typeFormatter">变动类型</th>
			</tr>
			</thead>
		</table>
		<!-- 新增编辑对话框 -->
		<div id="integralChange_dialog">
			<form id="integralChange_form" method="post">
				<table align="center" style="margin-top: 15px;">
					<input type="hidden" name="id">
					<tr>
						<td>会员名称</td>
						<td><input type="text" name="member"></td>
					</tr>
					<tr>
						<td>变动数额</td>
						<td><input type="text" name="changecount"></td>
					</tr>
					<tr>
						<td>会员卡号</td>
						<td><input type="text" name="sn"></td>
					</tr>
					<tr>
						<td>变动时间</td>
						<td><input type="text" name="time"></td>
					</tr>
					<tr>
						<td>会员等级</td>
						<td><input type="text" name="level"></td>
					</tr>
					<tr>
						<td>备注</td>
						<td><input type="text" name="remark"></td>
					</tr>
					<tr>
						<td>变动类型</td>
						<td><input type="text" name="type"></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- 数据表格CRUD按钮 -->
		<div id="integralChange_datagrid_tb">
			<div>
				<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
				<button class="layui-btn layui-btn-small layui-btn-normal" onclick="TodaySearch(-1)">最近一天</button>
				<button class="layui-btn layui-btn-small" onclick="TodaySearchStree()">最近三天</button>
				<button class="layui-btn layui-btn-small layui-btn-normal" onclick="TodaySearchseven()">最近七天</button>
			</div>
		</div>
		<!-- 对话框保存取消按钮 -->
		<div id="integralChange_dialog_bt">
			<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
			<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
		</div>
	</div>
</div>

<!-- 定义一个dialog 里面包裹着datagrid，存储着会员的信息信息 -->
<div id="integralChangeMsg_dialog">
	<!--  里面包裹着datagrid，存储着会员的信息信息 -->
	<table id="integralChangeMsg_datagrid" >

	</table>
</div>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form()
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

    });
</script>
</body>
</html>