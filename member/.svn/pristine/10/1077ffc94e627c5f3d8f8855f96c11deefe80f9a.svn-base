$(function() {
	// 抽取变量
	var classify_datagrid = $("#classify_datagrid");
	var classify_dialog = $("#classify_dialog");
	var classify_form = $('#classify_form');
	
	// 初始化数据表格
	classify_datagrid.datagrid({
		url : "/classify_selectAll",
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		onClickRow :sss,
		toolbar : '#classify_tb',
		columns : [ [ {
			field : 'id',
			title : 'id',
			width : 100,
		}, {
			field : 'name',
			title : '大分类',
			width : 100
		}
		] ]
	});
	
	classify_dialog.dialog({
		width : 300,
		height : 200,
		buttons : '#classify_btns',
		closed : true
	});
	var methodObj ={
			// 新增
			add : function() {
				var rows =classify_datagrid.datagrid('getRows')
				// 清空表单
				classify_form.form("clear");
				// 打开弹出框
				classify_dialog.dialog("open");
				// 设置标题
				classify_dialog.dialog("setTitle", "支出录入");
			},
			// 编辑
			edit : function() {
				// 判断是否选中数据
				if (!row) {
					$.messager.alert('温馨提示', '请选中一条数据!', 'info');
					return;
				}
				// 清空表单
				classify_form.form("clear");
				classify_form.form("load", row);
				// 打开弹出框
				classify_dialog.dialog("open");
				// 设置标题
				classify_dialog.dialog("setTitle", "编辑明细");
		
			},
			// 保存
			save : function(data) {
				//判断是否有id
				var url;
				if($("[name='id']").val()){
					url="/classify_update";
				}else{
					url="/classify_save";
				}
				//提交表单
				$('#classify_form').form('submit', {    
				    url:url,    
				    success:function(data){    
				    	//转成json对象
				    	data = $.parseJSON(data);
				    	if(data.success){
				    		$.messager.alert('温馨提示',data.msg,'info',function(){
					    		//关闭弹出框
					    		$("#classify_dialog").dialog("close");
					    		//刷新数据表格(保持在当前页)
					    		$("#classify_datagrid").datagrid("reload");
				    		});
				    	}else{
				    		$.messager.alert('温馨提示',data.msg,'info');
				    	}
				    }    
				}); 
			},
			// 取消保存
			cancel : function() {
				// 关闭窗口
				classify_dialog.dialog("close");
			},

			// 删除
			changeState : function() {
				// 判断是否选中数据
				var row = classify_datagrid.datagrid("getSelected");
				console.log(row)
				if (!row) {
					$.messager.alert('温馨提示', '请选中一条数据!', 'info');
					return;
				}
				// 弹出确认框
				$.messager.confirm('确认对话框', '您想要删除这条数据吗？', function(r) {
					if (r) {
						$.post("/classify_delete", {
							id : row.id
						}, function(data) {
							console.log(data);
							$.messager.alert('温馨提示', data.msg, 'info', function() {
								// 刷新数据表格(保持在当前页)
								classify_datagrid.datagrid("reload");
							});
						})
					}  
				});

			},
			// 高级查询
			searchForm : function() {
				// 获取关键字文本框的值
				var keyword = $("[name='keyword']").val();
				classify_datagrid.datagrid('load', {
					keyword : keyword
				});
			},

			// 查询全部数据
			reload : function() {
				// 清空查询条件的内容
				$("[name='keyword']").val('');
				classify_datagrid.datagrid('load', {});
			}

	}
		
	//统一绑定事件
	$("a[data-cmd]").on("click",function(){
		//获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		//掉用方法
		methodObj[methodName]();
	});
	
	function sss(){
		var row = classify_datagrid.datagrid("getSelected");
		var parentId = row.id;
		console.log(row.id)
		var smallClassify_datagrid = $("#smallClassify_datagrid");
		var smallClassify_dialog = $("#smallClassify_dialog");
		var smallClassify_form = $('#smallClassify_form');
		smallClassify_datagrid.datagrid({
			url : "/smallclassify_query?parentId="+parentId,
			fitColumns : true,
			striped : true,
			fit : true,
			pagination : true,
			singleSelect : true,
			toolbar : '#smallClassify_tb',
			columns : [ [ {
				field : 'id',
				title : 'id',
				width : 100,
			}, {
				field : 'name',
				title : '小分类',
				width : 100
			},{
			field : 'parentId',
			title : '大分类',
			width : 100,
			formatter : ssFormatter
		}
			] ]
		});
		// 分类
		function ssFormatter(value, row, index) {
			var name = $.ajax({
				  url: "/classify_selectByPrimaryKey?id="+value,
				  async: false //同步
				 }).responseText;
			name = $.parseJSON(name);
			return name.name;
		}
		smallClassify_dialog.dialog({
			width : 300,
			height : 200,
			buttons : '#smallClassify_btns',
			closed : true
		});
		
		var methodObj = {
				// 新增
				add : function() {
					// 清空表单
					smallClassify_form.form("clear");
					// 打开弹出框
					smallClassify_dialog.dialog("open");
					// 设置标题
					smallClassify_dialog.dialog("setTitle", "支出录入");
				},

				// 编辑
				edit : function() {
					// 判断是否选中数据
					var row = smallClassify_datagrid.datagrid("getSelected");
					if (!row) {
						$.messager.alert('温馨提示', '请选中一条数据!', 'info');
						return;
					}
					// 清空表单
					smallClassify_form.form("clear");

					smallClassify_form.form("load", row);
					
					// 打开弹出框
					smallClassify_dialog.dialog("open");
					// 设置标题
					smallClassify_dialog.dialog("setTitle", "编辑明细");

				},

				// 取消保存
				cancel : function() {
					// 关闭窗口
					smallClassify_dialog.dialog("close");
				},

				// 保存
				save : function(data) {
					//判断是否有id
					var url;
					if($("[name='id']").val()){
						url="/smallclassify_update";
					}else{
						url="/smallclassify_save";
					}
					//提交表单
					$('#smallClassify_form').form('submit', {    
					    url:url,    
					    success:function(data){    
					    	//转成json对象
					    	data = $.parseJSON(data);
					    	if(data.success){
					    		$.messager.alert('温馨提示',data.msg,'info',function(){
						    		//关闭弹出框
						    		$("#smallClassify_dialog").dialog("close");
						    		//刷新数据表格(保持在当前页)
						    		$("#smallClassify_datagrid").datagrid("reload");
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
					var row = smallClassify_datagrid.datagrid("getSelected");
					if (!row) {
						$.messager.alert('温馨提示', '请选中一条数据!', 'info');
						return;
					}
					// 弹出确认框
					$.messager.confirm('确认对话框', '您想要删除这条数据吗？', function(r) {
						if (r) {
							$.post("/smallclassify_delete", {
								id : row.id
							}, function(data) {
								$.messager.alert('温馨提示', data.msg, 'info', function() {
									// 刷新数据表格(保持在当前页)
									smallClassify_datagrid.datagrid("reload");
								});
							})
						}  
					});

				},

				// 高级查询
				searchForm : function() {
					// 获取关键字文本框的值
					var keywords = $("[name='keywords']").val();
					smallClassify_datagrid.datagrid('load', {
						keywords : keywords
					});
				},

				// 查询全部数据
				reload : function() {
					// 清空查询条件的内容
					$("[name='keywords']").val('');
					smallClassify_datagrid.datagrid('load', {});
				}
			}

			//统一绑定事件
			$("a[data-cmds]").on("click",function(){
				//获取该链接需要执行的方法名字
				var methodName = $(this).data("cmds");
				//掉用方法
				methodObj[methodName]();
			});
		
	}
	
})
