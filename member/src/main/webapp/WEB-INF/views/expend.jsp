<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/expend.js"></script>
<script type="text/javascript" src="/static/js/getdate.js"></script>
</head>
<body>
	<table id="expend_datagrid"></table>
	<div id="expend_dialog">
		<form id="expend_form" method="post">
			<input type="hidden" name="id" />
			<table align="center" style="margin-top: 15px">
				<tbody>
					<tr>
						<td>费用类别:</td>
						<td>
							<input id="parentName" type="text" name="parentId"
								class="easyui-combobox"
								data-options="    
							        valueField: 'id',                                                                                                   
							        textField: 'name',    
							        url: '/classify_select',
							        panelHeight:'auto',
							        required:true,
               					   editable:false,
               					   onChange:function(){
							var parentId=$('#parentName').combobox('getValue');
							$('#child').combobox({
							url:'/smallclassify_selectByClassify?parentId='+parentId,
							valueField:'id',
							textField:'name',
							panelHeight:'auto',
							required:true,
               				editable:false,
						});
						}
               					   " />
						</td>
					</tr>
					<tr>
						<td>货品名称:</td>
						<td>
						<input id="child" class="easyui-combobox" name="smallClassify.id" panelHeight='auto' style="width:143px;" required >   
							</input> 
						</td>
					</tr>
					<tr>
						<td>支出金额:</td>
						<td>
							<input type="text" name="debit" class="easyui-numberbox"
								value="100" data-options="min:0,precision:2"   required/>
						</td>
					</tr>
					<tr>
						<td>支付时间:</td>
						<td>
							<input type="text" name="spendingtime" class="easyui-datebox" required/>
						</td>
					</tr>
					<tr>
						<td>支出人员:</td>
						<td>
							<input type="text" name="spendingonstaff" class="easyui-validatebox" required="true"/>
						</td>
					</tr>
					<tr>
						<td>备注:</td>
						<td>
						<textarea rows="50" cols="3" name="remark" class="easyui-validatebox" required="true" style="width:141px;height:50px"></textarea>
							<!-- <input type="text" name="remark" class="easyui-validatebox" required="true" style="width:141px;height:50px"/> -->
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

	<div id="expend_tb">
		<!-- 使用shiro标签控制按钮显示 -->
		<shiro:hasPermission name="expend:save">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true" data-cmd="add">支出录入</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="expend:update">
			<a href="#" class="easyui-linkbutton" id="expend_tb_edit"
				data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">修改</a>
		</shiro:hasPermission>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" id="expend_tb_cs"
			data-cmd="changeState">删除</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
		<!-- 关键字查询 -->
		<input type="text" name="begin" id="begin" class="easyui-datebox" />
		<input type="text" name="end" id="end" class="easyui-datebox" />
		<select id="cc" name="time" class="easyui-combobox" panelHeight="auto">
		<option value="-1"></option>
		<option value="1">本月</option>
		<option value="2">本周</option>
		<option value="3">上月</option>
		<option value="4">本季</option>
		<option value="5">上季</option>
		<option value="6">今年</option>
		<option value="7">去年</option>
		</select>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" data-cmd="searchForm">查询</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cut',plain:true" data-cmd="exportFile">导出</a>
		总金额:<a id="sum">0</a>元
	</div>

	<div id="expend_btns">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
	</div>

</body>
</html>