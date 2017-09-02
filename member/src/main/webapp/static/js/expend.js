$(function() {
	// 抽取变量
	var expend_datagrid = $("#expend_datagrid");
	var expend_dialog = $("#expend_dialog");
	var expend_form = $('#expend_form');
	// 初始化数据表格
	expend_datagrid.datagrid({
		url : "/expend_list",
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		toolbar : '#expend_tb',
		onLoadSuccess:sss,
		columns : [ [{
			field : 'smallClassify',
			title : '支出分类',
			width : 100,
			formatter : scFormatter
		}, {
			field : 'debit',
			title : '支出金额',
			width : 100
		}, {
			field : 'spendingtime',
			title : '支出时间',
			width : 100
		}, {
			field : 'spendingonstaff',
			title : '支付人员',
			width : 100
		}, {
			field : 'remark',
			title : '备注',
			width : 100
		}
		] ]
	});
	
	// 分类
	function scFormatter(value, row, index) {
		return value ? value.name : "";
	}
	
	expend_dialog.dialog({
		width : 300,
		height : 300,
		buttons : '#expend_btns',
		closed : true
	});
	function sss(){
		var rows = expend_datagrid.datagrid('getRows');
		var a = 0;//计算金额
		console.log(rows[0].debit);
		for ( var int = 0; int < rows.length; int++) {
			a = a + rows[int].debit
		}
		$("#sum").html(a);
	}
        
	var obj = {
		name : 'will',
		showName : function() {
			alert(1)
		}
	}
	var parent = $('#parentName').combobox('getValue');
	// 使用对象来统一管理方法
	var methodObj = {
		// 新增
		add : function() {
			// 清空表单
			expend_form.form("clear");
			// 打开弹出框
			expend_dialog.dialog("open");
			// 设置标题
			expend_dialog.dialog("setTitle", "支出录入");
		},

		// 编辑
		edit : function() {
			// 判断是否选中数据
			var row = expend_datagrid.datagrid("getSelected");
			console.log(row.smallClassify.parentId)
			if (!row) {
				$.messager.alert('温馨提示', '请选中一条数据!', 'info');
				return;
			}
			// 清空表单
			expend_form.form("clear");

			// 下拉框处理(同名匹配原则)
			if(row["smallClassify"]){
				
				row["smallClassify.id"] = row["smallClassify"].id;
				
				console.log(row["smallClassify"].id)
			}
			console.log(row["smallClassify"].id)
			
			$("#parentName").combobox("setValue",row["smallClassify"].parentId)
			// 回显数据
			expend_form.form("load", row);
			
			
			// 打开弹出框
			expend_dialog.dialog("open");
			// 设置标题
			expend_dialog.dialog("setTitle", "编辑明细");

		},

		// 取消保存
		cancel : function() {
			// 关闭窗口
			expend_dialog.dialog("close");
		},

		// 保存
		save : function(data) {
			//判断是否有id
			var url;
			if($("[name='id']").val()){
				url="/expend_update";
			}else{
				url="/expend_save";
			}
			//提交表单
			$('#expend_form').form('submit', {    
			    url:url,    
			    success:function(data){    
			    	//转成json对象
			    	data = $.parseJSON(data);
			    	if(data.success){
			    		$.messager.alert('温馨提示',data.msg,'info',function(){
				    		//关闭弹出框
				    		$("#expend_dialog").dialog("close");
				    		//刷新数据表格(保持在当前页)
				    		$("#expend_datagrid").datagrid("reload");
			    		});
			    	}else{
			    		$.messager.alert('温馨提示',data.msg,'info');
			    	}
			    }    
			}); 
		},

		// 删除
		changeState : function() {
			// 判断是否选中数据
			var row = expend_datagrid.datagrid("getSelected");
			console.log(row)
			if (!row) {
				$.messager.alert('温馨提示', '请选中一条数据!', 'info');
				return;
			}
			// 弹出确认框
			$.messager.confirm('确认对话框', '您想要删除这条数据吗？', function(r) {
				if (r) {
					$.post("/expend_delete", {
						id : row.id
					}, function(data) {
						console.log(data);
						$.messager.alert('温馨提示', data.msg, 'info', function() {
							// 刷新数据表格(保持在当前页)
							expend_datagrid.datagrid("reload");
						});
					})
				}  
			});

		},

		// 高级查询
		searchForm : function() {
			// 获取关键字文本框的值
			var begin = $("[name='begin']").val();
			var end = $("[name='end']").val();
			expend_datagrid.datagrid('load', {
				begin : begin,
				end : end
			});
		},

		// 查询全部数据
		reload : function() {
			// 清空查询条件的内容
			$("[name='begin']").val('');
			$("[name='end']").val('');
			expend_datagrid.datagrid('load', {});
		},
		//导出文件
		exportFile:function(){
			window.location.href="/expend_export.do";
		}
		
		
		
	}

	//统一绑定事件
	$("a[data-cmd]").on("click",function(){
		//获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		//掉用方法
		methodObj[methodName]();
	});
	
	
	
})
