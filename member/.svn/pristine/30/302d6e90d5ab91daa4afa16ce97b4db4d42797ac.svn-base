$(function(){
    var warehouseDatagrid = $("#warehouse_datagrid");
	//var warehouseDialog=$("#warehouse_dialog");
   var storeDatagrid = $("#store_datagrid");
	
	$("#warehouse").combobox({
		onSelect:function(warehouse){
			warehouseDatagrid.datagrid({
				url:'/productByWarehouseId_list?id='+warehouse.id,
				
				checkbox:true,
				striped:true,
				fitColumns:true,
				toolbar:'#warehouse_datagrid_tb',
				columns:[ [ 
				             {
				    checkbox:true,         	
					field : 'sn',
					title : '商品编码',
					width : 100
				}, {
					field : 'name',
					title : '商品名称',
					width : 100
				}, {
					field : 'costPrice',
					title : '商品进价',
					width : 100
				}, {
					field : 'stock',
					title : '商品库存',
					width : 100
				},  {
					field : 'units',
					title : '商品单位',
					width : 100
				}, {
					field : 'kind',
					title : '商品类型',
					width : 100,
					formatter : function (value, row, index) {
						return value ? value.name : "";
					}
				} ] ]
			});
		}
	});
	
	// 调拨的数据
	storeDatagrid.datagrid({
		//url:'/productByWarehouseId_list',
		checkbox:true,
		striped:true,
		fitColumns:true,
		onClickCell: onClickCell,
		columns:[ [ 
				             {
				           	
					field : 'sn',
					title : '商品编码',
					width : 100
				}, {
					field : 'name',
					title : '商品名称',
					width : 100
				}, {
					field : 'costPrice',
					title : '商品进价',
					width : 100
				}, {
					field : 'stock',
					title : '商品库存',
					width : 100,
					editor:'numberbox'
				},  {
					field : 'units',
					title : '商品单位',
					width : 100
				}, {
					field : 'kind',
					title : '商品类型',
					width : 100,
					formatter : function (value, row, index) {
						return value ? value.name : "";
					}
				},{
					field : 'del',
					title : '操作',
					width : 100,
					formatter : delFormatter
				} ] ]
	
	})
	
	function delFormatter(value,row,index){
		return "<a href=javascript:del("+index+");>取消</a>";
	}

});

// 取消选中的商品
function del(index){
	$('#store_datagrid').datagrid("deleteRow",index);
	// 重新计算数量和金额
	var sumnumber=0;
	var summoney=0;
	var row=$('#store_datagrid').datagrid("getRows");
	for (var i = 0; i < row.length; i++) {
		sumnumber = row[i].stock+sumnumber;
		summoney = row[i].costPrice+summoney;
	}
	$(document.getElementById("sumnumber")).html(sumnumber);
	$(document.getElementById("summoney")).html(summoney);
	
}

// 把选中的商品放入购物车
function choosePruduct(){
	var sumnumber=0;
	var summoney=0;
	// 获取购物车中的数据
	var all=$('#store_datagrid').datagrid('getRows');
	var row=$("#warehouse_datagrid").datagrid("getChecked");
	for (var i = 0; i < all.length; i++) {
		//all[i].stock=1;
		sumnumber = all[i].stock+sumnumber;
		summoney = all[i].costPrice+summoney;
	}
		
	for (var j = 0; j < row.length; j++) {
		row[j].stock=1;
		$('#store_datagrid').datagrid('appendRow',row[j]);
			sumnumber = row[j].stock+sumnumber;
			summoney = row[j].costPrice+summoney;
	}
	$(document.getElementById("sumnumber")).html(sumnumber);
	$(document.getElementById("summoney")).html(summoney);
}


function saveStore(){
	// 获取购物车中的所有数据
	var all=$('#store_datagrid').datagrid('getRows');
	// 获取选中的仓库和商店的id
	var warehouseId =$("#warehouse").combobox('getValue');
	var storeId =$("#store").combobox('getValue');
	var o =JSON.stringify(all);
	
	$.post("/transfersRecords_save",{"products":o,"wId":warehouseId,"sId":storeId},function(data){
		if (data.success) {
			$.messager.alert('温馨提示', data.msg, 'info', function() {
				
				// 刷新数据表格(保持在当前页)
				$("#warehouse_datagrid").datagrid("reload");
				$("#store_datagrid").datagrid("rejectChanges");
				$(document.getElementById("sumnumber")).html('');
				$(document.getElementById("summoney")).html('');
			});
		} else {
			$.messager.alert('温馨提示', data.msg, 'info');
		}
	})
}


