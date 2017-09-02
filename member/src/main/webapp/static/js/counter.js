$(function(){
	//渲染结算对话框
	$('#counter_dialog').dialog({    
	    title: '结算账单',    
	    width: 300,    
	    height: 300,    
	    closed: true,    
	    cache: false,    
	    modal: true, 
	    buttons:"#ct"
	});    


	//会员列表对话框
	var memberDatagrid = $("#member_datagrid");
	var memberMsgDialog = $("#memberMsg_dialog");
	//渲染会员列表对话框
	memberDatagrid.datagrid({
        url:"/member_list",
        fit:true,
        rownumbers:true,
        singleSelect:true,
        striped:true,
        pagination:true,
        fitColumns:true,
        columns : [ [
         {
         field : 'sn',
         title : '会员卡号',
         width : 100
        },
        {
            field : 'name',
            title : '会员姓名',
            width : 100
        }, {
            field : 'level',
            title : '会员等级',
            width : 100,
            formatter:levelFormatter
        }, {
            field : 'birthday',
            title : '生日',
            width : 100
        }, {
            field : 'totalMoney',
            title : '卡上余额',
            width : 100
        }, {
            field : 'integral',
            title : '会员积分',
            width : 100,
        }, {
            field : 'deadline',
            title : '过期时间',
            width : 100,
        } ,
        {
            field : 'discount',
            title : '会员折扣',
            width : 100,
            formatter:discountFormatter
        }] ],
        onDblClickRow:function (rowIndex, rowData) {
          //双击,选中当前行数据
        	var cId = rowData.id;
        	var discount = rowData.level.discount;
        	var memName = rowData.name;
        	var totalMoney = rowData.totalMoney;
        	$("#menName").html(memName);
        	$("#cId").val(cId);
        	$("#dis").numberbox("setValue",discount);
        	 $("#men").numberbox("setValue",totalMoney);
        	 $("#memberMsg_dialog").dialog("close");
        }
	})
	
	//弹出会员信息表
    memberMsgDialog.dialog({
        width:900,
        height:600,
        title:"会员信息表",
        closed:true
	})
	//测试
	$("#count").numberbox({
		min:0,
		precision:2,
		value:0
	});
	$("#men").numberbox({
		min:0,
		precision:2,
		value:0
	});
	$("#dis").numberbox({
		min:0.3,
		max:1,
		precision:2,
		value:1,
		onChange:function(newValue,oldValue){
			//获取总合计
			var nowTotal = $("#count").numberbox("getValue");
			var numNowTotal = new Number(nowTotal);
			//获取折扣
			 var dis = $("#dis").numberbox("getValue");
			 var numDis = new Number(dis);
			 //计算折扣后的应收款
			  var disNumNowTotal = numDis * numNowTotal;
			  $("#real").numberbox("setValue",disNumNowTotal);
			 
		}
	});
	$("#real").numberbox({
		min:0,
		precision:2,
		value:0
	});
	
	
	//设置系统当前时间
	setInterval(function(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	var day = date.getDate();
	var hour = date.getHours();
	var minute=date.getMinutes();
	var second = date.getSeconds();
	var h  =document.getElementById("hour");
	var m = document.getElementById("minute");
	var s = document.getElementById("second");
	var y = document.getElementById("year");
	var mon = document.getElementById("month");
	var d = document.getElementById("day");
	var y1 = document.getElementById("year1");
	var mon1 = document.getElementById("month1");
	var d1 = document.getElementById("day1");
	console.log(year,month,day);
	y.innerHTML=year;
	mon.innerHTML=month+1;
	y1.innerHTML=year;
	mon1.innerHTML=month+1;
	h.innerHTML=hour;
	m.innerHTML=minute;
	s.innerHTML=second;
	d.innerHTML=day;
	d1.innerHTML=day;
	
	},1000);
	
	//结算框
	$("#panelProduct").panel({
		width:333,    
		height:420,
		border:true,
	});
	
	
	$("#product_datagrid").datagrid({
		url:"/employee_list",
		  columns:[[    
		            {field:'username',title:'商品名称',width:90},    
		            {field:'realname',title:'单价',width:90},    
		            {field:'tel',title:'数量',width:90,align:'right'}    
		        ]]    
	});
	
	
	
	
	
})


