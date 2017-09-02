<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.accountClass{
margin:0 0 0 100px ;
 float:left; 
 display:inline;
}
.pClass{
margin:0.3em 0; 
}
.divProduct {
	border: none;
	width: 90px;
	height: 100px;
	float: left;
	text-align: center
}
.spanDis{margin:0 70px;}
.spanDis2{margin:0 75px;}
.inputClass{
	width:70px;
	height: 15px;
}
.divClass {
	margin:10px; 
	float:left; 
	display:inline;
	border: 1px solid #000;
	width: 200px;
	height: 100px;
	float: left;
	text-align: center
}

.divCount {
	border: 0px solid #000;
	width: 333px;
	height: 410px;
	text-align: center
}

.divTotalCount {
	border: 0px solid #000;
	width: 333px;
	height: 140px;
	text-align: center
}

.divCountBtn1 {
	border-right: 0.5px solid #000;
	width: 160px;
	height: 60px;
	float: left;
	text-align: center
}
.divCountBtn {
	border: 0.5px solid #000;
	width: 333px;
	height:60px;
	float: left;
	text-align: center
}

.divCountBtn2 {
	border: 0px solid #000;
	width: 169px;
	height: 60px;
	float: left;
	text-align: center
}

.divImg {
	border: none;
	width: 110px;
	height: 100px;
	float: left
}

.divDate {
	border: 0.00px solid #000;
	width: 333px;
	height: 100px;
	float: left
}

.div-inline {
	width: 300px;
	height: 300px;
	float: left
}

.pSize {
	font-size: 18px;
}
.liClassNone {
	width: 240px;
	height: 100px;
	list-style:none;
	display:none;
	border-bottom:1px black dashed;
	font-size:12px
}
.liClassShow {
	width: 240px;
	height: 100px;
	list-style:none;
	border-bottom:1px black dashed;
	font-size:12px
}
.liClassCount {
	width: 290px;
	height: 100px;
	list-style:none;
}
.ulClass {
	width: 290px;
}
.divCenter {
	font-size: 18px;
	text-align:center;
}

