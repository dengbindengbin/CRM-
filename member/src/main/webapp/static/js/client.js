$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var clientDatagrid,clientDialog,clientForm;
	clientDatagrid = $("#client_datagrid");
	clientDialog = $("#client_dialog");
	clientForm = $("#client_form");
	/*
	 * 初始化数据表格 
	 */
	clientDatagrid.datagrid({
		url:"/client_list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#client_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	clientDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#client_dialog_bt'
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
				clientForm.form("clear");
				clientDialog.dialog("setTitle","新增");
				clientDialog.dialog("open");
			},
			edit:function(){
				var rowData = clientDatagrid.datagrid("getSelected");
				if(rowData){
					clientForm.form("clear");
					clientDialog.dialog("setTitle","编辑");
					clientDialog.dialog("open");
					if(rowData.member)
						rowData["member.id"] = rowData["member"].id;
					clientForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = clientDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/client_delete?clientId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										clientDatagrid.datagrid("reload");
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
				clientDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/client_update"
				}else{
					url = "/client_save";
				}
				clientForm.form("submit",{
					url:url,
					 onSubmit: function(param){ 
						 var ids = $("#meId").combobox("getValue");
						 param["member.id"]=ids;
					    },    
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								clientDialog.dialog("close");
								clientDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				clientDialog.dialog("close");
			}
	}
});
