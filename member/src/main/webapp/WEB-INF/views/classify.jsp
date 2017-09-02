<%@ page language="java" contentType="text/html;charset=UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/classify.js"></script>
<script type="text/javascript" src="/static/js/smallClassifys.js"></script>
</head>
<body>
<body class="easyui-layout">   
    <div data-options="region:'west',title:'大分类'" style="width:600px;">
   	<table id="classify_datagrid"></table>
   	
   	<div id="classify_dialog">
		<form id="classify_form" method="post">
			<input type="hidden" name="id" />
			<table align="center" style="margin-top: 15px">
				<tbody>
					<tr>
						<td>分类名:</td>
						<td>
							<input type="text" name="name" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
   	
   <div id="classify_tb">
		<!-- 使用shiro标签控制按钮显示 -->
		<shiro:hasPermission name="classify:save">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true" data-cmd="add">新增</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="classify:update">
			<a href="#" class="easyui-linkbutton" id="classify_tb_edit"
				data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">修改</a>
		</shiro:hasPermission>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" id="classify_tb_cs"
			data-cmd="changeState">删除</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">刷新</a>
		<!-- 关键字查询 -->
		<input type="text" name="keyword" />
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" data-cmd="searchForm">查询</a>
	</div>

	

	<div id="classify_btns">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" data-cmd="save">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" data-cmd="cancel">取消</a>
	</div>
    </div>   
    
    
    
    <!-- 小分类 -->
    <div data-options="region:'center',title:'小分类'" style="width: 500px">
    	<table id="smallClassify_datagrid"></table>

<div id="smallClassify_dialog">
		<form id="smallClassify_form" method="post">
			<input type="hidden" name="id" id="smallid"/>
			<table align="center" style="margin-top: 15px">
				<tbody>
				<tr>
						<td>大分类:</td>
						<td>
							<input id="parentName" type="text" name="parentId"
								class="easyui-combobox"
								data-options="    
							        valueField: 'id',                                                                                                   
							        textField: 'name',    
							        url: '/classify_select',
							        panelHeight:'auto',
							        required:true,
               					   editable:false
               					   " />
						</td>
					</tr>
					<tr>
						<td>分类:</td>
						<td>
							<input type="text" name="name" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

    	<div id="smallClassify_tb">
		<!-- 使用shiro标签控制按钮显示 -->
		<shiro:hasPermission name="classify:save">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true" data-sm="add">新增</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="classify:update">
			<a href="#" class="easyui-linkbutton" id="classify_tb_edit"
				data-options="iconCls:'icon-edit',plain:true" data-sm="edit">修改</a>
		</shiro:hasPermission>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" id="classify_tb_cs"
			data-sm="changeState">删除</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" data-sm="reload">刷新</a>
		<!-- 关键字查询 -->
		<input type="text" name="keywords" />
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" data-sm="searchForm">查询</a>
			
	<div id="smallClassify_btns">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" data-sm="save">保存</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" data-sm="cancel">取消</a>
	</div>
    </div> 
	
	</div>
    	</div>
   	
</body>
</html>