
function TodaySearch(timeSearch) {
	$.get("/billResport_list?amount="+timeSearch, function(data) {
		console.log(data)
		$("#a1").html("￥0");
		$("#a2").html("￥0");
		$("#a3").html("￥0");
		$("#a4").html("￥0");
		$("#a5").html("会员总收入:￥0");
		var ss1;
		var ss2;
		var ss3;
		var ss4;
		var ss5=0;;
		if(data[0]){
			 ss1 = data[0].paytotal;
			 $("#a1").html("￥" + ss1)
			 ss5=ss5+ss1;
		}
		if(data[1]){
			 ss2 = data[1].paytotal;
			 $("#a2").html("￥" + ss2)
			 ss5=ss5+ss2;
		}
		if(data[2]){
			 ss3 = data[2].paytotal;
			 $("#a3").html("￥" + ss3);
			 ss5=ss5+ss3;
		}
		if (data[3]) {
			ss4 = data[3].paytotal;
			$("#a4").html("￥" + ss4);
			 ss5=ss5+ss4;
		}
		$("#a5").html("会员总收入:￥"+ss5);
	})
	// -------------------------------
		// ---------------------------------------------------
	$.get("/billResport_load?amount="+timeSearch, function(data) {
		$("#c1").html("￥0");
		$("#c2").html("￥0");
		$("#c3").html("￥0");
		$("#c4").html("￥0");
		$("#c5").html("￥0");
		$("#c6").html("0人");
		/*
		 * $("#m1").html("￥0"); $("#m2").html("￥0"); $("#m3").html("￥0");
		 * $("#m4").html("￥0"); $("#m5").html("￥0"); $("#m6").html("0人");
		 * $("#m7").html("时间");
		 */
		console.log(data)
		var c1;
		var c2;
		var c3;
		var c4;
		var c5=0;
		var c6=0;
		var cnum=0;
		/*
		 * var m1; var m2; var m3; var m4; var m5=0; var m6=0;
		 */
		var carray=new Array(6);
		var marray=new Array(7);
		for ( var int = 0; int < data.length; int++) {
			c6=c6+1;
			cnum=cnum+data[int]["cnum"];
			console.debug(data[int].paytype);
			if(data[int].paytype==="支付宝支付"){
				c4=data[int]["clienttotal"];
				c5=c5+c4;
				$("#c4").html("￥"+c4);
			}
			if(data[int].paytype==="现金支付"){
				c1=data[int]["clienttotal"];
				c5=c5+c1;
				$("#c1").html("￥"+c1);
			}
			if(data[int].paytype==="微信支付"){
				c2=data[int]["clienttotal"];
				c5=c5+c2;
				$("#c2").html("￥"+c2);
				
			}
			if(data[int].paytype==="银行卡支付"){
				c3=data[int]["clienttotal"];
				c5=c5+c3;
				$("#c3").html("￥"+c3);
			}
		}
		$("#c5").html("￥"+c5);
		$("#c6").html(cnum+"人");
	})
	//-----------------------会员消费-----------------------------------
	$.get("/billResport_loadm?amount="+timeSearch, function(data) {
		/*
		 * $("#c1").html("￥0"); $("#c2").html("￥0"); $("#c3").html("￥0");
		 * $("#c4").html("￥0"); $("#c5").html("￥0"); $("#c6").html("0人");
		 */
		
		  $("#m1").html("￥0"); $("#m2").html("￥0"); $("#m3").html("￥0");
		 $("#m4").html("￥0"); $("#m5").html("￥0"); $("#m6").html("0人");
		  $("#m7").html("时间");
		
		console.log(data)
	/*	var c1;
		var c2;
		var c3;
		var c4;
		var c5=0;
		var c6=0;*/
		  var m1; 
		var m2; 
		var m3;
		var m4; 
		var m5=0;
		var m6=0;
		var marray=new Array(7);
		for ( var int = 0; int < data.length; int++) {
			m6=m6+1;
			console.debug(data[int].paytype);
			if(data[int].paytype==="支付宝支付"){
				m4=data[int]["clienttotal"];
				m4=m4.toFixed(2);
				m5=m5+m4;
				$("#m4").html("￥"+m4);
			}
			if(data[int].paytype==="现金支付"){
				m1=data[int]["clienttotal"];
				m1=m1.toFixed(2);
				m5=m5+m1;
				$("#m1").html("￥"+m1);
			}
			if(data[int].paytype==="微信支付"){
				m2=data[int]["clienttotal"];
				m2=m2.toFixed(2);
				m5=m5+m2;
				$("#m2").html("￥"+m2);
				
			}
			if(data[int].paytype==="银行卡支付"){
				m3=data[int]["clienttotal"];
				m3=m3.toFixed(2);
				m5=m5+m3;
				$("#m3").html("￥"+m3);
			}
		}
		$("#m5").html("￥"+m5);
		$("#m6").html("￥"+m6);
	})
}
function AllSearch() {
	$.get("/billResport_list", function(data) {
		console.log(data)
		$("#a1").html("￥0");
		$("#a2").html("￥0");
		$("#a3").html("￥0");
		$("#a4").html("￥0");
		$("#a5").html("会员总收入:￥0");
		var ss1;
		var ss2;
		var ss3;
		var ss4;
		var ss5=0;;
		if(data[0]){
			 ss1 = data[0].paytotal;
			 $("#a1").html("￥" + ss1)
			 ss5=ss5+ss1;
		}
		if(data[1]){
			 ss2 = data[1].paytotal;
			 $("#a2").html("￥" + ss2)
			 ss5=ss5+ss2;
		}
		if(data[2]){
			 ss3 = data[2].paytotal;
			 $("#a3").html("￥" + ss3);
			 ss5=ss5+ss3;
		}
		if (data[3]) {
			ss4 = data[3].paytotal;
			$("#a4").html("￥" + ss4);
			 ss5=ss5+ss4;
		}
		$("#a5").html("会员总收入:￥"+ss5);
	})
	//-----------------------消费-----------------
// ----------------------消费-----------------------------
	
	$.get("/billResport_load?amount=0", function(data) {
		$("#c1").html("￥0");
		$("#c2").html("￥0");
		$("#c3").html("￥0");
		$("#c4").html("￥0");
		$("#c5").html("￥0");
		$("#c6").html("0人");
		/*
		 * $("#m1").html("￥0"); $("#m2").html("￥0"); $("#m3").html("￥0");
		 * $("#m4").html("￥0"); $("#m5").html("￥0"); $("#m6").html("0人");
		 * $("#m7").html("时间");
		 */
		console.log(data)
		var c1;
		var c2;
		var c3;
		var c4;
		var c5=0;
		var c6=0;
		var cnum=0;
		/*
		 * var m1; var m2; var m3; var m4; var m5=0; var m6=0;
		 */
		var carray=new Array(6);
		for ( var int = 0; int < data.length; int++) {
			c6=c6+1;
			cnum=cnum+data[int]["cnum"];
			console.debug(data[int].paytype);
			if(data[int].paytype==="支付宝支付"){
				c4=data[int]["clienttotal"];
				c5=c5+c4;
				$("#c4").html("￥"+c4);
			}
			if(data[int].paytype==="现金支付"){
				c1=data[int]["clienttotal"];
				c5=c5+c1;
				$("#c1").html("￥"+c1);
			}
			if(data[int].paytype==="微信支付"){
				c2=data[int]["clienttotal"];
				c5=c5+c2;
				$("#c2").html("￥"+c2);
				
			}
			if(data[int].paytype==="银行卡支付"){
				c3=data[int]["clienttotal"];
				c5=c5+c3;
				$("#c3").html("￥"+c3);
			}
		}
		$("#c5").html("￥"+c5);
		$("#c6").html(cnum+"人");
	})
	//--------------------会员消费------------------------
	$.get("/billResport_loadm?amount=0", function(data) {
		/*
		 * $("#c1").html("￥0"); $("#c2").html("￥0"); $("#c3").html("￥0");
		 * $("#c4").html("￥0"); $("#c5").html("￥0"); $("#c6").html("0人");
		 */
		
		  $("#m1").html("￥0"); $("#m2").html("￥0"); $("#m3").html("￥0");
		 $("#m4").html("￥0"); $("#m5").html("￥0"); $("#m6").html("0人");
		  $("#m7").html("时间");
		
		console.log(data)
	/*	var c1;
		var c2;
		var c3;
		var c4;
		var c5=0;
		var c6=0;*/
		 var m1=0;
		var m2=0;
		var m3=0; 
		var m4=0;
		var m5=0;
		var m6=0;
		var cnum=0;
		var marray=new Array(7);
		for ( var int = 0; int < data.length; int++) {
			m6=m6+1;
			cnum=cnum+data[int]["cnum"];
			console.debug(data[int].paytype);
			if(data[int].paytype==="支付宝支付"){
				m4=data[int]["clienttotal"];
				m5=m5+m4;
				$("#m4").html("￥"+m4);
			}
			if(data[int].paytype==="现金支付"){
				m1=data[int]["clienttotal"];
				m5=m5+m1;
				$("#m1").html("￥"+m1);
			}
			if(data[int].paytype==="微信支付"){
				m2=data[int]["clienttotal"];
				m5=m5+m2;
				$("#m2").html("￥"+m2);
				
			}
			if(data[int].paytype==="银行卡支付"){
				m3=data[int]["clienttotal"];
				m5=m5+m3;
				$("#m3").html("￥"+m3);
			}
		}
		$("#m5").html("￥"+m5);
		$("#m6").html(cnum+"人");
	})
	
}