.aStyle{  
	border-style: solid;
       border-color:  #909090 ;  
	width: 147px;
	height: 30px;
	  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp"%>

<script type="text/javascript" src="/static/js/counter.js"></script>
</head>
<body>
<body class="easyui-layout" style="text-align: center">

	<div data-options="region:'west',split:false"
		style="width: 360px; text-align: center">
		<div id="" class="divDate">
			<p class="pSize" style="text-align: left; margin-left: 10px">
				销售时间:<span id="year">12</span>年<span id="month">12</span>月<span
					id="day">12</span>日 <span id="hour">12</span>:<span id="minute">12</span>:<span
					id="second">12</span>
			</p>
			<p class="pSize" style="text-align: left; margin-left: 10px">
				每日单号:<span id="year1">12</span><span id="month1">12</span><span
					id="day1">12</span>
			</p>
		</div>
		<!-- 添加结算商品的列表 -->
		<!-- ------------------------------模板li----------------------- -->
		<div id="panelProduct" class="divCount">
			<li  id="copyLi" class="liClassNone" onclick="change(this)" >
					
					<div class="naerigh">
						<p  style="text-align:left"><span name="productName" ondblclick="removeProduct(this)">ooxxooxxooxx</span><span class="spanDis">&nbsp;&nbsp;&nbsp;
						<!-- <a href="javascript:removeProduct(this)">删除</a> --></span></p>
						<p  style="text-align:left">
							<span name="productSn">4534546</span>
							<span class="spanDis">数量 &nbsp; <input name="productNums" style="width:80px;"   
                            required="required">  </span>
						</p>
						<input name="productId" type="hidden" value="-1">
						<p style="text-align:left">
							<span >¥<text name="proPrice">
								0.00</text>
								</span><span class="spanDis">¥ <text name="totalPrice" >0.00</text></span>
						</p>
					</div>
					</li>
			
			<ul id="productUl" class="ulClass">
				
		<!-- ------------------------------模板li----------------------- -->
			<!-- 	<li  class="liClassShow" >
					<div class="naerigh">
						<p name="productName" style="text-align:left">衬衫</p>
						<p  style="text-align:left">
							<span name="productSn">4534546</span>
							<span class="spanDis">数量&nbsp; <input   name="productNums"  class="easyui-numberspinner" style="width:80px;"   
        required="required" data-options="value:1,min:1,editable:true"> </span>
						</p>
						<p style="text-align:left">
							<span >¥<text name="proPrice" >
								50.00</text>
								</span><span class="spanDis">¥ <text name="totalPrice" > 150.00</text></span>
						</p>
					</div>
					</li> -->
			
				
			</ul>



		</div>
		<!-- 进行结算的模块 -->
		<div class="divTotalCount">
			<ul id="accountUl" class="ulClass">
				<li   class="liClassCount" >
					<div class="">
							<p class="pClass" style="text-align:left">
							<input id="cId"  type="hidden" value=""/>
							<span >会员:<span id="menName"></span></span>
							<span class="spanDis2">余额&nbsp;<input id="men" readonly="readonly" type="text" class="inputClass" ></input>  </span>
						</p>
						<p  class="pClass"  style="text-align:left">
						<span >合计:</span> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="spanDis2">¥&nbsp;<input id="count"  type="text"  readonly="readonly"  class="inputClass"  ></input>  
								</span></p>
						<p class="pClass" style="text-align:left">
							
							<span >折扣</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="spanDis2"><input id="dis"  type="text" class="inputClass" ></input>  </span>
						</p>
						<p  class="pClass" style="text-align:left">
						<span >应收:</span> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="spanDis2">¥&nbsp;<input id="real"  readonly="readonly"  type="text" class="inputClass" ></input>  
								</span></p>
					</div>
					</li>
		

				
			</ul>
			

		</div>
		<!-- 结算的按钮 -->
		<div class="divCountBtn divCenter" >
		
		
		<div class="divCountBtn1 divCenter" onclick="selectMember()">选择会员</div>
		
		<div class="divCountBtn2 divCenter" onclick="squareAccounts()">结算</div>
		</div>

	</div>
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
		<div id="tt" class="easyui-tabs" style="width: 500px; height: 250px;"
			data-options="fit:true, border:false">
			<div title="全部商品" style="padding: 20px; display: none;"
				data-options="closable:false">
				
				
				<!-- ----------循环迭代的数据--------------- -->
				
				<c:forEach  items="${proList}" var="product" varStatus="status">
				<div id="product${product.id}"  class="divClass" onMouseUp="addToCar(this)" onMouseDown="changeBack(this)"
				data-url="${product.file}" 
				data-proclassid="${product.id}"
				data-sn="${product.sn}" 
				data-name="${product.name}"
				data-price="${product.price}"
				data-storage="${product.stock}">
				
				
					<div class="divImg">
						<img alt="${product.name}" src="${product.file}" width="110px" height="100px">
					</div>
					<input name="productId"  type="hidden" value="${product.id}">
					<div class="divProduct">

						<p >
							<span >${product.name}</span>
						</p>
						<div class="spec"></div>
						<div >
							¥<span >${product.price}</span>元
							<div >
								<input type="hidden" value="${product.stock}" /> <i
									>库-</i><span id="stock">${product.stock}</span>
							</div>
						</div>
					</div>

				</div>
				</c:forEach>
				<!-- ----------循环迭代的数据--------------- -->
				
				
				
				
			
	
			</div>




		</div>

	</div>


<!-- 定义一个dialog 里面包裹着datagrid，存储着会员的信息信息 -->
        <div id="memberMsg_dialog">
            <!--  里面包裹着datagrid，存储着会员的信息信息 -->
            <table id="member_datagrid" >

            </table>
        </div>

<!-- 定义一个结算对话框 -->
<div id="counter_dialog">
	<form id="accountForm" action="">
		<div id="accountDiv" class="accountClass"></div>
		<div class="accountClass">
		<ul id="accountUl" class="ulClass">
		<p>
		<span>支付方式:</span>
		<span  class="spanDis2">
		<select id="payWay" class="easyui-combobox"  style="width:80px;"
		data-options="panelHeight:'auto'"
		>   
   		
    	<option value="微信支付">微信支付</option>   
    	<option value="支付宝支付">支付宝支付</option>
    	<option value="现金支付">现金支付</option>      
    	<option value="信用卡支付">信用卡支付</option>   
		</select>
		</span>  
		</p>
		</ul>
		</div>
		
	</form>
</div>

<!-- 結算按钮  -->
<div id="ct">
<a href="javascript:insert()" class="easyui-linkbutton" data-options="plain:true">埋单</a>
</div>
</body>





</body>
</html>