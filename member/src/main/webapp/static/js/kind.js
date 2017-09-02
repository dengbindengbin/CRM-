$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var kindDatagrid,kindDialog,kindForm;
	kindDatagrid = $("#kind_datagrid");
	kindDialog = $("#kind_dialog");
	kindForm = $("#kind_form");
	/*
	 * 初始化数据表格 
	 */
	kindDatagrid.datagrid({
		url:"/kind_list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#kind_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	kindDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#kind_dialog_bt'
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
				kindForm.form("clear");
				kindDialog.dialog("setTitle","新增");
				kindDialog.dialog("open");
			},
			edit:function(){
				var rowData = kindDatagrid.datagrid("getSelected");
				if(rowData){
					kindForm.form("clear");
					kindDialog.dialog("setTitle","编辑");
					kindDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					kindForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = kindDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/kind_delete?kindId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										kindDatagrid.datagrid("reload");
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
				kindDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/kind_update"
				}else{
					url = "/kind_save";
				}
				kindForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								kindDialog.dialog("close");
								kindDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				kindDialog.dialog("close");
			}
	}
});
