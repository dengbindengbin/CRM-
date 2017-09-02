$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */

	var stocktakingDatagrid,stocktakingDialog,stocktakingForm;
	stocktakingDatagrid = $("#stocktaking_datagrid");
	stocktakingDialog = $("#stocktaking_dialog");
	stocktakingForm = $("#stocktaking_form");
	/*
	 * 初始化数据表格 
	 */
	stocktakingDatagrid.datagrid({
		url:"/stocktaking_list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#stocktaking_datagrid_tb',
		columns:[[
			{field:'name',width:100,align:'center',title:'商品名称'},
			{field:'kind',width:100,align:'center',title:'商品类型'},
			{field:'number',width:100,align:'center',title:'库存数量'},
			{field:'units',width:100,align:'center',title:'商品单位'},
			{field:'entryTime',width:100,align:'center',title:'入库时间'},
			{field:'checkTime',width:100,align:'center',title:'盘点时间'},
			{field:'operator',width:100,align:'center',title:'操作人员'},
			{field:'operation',width:100,align:'center',formatter:operationFormatter},
			{field:'operation1',width:100,align:'center',title:'操作',formatter:operation1Formatter},
			{field:'operation2',width:100,align:'center',formatter:operation2Formatter}
		]]
	});

	$("#stocktaking_dialog").dialog({
		title: '修改库存',    
	    width: 300,    
	    height: 250,    
	    closed: true,   
	    nowrap : true,
		buttons:'#stocktaking_dialog_btt'
	});
	
	function operationFormatter(value,row,index){
		return "<a href=javascript:number();>数量确认</a>";
		//return "<a href=/stocktaking_save>数量确认</a>";
	}
	function operation1Formatter(value,row,index){
		
		return "<a href=javascript:changeNumber();>数量调整</a>";
		//return "<a href=/product?parent_id="+row.id + ">数量调整</a>";
	}
	function operation2Formatter(value,row,index){
		return "<a href=javascript:record("+row.id+");>盘点记录</a>";
		//return "<a href=/stocktaking?id="+row.id + ">盘点记录</a>";
	}
	

	
	
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
			
			reload:function(){
				stocktakingDatagrid.datagrid("reload");
			},
			//导出文件
			exportFile:function(){
				window.location.href="/stocktaking_export";
			},
			
			save:function(){ 
				stocktakingForm.form("submit",{
					url:"/stocktaking_update",
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								stocktakingDialog.dialog("close");
								stocktakingDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			
			cancel:function (){
				stocktakingDialog.dialog("close");
			},
			
			searchForm:function (){
				// 获取关键字文本框的值
				var keyword = $("[name='keyword']").val();
	
					stocktakingDatagrid.datagrid('load', {
						keyword : keyword
					});
				}
			}
});


function number(){
	var stocktakingDatagrid,stocktakingDialog,stocktakingForm;
	stocktakingDatagrid = $("#stocktaking_datagrid");
	stocktakingDialog = $("#stocktaking_dialog");
	stocktakingForm = $("#stocktaking_form");
	var rowData = stocktakingDatagrid.datagrid("getSelected");
	console.log(rowData["id"]);
	
	stocktakingForm.form("submit",{
		url:"/stocktaking_updates?id="+rowData["id"],
		success:function(data){
			data = $.parseJSON(data);
			if(data.success){
				$.messager.alert("温馨提示",data.msg,"info",function(){
					stocktakingDialog.dialog("close");
					stocktakingDatagrid.datagrid("reload");
				});
			}else{
				$.messager.alert("温馨提示",data.msg,"error");
			}
		}
	});
}

function changeNumber(){
	// 回显数据
	var stocktakingDatagrid,stocktakingDialog,stocktakingForm;
	stocktakingDatagrid = $("#stocktaking_datagrid");
	stocktakingDialog = $("#stocktaking_dialog");
	stocktakingForm = $("#stocktaking_form");
	var rowData = stocktakingDatagrid.datagrid("getSelected");
	if(rowData){
		stocktakingForm.form("clear");
		stocktakingDialog.dialog("setTitle","编辑");
		stocktakingDialog.dialog("open");
		stocktakingForm.form("load",rowData);
	}
}

function record(value){
	$("#inventoryRecords_dialog_data").dialog({
		title: '库存',
		width:620,
		height:420,
		cache:false,
		closed:false,
		modal:true
	});
	$("#inventoryRecords_datagrid_data").datagrid({
		url:'/inventoryRecords_list?stocktakingId='+value,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		fitColumns:true,
		cache:false,
	    columns:[[    
	        {field:'number',title:'原有库存',width:100},
	        {field:'changeNumber',title:'修改库存',width:100},
	        {field:'operator',title:'操作员',width:100},
	        {field:'entryTime',title:'盘点时间',width:100}
	        ]]
	}); 
	
}

