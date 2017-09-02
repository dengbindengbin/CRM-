$(function(){
	var options=$("#cc").combobox("options");
	console.debug(options);
	options.onSelect=function (recode){
		console.debug(recode);
		$("#stockOutcomeBillItem_datagrid").datagrid('reload',{
			'paytype':recode.value
		});
	}
	/*
	 * 抽取所有需要用得元素.
	 */
	var stockOutcomeBillItemDatagrid,stockOutcomeBillItemDialog,stockOutcomeBillItemForm;
	stockOutcomeBillItemDatagrid = $("#stockOutcomeBillItem_datagrid");
	stockOutcomeBillItemDialog = $("#stockOutcomeBillItem_dialog");
	stockOutcomeBillItemForm = $("#stockOutcomeBillItem_form");
	/*
	 * 初始化数据表格 
	 */
	stockOutcomeBillItemDatagrid.datagrid({
		url:"/stockOutcomeBillItem_list",
		remoteSort:false,
		nowrap:false,
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		pageSize:10,
		pageNumber:1,
		pageList:[10,20,30,40,50],
		toolbar:'#stockOutcomeBillItem_datagrid_tb',
			columns:[[    
			          {field:'product',title:'商品名称',width:100,sortable:true,halign:'center',align:'center',formatter:forName},    
			          {field:'oddNumbers',title:'单号',width:100,sortable:true,halign:'center',align:'center'},    
			          {field:'serialNumber',title:'流水号',width:100,sortable:true,halign:'center',align:'center'},    
			          {field:'saleprice',title:'单价',width:100,sortable:true,halign:'center',align:'center'},    
			          {field:'client',title:'消费对象',width:100,sortable:true,halign:'center',align:'center',formatter:forName},    
			          {field:'discount',title:'折扣',width:100,sortable:true,halign:'center',align:'center'},    
			          {field:'saleamount',title:'销售总金额',width:100,sortable:true,halign:'center',align:'center'},    
			          {field:'number',title:'总数量',width:100,sortable:true,halign:'center',align:'center'},    
			          {field:'paytype',title:'支付方式',width:100,sortable:true,halign:'center',align:'center'},    
			          {field:'store',title:'消费店铺',width:100,sortable:true,halign:'center',align:'center',formatter:forName},    
			          {field:'parent',title:'所属店铺',width:100,sortable:true,halign:'center',align:'center',formatter:forName},    
			          {field:'intputtime',title:'消费时间',width:100,sortable:true,halign:'center',align:'center'},   
			          {field:'intputtime22',title:'操作',width:100,sortable:true,halign:'center',align:'center',formatter:forOperator}   
			      ]]    
	});
	function forName(value,rowData,rowIndex){
		if(value){
			return value.name;
		}
		return value;
	}
	function forOperator(value,rowData,rowIndex){
		return "<a href='/nopermission.jsp'>别点,痛~</a>";
	}
	/*
	 * 初始化新增/编辑对话框 
	 */
	stockOutcomeBillItemDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#stockOutcomeBillItem_dialog_bt'
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
				stockOutcomeBillItemForm.form("clear");
				stockOutcomeBillItemDialog.dialog("setTitle","新增");
				stockOutcomeBillItemDialog.dialog("open");
			},
			edit:function(){
				var rowData = stockOutcomeBillItemDatagrid.datagrid("getSelected");
				if(rowData){
					console.debug(rowData);
					stockOutcomeBillItemForm.form("clear");
					stockOutcomeBillItemDialog.dialog("setTitle","编辑");
					stockOutcomeBillItemDialog.dialog("open");
					if(rowData.client){
						rowData["client.id"] = rowData.client.id;
						console.debug(rowData);
					}
					if(rowData.store){
						rowData["store.id"] = rowData["store"].id;
						console.debug(rowData.store.id);
					}
					if(rowData.parent){
						rowData["parent.id"] = rowData["parent"].id;
						console.debug(rowData.parent.id);
					}
					stockOutcomeBillItemForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = stockOutcomeBillItemDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/stockOutcomeBillItem_delete.do?stockOutcomeBillItemId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										stockOutcomeBillItemDatagrid.datagrid("reload");
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

				stockOutcomeBillItemDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/stockOutcomeBillItem_update"
				}else{
					url = "/stockOutcomeBillItem_save";
				}
				stockOutcomeBillItemForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								stockOutcomeBillItemDialog.dialog("close");
								stockOutcomeBillItemDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				stockOutcomeBillItemDialog.dialog("close");
			}
	}
});
function TodaySearch(timeSearch){
	$("#stockOutcomeBillItem_datagrid").datagrid('reload',{
		'amount':timeSearch
	});
}

function AllSearch(){
	$("#stockOutcomeBillItem_datagrid").datagrid('reload',{});
}

function doSearch(value,name){
	$("#stockOutcomeBillItem_datagrid").datagrid('reload',{
		name:name,
		value : value
	});
	alert('You input: ' + value+'('+name+')');
}