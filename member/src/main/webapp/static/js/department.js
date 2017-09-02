$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var departmentDatagrid,departmentDialog,departmentForm;
	departmentDatagrid = $("#department_datagrid");
	departmentDialog = $("#department_dialog");
	departmentForm = $("#department_form");
	/*
	 * 初始化数据表格 
	 */
	departmentDatagrid.datagrid({
		url:"/department_list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#department_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	departmentDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#department_dialog_bt'
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
				departmentForm.form("clear");
				departmentDialog.dialog("setTitle","新增");
				departmentDialog.dialog("open");
			},
			edit:function(){
				var rowData = departmentDatagrid.datagrid("getSelected");
				if(rowData){
					departmentForm.form("clear");
					departmentDialog.dialog("setTitle","编辑");
					departmentDialog.dialog("open");
					if(rowData.manager){
						rowData["manager.id"] = rowData.manager.id;
                    }
                    if(rowData.parent){
                        rowData["parent.id"] = rowData.parent.id;
                    }
					departmentForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = departmentDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/department_delete?departmentId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										departmentDatagrid.datagrid("reload");
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
				departmentDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/department_update"
				}else{
					url = "/department_save";
				}
				departmentForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								departmentDialog.dialog("close");
								departmentDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				departmentDialog.dialog("close");
			}
	}
});
function parentFormatter(value,row,index) {
	if (value){
		return value.name
	}
	return value;
}
function managerFormatter(value,row,index) {
    if (value){
        return value.username
    }
    return value;
    }
function stateFormatter(value,row,index) {
	if (value){
		return "正常"
	}
	return "非正常"
}