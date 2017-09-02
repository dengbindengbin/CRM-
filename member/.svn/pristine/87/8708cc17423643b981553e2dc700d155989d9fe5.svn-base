<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货管理</title>
<%@include file="/static/common/common.jsp"%>

<!-- <script type="text/javascript" src="/static/js/purchaseControl.js"></script> -->
<script type="text/javascript">
	/* $("#iframeId").load(function () {
	 var mainheight = $(this).contents().find("body").height() + 30;
	 $(this).height(mainheight);
	 }); */
</script>

</head>
<body>
	<div id="cc" class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'center'"
			style="padding: 5px; background: #eee;">
			<div id="index_tabs" class="easyui-tabs"
				data-options="fit:true,border:false">
				<div title="商品采购">
					<iframe id="iframeId" src="/purchaseOrder.do" width="1119px"
						height="510px" scrolling="no" frameborder="0"></iframe>
				</div>
				<div title="供应商管理">
					<iframe id="iframeId" src="/supplier.do" width="1119px"
						height="510px" scrolling="no" frameborder="0"></iframe>

					<!-- 		
					<table id="supplier_datagrid">
						<thead>
							<tr>
								<th data-options="field:'factory',width:100,align:'center'">厂商</th>
								<th data-options="field:'debt',width:100,align:'center'">应付欠款</th>
								<th data-options="field:'name',width:100,align:'center'">联系人</th>
								<th data-options="field:'phone',width:100,align:'center'">联系电话</th>
								<th data-options="field:'qq',width:100,align:'center'">QQ号码</th>
								<th data-options="field:'address',width:100,align:'center'">地址</th>
								<th data-options="field:'addDate',width:100,align:'center'">添加时间</th>
								<th data-options="field:'remark',width:100,align:'center'">备注信息</th>
							</tr>
						</thead>
					</table>
					新增编辑对话框
					<div id="supplier_dialog">
						<form id="supplier_form" method="post">
							<table align="center" style="margin-top: 15px;">
								<input type="hidden" name="id">
								<tr>
									<td>厂商</td>
									<td>
										<input type="text" name="factory">
									</td>
								</tr>
								<tr>
									<td>应付欠款</td>
									<td>
										<input type="text" name="debt">
									</td>
								</tr>
								<tr>
									<td>联系人</td>
									<td>
										<input type="text" name="name">
									</td>
								</tr>
								<tr>
									<td>联系电话</td>
									<td>
										<input type="text" name="phone">
									</td>
								</tr>
								<tr>
									<td>QQ号码</td>
									<td>
										<input type="text" name="qq">
									</td>
								</tr>
								<tr>
									<td>地址</td>
									<td>
										<input type="text" name="address">
									</td>
								</tr>
								<tr>
									<td>操作人员</td>
									<td>
										<select id="cc" class="easyui-combobox" name="admin"
											panelHeight='auto' style="width: 175px;">
											<option>管理员</option>
											<option>BOSS</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>添加时间</td>
									<td>
										<input type="text" name="addDate" class="easyui-datebox">
									</td>
								</tr>
								<tr>
									<td>备注信息</td>
									<td>
										<input type="text" name="remark">
									</td>
								</tr>
							</table>
						</form>
					</div>
					数据表格CRUD按钮
					<div id="supplier_datagrid_tb">
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
					对话框保存取消按钮
					<div id="supplier_dialog_bt">
						<a class="easyui-linkbutton" iconCls="icon-save" plain="true"
							data-cmd="save">保存</a>
						<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
							data-cmd="cancel">取消</a>
					</div>
 -->
				</div>
				<div title="仓库管理">
					<iframe id="iframeId" src="/warehouse.do" width="1119px"
						height="510px" scrolling="no" frameborder="0"></iframe>
					<!-- 	<table id="warehouse_datagrid"></table>
					新增编辑对话框
					<div id="warehouse_dialog">
						<form id="warehouse_form" method="post">
							<table align="center" style="margin-top: 15px;">
								<input type="hidden" name="id">
								<tr>
									<td>仓库编码</td>
									<td>
										<input type="text" name="sn">
									</td>
								</tr>
								<tr>
									<td>仓库名称</td>
									<td>
										<input type="text" name="wname">
									</td>
								</tr>
								<tr>
									<td>联系人</td>
									<td>
										<input type="text" name="name">
									</td>
								</tr>
								<tr>
									<td>联系电话</td>
									<td>
										<input type="text" name="phone">
									</td>
								</tr>
								<tr>
									<td>仓库地址</td>
									<td>
										<input type="text" name="address">
									</td>
								</tr>
								<tr>
									<td>仓库状态</td>
									<td>
										<select id="cc" class="easyui-combobox" name="state"
											panelHeight='auto' style="width: 175px;">
											<option value="true">启用</option>
											<option value="false">关闭</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>仓库创建时间</td>
									<td>
										<input type="text" name="addDate" class="easyui-datebox">
									</td>
								</tr>
								<tr>
									<td>备注信息</td>
									<td>
										<input type="text" name="remark">
									</td>
								</tr>
							</table>
						</form>
					</div>
					数据表格CRUD按钮
					<div id="warehouse_datagrid_tb">
						<div>
							<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
								data-cmd="add">新增仓库</a>
							<a id="warehouse_tb_edit" class="easyui-linkbutton"
								iconCls="icon-edit" plain="true" data-cmd="edit">修改仓库</a>

							<a class="easyui-linkbutton"
								data-options="iconCls:'icon-lock',plain:true"
								data-cmd="changeState">启用/关闭仓库</a>

							<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
								data-cmd="del">移除仓库</a>
							<a class="easyui-linkbutton" iconCls="icon-reload" plain="true"
								data-cmd="reload">刷新</a>
						</div>
					</div>
					对话框保存取消按钮
					<div id="warehouse_dialog_bt">
						<a class="easyui-linkbutton" iconCls="icon-save" plain="true"
							data-cmd="save">保存</a>
						<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
							data-cmd="cancel">取消</a>

					</div>
					<div id="warehouse_dialog_data" data-options="width:550,height:400">
						<div id="warehouse_datagrid_data" class="div-height"></div>
						<div id="warehouse_datagrid_tbs">
							<input type="text" name="keyword" />
							<a href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-search',plain:true"
								data-cmd="searchForm">查询</a>
						</div>
					</div>
					 -->
				</div>
			</div>
		</div>
	</div>


</body>
</html>