//定义将商品信息添加到购物车中的方法
function addToCar(obj){
	 obj.style.background = "none";
	
	 var oldStock = $(obj).find("[id=stock]").html();
	 var oldStockNum=new Number(oldStock);
		//判断库存是否充足
		if (oldStockNum <= 0) {
			$.messager.alert('警告','库存不足');  
			return;
		}
		
	//判断购物车中是否存在该商品
	 var ul = $("#productUl");
	 var arrayLi =  ul.children("li");
	 for ( var index = 0; index < arrayLi.length; index++) {
		 
		var objName = $(obj).data("name");
		var liName = $(arrayLi[index]).find("[name='productName']").html();
		if (objName == liName) {//如果存在,则选中
			change(arrayLi[index]);
			/*var value = $(arrayLi[index]).find("[name='productNums']").val();
			$(arrayLi[index]).find("[name='productNums']").val(100);
			value = $(arrayLi[index]).find("[name='productNums']").val();
			console.log(value);
			var inputObj = arrayLi[index]
			console.log("--------inputObj-------------")
			console.log( inputObj);
			console.log("--------inputObj-------------")*/
			//inputObj.numberspinner("setValue",value+1);
			
			return;
		}
	}
	 //添加一个新的商品
	 var newLi = $("#copyLi").clone(true);
		newLi.attr("class","liClassShow")
		newLi.find("[name='productName']").html($(obj).data("name"))
		newLi.find("[name='productSn']").html($(obj).data("sn"))
		newLi.find("[name='proPrice']").html($(obj).data("price"))
		newLi.find("[name='productId']").val($(obj).data("proclassid"))
		newLi.find("[name='totalPrice']").html($(obj).data("price"))
		newLi.attr("id")
		//为input标签渲染easyui-numberspinner组件
		newLi.find("[name='productNums']").numberspinner({
			value:1,
			min:1,
			editable:true,
			//绑定值改变事件,当数量变化时,改变总价
			onChange:function(newValue,oldValue){
				var oldValueNum = new Number(oldValue);
				var newValueNum = new Number(newValue);
				
				//定义临时变量temp,设置成全局变量,供外部函数使用,并最初值保持不变
				if (oldValue==1) {
					var oldStock = $(obj).find("[id=stock]").html();
					var oldStockNum=new Number(oldStock);
					var nowValue = new Number(oldValue);
					window.temp=oldStockNum+nowValue;
				}
				
				if (newValueNum <= temp) {
					var nowStock = $(obj).find("[id=stock]");
					nowStock.html(temp-newValueNum);
				}else{
					$.messager.alert('警告','库存不足,此商品最多可购买'+temp+"个"); 
					$(this).numberspinner("setValue",temp);
					return;
				}
				//哥们,看一下下面啊,this贼他么好用啊,长记性啊
				var parentli = $(this).closest("li");
				var price = parentli.find("[name='proPrice']").html();
				var number = $(this).val();
				var totalPrice =price * number;
				parentli.find("[name=totalPrice]").html(totalPrice);
				count();
			}
		})
		
		newLi.appendTo(ul);
		//库存大于等于1时,相应地在页面减少商品库存
		var newStockNum =  oldStockNum -1;
		var stock = $(obj).find("[id=stock]");
		stock.html(newStockNum);
		count();
	
	
	
}




//点击购物车的商品时,显示选中状态
function change(obj){
	var arr = $("[class=liClassShow]")
    for (var i = 0; i < arr.length; i++) {
        var a = arr[i];
        a.style.background = "none";
    };
    obj.style.background = "grey";
}

function changeBack(obj){

    obj.style.background = "grey";
}


//合计购物车所有的商品总价
function count(){
	
	$("#count").numberbox("setValue",0.00);
	var nowTotal = $("#count").numberbox("getValue");
	var numNowTotal = new Number(nowTotal);
	 var ul = $("#productUl");
	 var arrayLi =  ul.children("li");
	 for ( var index = 0; index < arrayLi.length; index++) {
		var eachTotal = $(arrayLi[index]).find("[name='totalPrice']").html();
		var numEachTotal = new Number(eachTotal);
		numNowTotal = numNowTotal + numEachTotal;
	}
	 $("#count").numberbox("setValue",numNowTotal);
	 //获取折扣
	 var dis = $("#dis").numberbox("getValue");
	 var numDis = new Number(dis);
	 //计算折扣后的应收款
	  var disNumNowTotal = numDis * numNowTotal;
	  $("#real").numberbox("setValue",disNumNowTotal);
}