// 当在页面加载的时候就应该把数据查询出来
$(function() {
	console.debug("我在这");
	$.get("/billResport_list?amount=0", function(data) {
		$("#a1").html("￥0");
		$("#a2").html("￥0");
		$("#a3").html("￥0");
		$("#a4").html("￥0");
		$("#a5").html("会员总收入:￥0");
		console.log(data)
		var s1;
		var s2;
		var s3;
		var s4;
		var s5=0;
		if(data[0]){
			 s1 = data[0].paytotal;
			 $("#a1").html("￥" + s1)
			 s5=s5+s1;
		}
		if(data[1]){
			 s2 = data[1].paytotal;
			 s5=s5+s2;
			 $("#a2").html("￥" + s2)
		}
		if(data[2]){
			 s3 = data[2].paytotal;
			 $("#a3").html("￥" + s3);
			 s5=s5+s3;
		}
		if (data[3]) {
			s4 = data[3].paytotal;
			$("#a4").html("￥" + s4);
			 s5=s5+s4;
		}
		$("#a5").html("会员总收入:￥"+s5);
	})
	// ----------------------消费-----------------------------
	
	$.get("/billResport_load?amount=0", function(data) {
		$("#c1").html("￥0");
		$("#c2").html("￥0");
		$("#c3").html("￥0");
		$("#c4").html("￥0");
		$("#c5").html("￥0");
		$("#c6").html("0人");
		/*
		 * $("#m1").html("￥0"); $("#m2").html("￥0"); $("#m3").html("￥0");
		 * $("#m4").html("￥0"); $("#m5").html("￥0"); $("#m6").html("0人");
		 * $("#m7").html("时间");
		 */
		console.log(data)
		var c1;
		var c2;
		var c3;
		var c4;
		var c5=0;
		var c6=0;
		var cnum=0;
		/*
		 * var m1; var m2; var m3; var m4; var m5=0; var m6=0;
		 */
		var carray=new Array(6);
		for ( var int = 0; int < data.length; int++) {
			c6=c6+1;
			cnum=cnum+data[int]["cnum"];
			console.debug(data[int].paytype);
			if(data[int].paytype==="支付宝支付"){
				c4=data[int]["clienttotal"];
				c5=c5+c4;
				$("#c4").html("￥"+c4);
			}
			if(data[int].paytype==="现金支付"){
				c1=data[int]["clienttotal"];
				c5=c5+c1;
				$("#c1").html("￥"+c1);
			}
			if(data[int].paytype==="微信支付"){
				c2=data[int]["clienttotal"];
				c5=c5+c2;
				$("#c2").html("￥"+c2);
				
			}
			if(data[int].paytype==="银行卡支付"){
				c3=data[int]["clienttotal"];
				c5=c5+c3;
				$("#c3").html("￥"+c3);
			}
		}
		$("#c5").html("￥"+c5);
		$("#c6").html(cnum+"人");
	})
	//--------------------会员消费------------------------
	$.get("/billResport_loadm?amount=0", function(data) {
		/*
		 * $("#c1").html("￥0"); $("#c2").html("￥0"); $("#c3").html("￥0");
		 * $("#c4").html("￥0"); $("#c5").html("￥0"); $("#c6").html("0人");
		 */
		
		  $("#m1").html("￥0"); $("#m2").html("￥0"); $("#m3").html("￥0");
		 $("#m4").html("￥0"); $("#m5").html("￥0"); $("#m6").html("0人");
		  $("#m7").html("时间");
		
		console.log(data)
	/*	var c1;
		var c2;
		var c3;
		var c4;
		var c5=0;
		var c6=0;*/
		 var m1=0;
		var m2=0;
		var m3=0; 
		var m4=0;
		var m5=0;
		var m6=0;
		var cnum=0;
		var marray=new Array(7);
		for ( var int = 0; int < data.length; int++) {
			m6=m6+1;
			cnum=cnum+data[int]["cnum"];
			console.debug(data[int].paytype);
			if(data[int].paytype==="支付宝支付"){
				m4=data[int]["clienttotal"];
				m5=m5+m4;
				$("#m4").html("￥"+m4);
			}
			if(data[int].paytype==="现金支付"){
				m1=data[int]["clienttotal"];
				m5=m5+m1;
				$("#m1").html("￥"+m1);
			}
			if(data[int].paytype==="微信支付"){
				m2=data[int]["clienttotal"];
				m5=m5+m2;
				$("#m2").html("￥"+m2);
				
			}
			if(data[int].paytype==="银行卡支付"){
				m3=data[int]["clienttotal"];
				m5=m5+m3;
				$("#m3").html("￥"+m3);
			}
		}
		$("#m5").html("￥"+m5);
		$("#m6").html(cnum+"人");
	})
	
});
