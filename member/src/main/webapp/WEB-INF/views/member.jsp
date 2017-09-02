<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理管理</title>
<%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/member.js"></script>
    <script type="text/javascript" src="/static/plugins/layer/layer.js"></script>
	<link rel="stylesheet" type="text/css" href="/static/css/demo.css">
 <%--   <link rel="stylesheet" href="/static/plugins/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css"/>
    <script type="text/javascript" src="/static/plugins/bootstrap-3.3.2-dist/js/bootstrap.js"></script>--%>
    <script type="text/javascript">
        $(function () {
            $(".tips").mouseenter(function () {
                layer.tips($(this).data("content"),$(this),{
                    tips:[2,'#259926'],
                    maxWidth:200,
                    time:1200
                })
            })
        })
    </script>
</head>
<body>
<!--会员详情-->
</div>

<div id="cc" class="easyui-layout" fit=true>

	<div data-options="region:'west',title:'会员等级',split:true" style="width:150px;background-color:bisque">
		<ul id="member_tree" class="easyui-tree">

		</ul>
	</div>

	<div data-options="region:'center',title:'会员列表'" style="padding:5px;"
		 style="width:100px;">



		<!--会员详情-->
		<div style="background-color: #8D8D8D" id="memberVo">

			<div id="leftpanel"
				 style="border-radius:20px; border:1px solid #f26d7e; width:26%;height: 100px;margin: 35px 5px 20px 70px; float: left">
				<p style="font-size: medium;height: 1px">今天过生日的会员:</p>
				<p style="color: red;font-size: x-large;text-align: center">
					<i id="bircount" style="font-size: 50px"></i>
				</p>
			</div>
					<div id="centerpanel"
                         style="border-radius:20px;border:1px solid #f26d7e; width:26%;height: 100px;margin: 35px 5px 20px 20px; float: left;">
                        <p style="font-size: medium;height: 1px">会员总数:</p>
                        <p style="color: red;font-size: x-large;text-align: center"><i id="usercount" style="font-size: 50px"></i></p>
                    </div>
                    <div id="rightpanel"
                         style="border-radius:20px;border:1px solid #f26d7e; width:26%;height: 100px;margin: 35px 5px 20px 20px; float: left">
                        <p style="font-size: medium;height: 1px">累计消费金额:</p>
                        <p style="color: red;font-size: x-large;text-align: center"><i id="recelivableCount" style="font-size: 50px"></i></p>
                    </div>
		</div>
		<!-- 数据表格 -->
	<table id="member_datagrid">
		<thead>
			<tr>
				<th data-options="field:'name',width:10,align:'center'">会员姓名</th>
			<%--	<th data-options="field:'password',width:10,align:'center'">会员密码</th>--%>
				<th data-options="field:'sn',width:10,align:'center'">会员卡号</th>
				<th data-options="field:'phone',width:10,align:'center'">电话号码
					<a class="easyui-linkbutton tips" iconCls="icon-question" plain="true" data-content="亲，主人，双击电话下面的单元格，输入电话号码，可以快速修改数据哦，开来试试哦m"></a>
				</th>
				<th data-options="field:'gender',width:10,align:'center',formatter:genderFormatter">性别</th>
				<th data-options="field:'totalConsume',width:10,align:'center'">卡上余额</th>
				<th data-options="field:'birthday',width:10,align:'center'">生日</th>
				<th data-options="field:'integral',width:10,align:'center'">会员积分</th>
				<th data-options="field:'level',width:10,align:'center',formatter:levelFormatter">会员等级</th>
				<th data-options="field:'payment',width:10,align:'center',formatter:paytypeFormatter">会员支付方式</th>
				<th data-options="field:'referrer',width:10,align:'center',formatter:referrerFormatter">推荐人</th>
				<th data-options="field:'address',width:10,align:'center'">会员家庭地址</th>
				<th data-options="field:'state',width:10,align:'center',formatter:stateFormatter">状态</th>
				<th data-options="field:'usedintegral',width:10,align:'center'">已使用积分</th>
				<th data-options="field:'remark',width:10,align:'center'">会员备注</th>
				<th data-options="field:'deadline',width:10,align:'center'">过期时间</th>
				<th data-options="field:'qq',width:10,align:'center'">QQ</th>
				<th data-options="field:'totalMoney',width:10,align:'center'">开卡总金额</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="member_dialog">
		<form id="member_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr style="margin-top: 15px">
				<td>会员卡号</td>
				<td><input type="text" name="sn" readonly="readonly" style="background-color: #8D8D8D;color: whitesmoke" placeholder="随机生成会员卡号"  >
                    <a class="easyui-linkbutton tips" iconCls="icon-question" plain="true" data-content="亲，主人，随机生成会员卡号，不需要手写哦
         防止会员卡号重复哦"></a>
                </td>
                <td>会员姓名</td>
                <td><input type="text" name="name" class="easyui-validatebox"
                           data-options="required:true"></td>
			</tr>
            <br/>
			<tr style="margin-top: 15px">
				<td>电话号码</td>
				<td><input type="text" name="phone">
				</td>
                <td>会员密码</td>
                <td><input type="text" name="password"></td>
			</tr>
			<tr>
                <td>性别</td>
                <td><input type=radio value="0" name="gender">男
                    <input type=radio value="1" name="gender">女
                </td>
                <td>生日</td>
                <td><input type="text" name="birthday" type="text" class="easyui-datebox">
                    <a class="easyui-linkbutton tips" iconCls="icon-question" plain="true" data-content="亲，记得写上生日，我们会在你生日当天送给你一份精美礼品哦
          "></a>
                </td>
			</tr>
			<tr>
				<td>QQ</td>
				<td><input type="text" name="qq"></td>
                <td>会员家庭地址</td>
                <td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>会员支付方式</td>
				<td>
                    <select  class="easyui-combobox" name="payment" data-options="panelHeight:'auto'" style="width:150px;">
                        <option value="1">现金</option>
                        <option value="2">微信</option>
                        <option value="3">支付宝</option>
                        <option value="4">银行卡</option>
                    </select>
                </td>
                <td>会员等级</td>
                <td>
                    <input type="text" name="level.id" class="easyui-combobox"
                           data-options="
							        valueField: 'id',
							        textField: 'name',
							        url: '/memberLevelBymember',panelHeight:'auto'"/>
                </td>
			</tr>
			<tr>
				<td>开卡总金额</td>
				<td><input type="text" name="totalMoney"></td>
                <td>消费金额</td>
                <td><input type="text" name="totalConsume"></td>
			</tr>
            <tr>
                <td>会员积分</td>
                <td><input type="text" name="integral"></td>
                <td>已使用积分</td>
                <td><input type="text" name="usedintegral"></td>
            </tr>
			<tr>
				<td>会员备注</td>
				<td><input type="text" name="remark"></td>
                <td>过期时间</td>
                <td><input type="text" name="deadline" name="birthday" type="text" class="easyui-datebox"></td>
			</tr>
			<tr>
				<td>推荐人</td>
				<td>
                   <%-- <input type="text" name="referrer">--%>
                       <input type="text" name="referrer.id" class="easyui-combobox"
                              data-options="
						      valueField: 'id',
							  textField: 'name',
							  url: '/meberId',panelHeight:'auto'"/>

					   <a class="easyui-linkbutton tips" iconCls="icon-question" plain="true" data-content="推荐人：是推荐你来这办会员卡，多多推荐，
      推荐人与被推荐人都有礼品相送哦"></a>

                </td>
				<td>状态:</td>
				<td><select  class="easyui-combobox" name="state"
							 panelHeight='auto' style="width: 143px;">
					<option value="1">正常</option>
					<option value="0">挂失</option>
				</select></td>
			</tr>
		</table>
		</form>
	</div>
		<!-- 隐藏的按钮的 -->
		<div id="setTing_dialog">
            <div>
				<input type="checkbox" name="totalMoney">:开卡总金额<br/>
				<input type="checkbox" name="qq">：qq<br/>
				<input type="checkbox" name="deadline">:过期时间<br/>
				<input type="checkbox" name="remark">:会员备注
			</div>
		</div>

	<!-- 数据表格CRUD按钮 -->
	<div id="member_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
			<a id="emp_tb_edit" class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">編輯</a>
			<a  id="emp_tb_cs" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="reload">刷新</a>
			<a class="easyui-linkbutton" iconCls="icon-list" plain="true" data-cmd="setTing">列表显示</a>
			<a class="easyui-linkbutton tips" iconCls="icon-question" plain="true" data-content="列表显示：主人，为了让你有更好的体验，以及视觉效果，
			通过这个按钮，你可以看到自己想要看到的数据"></a>
			<a href="#" class="easyui-linkbutton"
			   data-options="iconCls:'icon-import',plain:true" data-cmd="exportFile" >导出</a><br/>

			<div style="margin:10px 0;"></div>

			<input id="sss1" class="easyui-searchbox" data-options="prompt:'请输入会员姓名或者会员地址',menu:'#mm',searcher:doSearch" style="width:300px"></input>
			<div id="mm" style="width:120px">
				<div data-options="name:'name',iconCls:'icon-ok'">会员姓名</div>
				<div data-options="name:'address'">会员地址</div>
			</div>
				<a class="easyui-linkbutton" iconCls="icon-state" plain="true" data-cmd="state"><span id="stateId">挂失</span></a>

			<script>
                function doSearch(value,name){
                  $("#member_datagrid").datagrid('load',{
                      value:value,
					  name:name
				  })
                }
			</script>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="member_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
		<!-- 列表显示保存取消按钮 -->
		<div id="setTing_dialog_bt">
			<a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="saveItem()">保存</a>
			<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancelItem">取消</a>
		</div>
	</div>
</div>
</body>
</html>