//删除购物车中的当前商品
function removeProduct(){
	 var ul = $("#productUl");
	 var arrayLi =  ul.children("li");
	 for ( var index = 0; index < arrayLi.length; index++) {
			if (arrayLi[index].style.background == "grey none repeat scroll 0% 0%") {
				$(arrayLi[index]).remove();
				count();
				//获取到商品列表中的商品div块
				var preId = $(arrayLi[index]).find("[name='productId']").val();
				var returnStock = $("#product"+preId).find("[id='stock']");
				var productId = $("#product"+preId).find("[name=productId]").val();
				$.post("/product_get",{"id":productId},function(data){
					var preStock = data.stock
					console.log(preStock);
					returnStock.html(preStock);
				})
				
				
				//判断当前购物车中是否还剩有商品,如果没有了,则把结算模块数据清空
				 arrayLi =  ul.children("li");
				if (arrayLi.length <= 0) {
					//清空会员姓名和折扣
					$("#menName").html('');
		        	$("#dis").numberbox("setValue",1.00);
		        	 $("#men").numberbox("setValue",0.00);
				}
				return ;
			}
		}
}
//会员等级格式化
function levelFormatter(value,row,index) {
    if (value.id ==1){
        return value.name
    }
    if (value.id==2){
        return "<font style='color: #ffee10'>"+value.name+"</font>"
    }
    if(value.id==3){
        return "<font style='color: #eefffb'>"+value.name+"</font>"
    }
    if (value.id==4){
        return "<font style='color: #50ff0f'>"+value.name+"</font>"
    }
    if (value.id==5){
        return "<font style='color: #ff568f'>"+value.name+"</font>"
    }
    return "不是会员哦";
}
function discountFormatter(value,row,index){
	return row.level.discount;
}
//选择会员
function selectMember(){
	$("#memberMsg_dialog").dialog("open");
}

//获取当前购物车中被选中的li/商品
function selectLi(){
	 var ul = $("#productUl");
	 var arrayLi =  ul.children("li");
	 for ( var index = 0; index < arrayLi.length; index++) {
			if (arrayLi[index].style.background == "grey none repeat scroll 0% 0%") {
				return arrayLi[index];
			}
		}
}
//获取当前购物车中所有的li/商品
function selectAllLi(){
	var ul = $("#productUl");
	var arrayLi =  ul.children("li");
	return arrayLi;
}

//结算方法
function squareAccounts(){
	//判断购物车中是否有商品
	 var ul = $("#productUl");
	 var arrayLi =  ul.children("li");
	 if (arrayLi.length<=0) {
		 $.messager.alert('温馨提示',"请选择商品"); 
				 return;
	}
	 
	$('#counter_dialog').dialog("open")
	parentDiv = $('#accountDiv');
	parentDiv.find("ul").remove();
	var childUl = $("#accountUl").clone();
	var memName = childUl.find("[id='menName']").html();
	if (memName == '') {
		childUl.find("[id='menName']").html("散客");
		childUl.find("[id='cId']").val('');
	}
	childUl.appendTo(parentDiv);
}
//埋单方法
function insert(){
	$('#counter_dialog').dialog("close");
	//-------------客户保存-----------------
	//获取会员的id
	var accountUl = $("#accountDiv").find("ul");
	var mId =accountUl.find("[id=cId]").val();
	console.log("会员id:"+mId);
	//获取会员的名称
	var menName = accountUl.find("[id=menName]").html();
	console.log("会员的名称:"+menName);
	//保存客户
	$.post("/client_save",{"memberId":mId,"name":menName},function(data){
		//保存客户结束后,进行商品保存
		//---------------商品保存--------------------
		var clientId = data.id;
		
		//---------制作订单号-----------------
		var year1 = $("#year1").html();
		var month1 = $("#month1").html();
		var day1 = $("#day1").html();
		//获取会员的id
		var accountUl = $("#accountDiv").find("ul");
		var mId =accountUl.find("[id=cId]").val();
		if (mId=='') {
			mId = '007'+Math.ceil(Math.random()*100);
		}
		var billNumber = year1+month1+day1+mId;
		console.log("单号:"+billNumber);
		//---------制作订单号-----------------
		//获取商品的折扣
		var discount =accountUl.find("[id=dis]").val();
		//获取购物车中所有的商品
		var allProducts = selectAllLi();
		//迭代商品集合
		for ( var index = 0; index < allProducts.length; index++) {
			//该商品id
			var proId = $(allProducts[index]).find("[name='productId']").val();
			console.log("商品id:"+proId);
			//该商品的购买数量
			var number = $(allProducts[index]).find("[name='productNums']").val();
			console.log("商品number:"+number);
			//该商品的消费总额
			var totalMoney = $(allProducts[index]).find("[name='totalPrice']").html();
			console.log("消费总额:"+totalMoney);
			//获取支付方式
			var payWay = $("#payWay").val();
			console.log(payWay);
			//制作流水单号
			var date = new Date();
			var hour = date.getHours();
			var minute=date.getMinutes();
			var second = date.getSeconds();
			var billRiverNumber = billNumber + hour + minute + second;
			console.log("流水号:"+billRiverNumber);
			console.log("clientId:"+clientId);
			var billData = {
					"productId":proId,
					"number":number,
					"saleamount":totalMoney,
					"paytype":payWay,
					"serialNumber":billRiverNumber,
					"oddNumbers":billNumber,
					"discount":discount,
					"clientId":clientId
			}
			$.post("/stockOutcomeBillItem_save",billData,function(data){
				if (data.success) {
					$.messager.alert('温馨提示',data.msg); 
					window.location.href="/counter";
				}else{
					$.messager.alert('温馨提示',data.msg); 
				}
			},"json")
		}
	},"json");
	
}
