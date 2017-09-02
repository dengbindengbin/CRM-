$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var memberLevelDatagrid,memberLevelDialog,memberLevelForm;
	memberLevelDatagrid = $("#memberLevel_datagrid");
	memberLevelDialog = $("#memberLevel_dialog");
	memberLevelForm = $("#memberLevel_form");
	/*
	 * 初始化数据表格 
	 */
	memberLevelDatagrid.datagrid({
		url:"/memberLevel_list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#memberLevel_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	memberLevelDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#memberLevel_dialog_bt'
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
				memberLevelForm.form("clear");
				memberLevelDialog.dialog("setTitle","新增");
				memberLevelDialog.dialog("open");
			},
			edit:function(){
				var rowData = memberLevelDatagrid.datagrid("getSelected");
				if(rowData){
					memberLevelForm.form("clear");
					memberLevelDialog.dialog("setTitle","编辑");
					memberLevelDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					memberLevelForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = memberLevelDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/memberLevel_delete?memberLevelId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										memberLevelDatagrid.datagrid("reload");
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
				memberLevelDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/memberLevel_update"
				}else{
					url = "/memberLevel_save";
				}
				memberLevelForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								memberLevelDialog.dialog("close");
								memberLevelDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				memberLevelDialog.dialog("close");
			}
	}
});
