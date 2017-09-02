$(function(){
	var timeS;
	/*var options=$("#cc").combobox("options");
	console.debug(options);
	options.onSelect=function (recode){
		console.debug(recode);
		$("#memberresport_datagrid").datagrid('reload',{
			'paytype':recode.value
		});
	}*/
	/*
	 * 抽取所有需要用得元素.
	 */
	/*   $.get("/memberResport_load",function (data) {
           console.log(data)
           $("#bircount1").html(data.ppp)
           $("#usercount1").html(data.saleamount)
           $("#recelivableCount1").html(data.maoli);
           $("#recelivableName1").html(data.aaa)
       })*/
	
	//-------------------------------
	$.get("/productResport_load",function (data) {
        console.log(data)
        var s= data[0];
        console.debug(s);
        var ppp=0;
        var saleamount=0;
        var maoli=0;
        var aaa=0;
        for ( var int = 0; int < data.length; int++) {
        	ppp=ppp+data[int]["totalid"];
			saleamount=saleamount+data[int]["totalamount"];
			maoli=maoli+data[int]["maoli"];
			aaa=aaa+data[int]["lilv"];
		}
        $("#bircount1").html(ppp)
        $("#usercount1").html(saleamount)
        $("#recelivableCount1").html(maoli);
        $("#recelivableName1").html((aaa/ppp).toFixed(2))
    })
	var memberresport_datagrid;
	memberresport_datagrid = $("#memberresport_datagrid");
	/*
	 * 初始化数据表格 
	 */
	memberresport_datagrid.datagrid({
		url:"/productResport_list",
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
		  onBeforeLoad:function () {
			   /* 	var allcost=0;
			    	//使用同步的方式获取数据
					 var ids = $.ajax({
						  url: "/recharge_list",
						  async: false //同步
						 }).responseText;
					 ids = $.parseJSON(ids);
					 for ( var int = 0; int < ids.length; int++) {
						allcost=allcost+ids[int]["member"].totalConsume;
					}*/
					 //-----------------------------------------
			     /*  $.get("/memberResport_load?amount="+0,function (data) {
			            console.log(data)
			            var s= data[0];
			            console.debug(s);
			            var ppp=0;
			            var saleamount=0;
			            var maoli=0;
			            var aaa=0;
			            for ( var int = 0; int < data.length; int++) {
							ppp=ppp+data[int]["ppp"];
							saleamount=saleamount+data[int]["saleamount"];
							maoli=maoli+data[int]["maoli"];
							aaa=aaa+data[int]["aaa"];
						}
			            $("#bircount1").html(ppp)
			            $("#usercount1").html(saleamount)
			            $("#recelivableCount1").html(maoli);
			            $("#recelivableName1").html(aaa/ppp)
			        })
			        //----------------------------------------------
			        $.get("/memberResport_list?amount="+0,function (data2) {
			        	console.log(data2)
			        	var s= data2[0];
			        	console.debug(s);
			        	var bbb=0;
			        	var billamount=0;
			        	var maolili=0;
			        	var huia=0;
			        	for ( var int = 0; int < data2.length; int++) {
			        		bbb=bbb+data2[int]["bbb"];
			        		billamount=billamount+data2[int]["billamount"];
			        		maolili=maolili+data2[int]["maolili"];
			        		huia=huia+data2[int]["huia"];
			        	}
			        	$("#bircount2").html(bbb)
			        	$("#usercount2").html(billamount)
			        	$("#recelivableCount2").html(maolili);
			        	$("#recelivableName2").html(huia/bbb)
			        })*/
			    }
	});
	function forName(value,rowData,rowIndex){
		if(value){
			return value.name;
		}
		return value;
	}
});

function TodaySearch(timeSearch){
	$("#memberresport_datagrid").datagrid('reload',{
		'amount':timeSearch
	});
	//-------------------------
	$.get("/productResport_load?amount="+timeSearch,function (data) {
        console.log(data)
        var s= data[0];
        console.debug(s);
        var ppp=0;
        var saleamount=0;
        var maoli=0;
        var aaa=0;
        for ( var int = 0; int < data.length; int++) {
        	ppp=ppp+data[int]["totalid"];
			saleamount=saleamount+data[int]["totalamount"];
			maoli=maoli+data[int]["maoli"];
			aaa=aaa+data[int]["lilv"];
		}
        $("#bircount1").html(ppp)
        $("#usercount1").html(saleamount)
        $("#recelivableCount1").html(maoli);
        $("#recelivableName1").html((aaa/ppp).toFixed(2))
    })
}

function AllSearch(){
	$("#memberresport_datagrid").datagrid('reload',{});
	//-------------------------
	$.get("/productResport_load",function (data) {
        console.log(data)
        var s= data[0];
        console.debug(s);
        var ppp=0;
        var saleamount=0;
        var maoli=0;
        var aaa=0;
        for ( var int = 0; int < data.length; int++) {
			ppp=ppp+data[int]["totalid"];
			saleamount=saleamount+data[int]["totalamount"];
			maoli=maoli+data[int]["maoli"];
			aaa=aaa+data[int]["lilv"];
		}
        $("#bircount1").html(ppp)
        $("#usercount1").html(saleamount)
        $("#recelivableCount1").html(maoli);
        $("#recelivableName1").html((aaa/ppp).toFixed(2))
    })
}

function doSearch(value,name){
	$("#memberresport_datagrid").datagrid('reload',{
		name:name,
		value : value
	});
	alert('You input: ' + value+'('+name+')');
}