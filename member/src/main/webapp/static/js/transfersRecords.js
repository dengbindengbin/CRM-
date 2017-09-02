$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var transfersRecordsDatagrid,transfersRecordsDialog,transfersRecordsForm;
	transfersRecordsDatagrid = $("#transfersRecords_datagrid");
	transfersRecordsDialog = $("#transfersRecords_dialog");
	transfersRecordsForm = $("#transfersRecords_form");
	/*
	 * 初始化数据表格 
	 */
	transfersRecordsDatagrid.datagrid({
		url:"/transfersRecords_list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#transfersRecords_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	transfersRecordsDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#transfersRecords_dialog_bt'
	});
	/*
	 * 对页面按钮进行统一监听
	 */
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
	/*
	 * 所有的操作封装到cmdObj对象中,方便管理
	 */
	var cmdObj = {
			 add:function(){
				transfersRecordsForm.form("clear");
				transfersRecordsDialog.dialog("setTitle","新增");
				transfersRecordsDialog.dialog("open");
			},
			edit:function(){
				var rowData = transfersRecordsDatagrid.datagrid("getSelected");
				if(rowData){
					transfersRecordsForm.form("clear");
					transfersRecordsDialog.dialog("setTitle","编辑");
					transfersRecordsDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					transfersRecordsForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = transfersRecordsDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/transfersRecords_delete?transfersRecordsId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										transfersRecordsDatagrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.msg,"error");
								}
							},"json")
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要删除的数据!","warining");
				}
			},
			reload:function(){
				transfersRecordsDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/transfersRecords_update"
				}else{
					url = "/transfersRecords_save";
				}
				transfersRecordsForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								transfersRecordsDialog.dialog("close");
								transfersRecordsDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				transfersRecordsDialog.dialog("close");
			}
	}
});
