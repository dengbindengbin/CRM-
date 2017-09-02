$(function() {
	/*
	 * 抽取所有需要用得元素.
	 */
	var productDatagrid, productDialog, productForm;
	productDatagrid = $("#product_datagrid");
	productDialog = $("#product_dialog");
	productForm = $("#product_form");

	/*
	 * 初始化数据表格
	 */
	productDatagrid.datagrid({
		url : "/product_list",
		fitColumns : true,
		fit : true,
		striped : true,
		pagination : true,
		singleSelect : true,
		rownumbers : true,
		toolbar : '#product_datagrid_tb',
		columns : [ [ 
		              {
			field : 'file',
			title : '商品图片',
			width : 100,
			formatter :imgFormatter
		},{
			field : 'sn',
			title : '商品编码',
			width : 100
		}, {
			field : 'name',
			title : '商品名称',
			width : 100
		}, {
			field : 'weight',
			title : '是否计重',
			width : 100,
			formatter : function (value, row, index) {
				return value ? "是" : "否";
			}
		}, {
			field : 'costPrice',
			title : '商品进价',
			width : 100
		}, {
			field : 'remark',
			title : '备注信息',
			width : 100,
		}, {
			field : 'lowPrice',
			title : '最低售价',
			width : 100,
		}, {
			field : 'units',
			title : '商品单位',
			width : 100,
		}, {
			field : 'integral',
			title : '商品积分',
			width : 100,
		}, {
			field : 'stock',
			title : '商品库存',
			width : 100,
		}, {
			field : 'price',
			title : '商品售价',
			width : 100,
		}, {
			field : 'lowDiscount',
			title : '最高售价',
			width : 100,
		}, {
			field : 'overdue',
			title : '过期时间',
			width : 100,
		}, {
			field : 'kind',
			title : '商品类型',
			width : 100,
			formatter : function (value, row, index) {
				return value ? value.type_name : "";
			}
		} ] ],
	});
	
	
	// 商品计重格式化
//	function weightFormatter(value, row, index) {
//		return value ? "是" : "否";
//	}
	// 商品类型格式化
//	function kindFormatter(value, row, index) {
//		return value ? value.name : "";
//	}
	// 商品图片格式化
	function imgFormatter(value, row, index) {
		console.log(row.file);
		return value ? "<img alt='ooxx' height='100' src='"+row.file+"'>" : "";
	}
	
	
	
	/*
	 * 初始化新增/编辑对话框
	 */
	productDialog.dialog({
		width : 550,
		height : 300,
		closed : true,
		buttons : '#product_dialog_bt'
	});
	
	/*
	 * 所有的操作封装到cmdObj对象中,方便管理
	 */
	var cmdObj = {
		add : function() {
			// 清空表单
			productForm.form("clear");
			// 打开弹出框
			productDialog.dialog("open");
			// 设置标题
			productDialog.dialog("setTitle", "新增商品");
		},
		//编辑
		edit : function() {
			// 判断是否为选中数据
			var rowData = productDatagrid.datagrid("getSelected");
			//console.log(rowData);
			
			if (rowData) {
				//清空表单
				productForm.form("clear");
				//设置标题
				productDialog.dialog("setTitle", "编辑");
				//打开弹出框
				productDialog.dialog("open");
				//商品计重 回显
				if (rowData["weight"]){
					rowData["weight"] = "1";
				}else{
					rowData["weight"] = "0";
				}
				rowData["kind.id"]=rowData["kind"].id;
				$("#filePath").prop("src",rowData.file);
				//回显数据
				productForm.form("load", rowData);
			} else {
				$.messager.alert("温馨提示", "请选择需要编辑的数据!", "warining");
			}
		},
		//删除
		del : function() {
			var rowData = productDatagrid.datagrid("getSelected");
			if (rowData) {
				$.messager.confirm(
					"温馨提示",
					"您确定需要删除选中数据吗？",
					function(yes) {
						if (yes) {
							$.post("/product_delete",{prodcutId:rowData.id},
								function(data) {
									if (data.success) {
										$.messager.alert(
											"温馨提示",
											data.msg,
											"info",
											function() {
												productDatagrid.datagrid("reload");
											});
									} else {
										$.messager.alert(
											"温馨提示",
											data.msg,
											"error");
									}
							}, "json")
						}
					});
			} else {
				$.messager.alert("温馨提示", "请选择需要删除的数据!", "warining");
			}
		},
		reload : function() {
			// 获取关键字文本框的值
			$("[name='keyword']").val("");

			productDatagrid.datagrid('load', {
				keyword : ""
			});
			//productDatagrid.datagrid("reload");
		},
		save : function() {
			var url;
			var idVal = $("[name='id']").val();
			if (idVal) {
				url = "/product_update"
			} else {
				url = "/product_save";
			}
			//提交表单
			productForm.form("submit", {
				url : url,
				/*onSubmit : function(param) {
					//获取下拉框的值
					var ids = $("#kind_combobox").combobox("getValue");
					console.log(ids);
					console.debug(param);
					console.debug($("#productTable").find("input"));
					var tables = $("#productTable").find("input");
					tables.each(function(index,value){
						if(index == 1){
							var xxx = $(value).prop("value");
							param.file = xxx;
						}
					})
					//添加商品类型的参数
					for(var i=0;i<ids.length;i++){
						param["kind["+i+"].name"] = ids[name];
//					}
					param["kind.id"] = ids;
					console.debug(param);
				},*/
			success : function(data) {
					// 转成json对象
					data = $.parseJSON(data);
					if (data.success) {
						$.messager.alert("温馨提示", data.msg, "info", function() {
							console.log(data);
							// 关闭弹出框
							productDialog.dialog("close");
							// 刷新数据表格(保持在当前页)
							productDatagrid.datagrid("reload");
						});
					} else {
						$.messager.alert("温馨提示", data.msg, "info");
					}
				}
			});
		},
		// 高级查询
		searchForm : function() {
			// 获取关键字文本框的值
			var keyword = $("[name='keyword']").val();

			productDatagrid.datagrid('load', {
				keyword : keyword
			});
		},
		
		cancel : function() {
			productDialog.dialog("close");
		},
		
	};
	
	
	
	/*
	 * 对页面按钮进行统一监听
	 */
	$("a[data-cmd]").on("click", function() {
		var cmd = $(this).data("cmd");
		if (cmd) {
			cmdObj[cmd]();
		}
	});
});
