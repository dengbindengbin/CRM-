<%@ page language="java" contentType="text/html;charset=UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="/static/css/bootstrap.css?v=IW-m2ufkFbmwZUCZ2zv-8lfKGX8QpmWa_ols-L_APnE">
<link rel="stylesheet" type="text/css" href="/static/css/buttons.css" />
<link rel="stylesheet" type="text/css" href="/static/css/component.css" />
<link rel="stylesheet" type="text/css" href= "/static/css/demo.css"/>
<link rel="stylesheet" type="text/css" href= "/static/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href= "/static/css/index.css"/>
<link rel="stylesheet" type="text/css" href= "/static/css/introjs.min.css"/>
<link rel="stylesheet" type="text/css" href= "/static/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href= "/static/css/order.css"/>
<link rel="stylesheet" type="text/css" href= "/static/css/style.css"/>
<link rel="stylesheet" type="text/css" href= "/static/css/iconfont.css"/>
<link rel="stylesheet" type="text/css" href= "/static/font-awesome/css/font-awesome.css"/>
   <link rel="stylesheet" type="text/css" href="/static/css/attr.css" />
   <link href="/static/css/mouse.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/static/css/base.css" />
</head>
<body>
<div class="indexpage">

    <!--主体内容导航 start----->
    <section class="main_box">
        <!--首页的磁贴 start-->
        <div class="citiebox">
            <div class="row">
                <div class="col-xs-3 ">
                    <div class="xos1  misu">
                        <a href="/counter" class="boxsmall bgred hover-shadow"><i class="icon icon-hdd"></i><span>前台收银</span></a>
                        <a href="/stocktaking" onclick="javascript: layer.msg('扫码付款已上线，欢迎使用!~')" class="boxin bgshe"><i class="icon icon-check"></i><span>产品盘点</span></a>
                    </div>
                    <div class="misu xos1  ">
                        <a href="/member#adduser" class="bgbule boxsmall push"><i class="icon icon-user-md"></i><span>新增会员</span></a>
                        <a href="/integralChange" class="bgshe boxsmall  push"><i class="icon icon-edit"></i><span>积分变动</span></a>
                        <a href="/classify" class="bgjls boxsmall  push"><i class="icon icon-list-ul"></i><span>支出分类</span></a>
                    </div>
                </div>
                <div class="col-xs-3 ">
                    <div class="xos2  misu">
                        <a href="/memberPayment" class="boxbig bgqxl"><i class="icon icon-money" ></i><span>会员充值</span></a>
                        <a href="/sale_index" class="boxbig bhybs"><i class="icon icon-signal"></i><span>销售分析</span></a>
                        <a href="/analyze" class="boxbig bgqlve"><i class="icon icon-print"></i><span>支出分析</span></a>
                    </div>
                </div>
                <div class="col-xs-3 ">
                    <div class="xos2  misu">
                        <a href="/purchaseControl" class="boxbig bgtzs"><i class="icon icon-truck" ></i><span>进货管理</span></a>
                    </div>
                    <div class="xos1 misu mr1em">
                        <a href="/dictionary" class="boxsmall bgsls"><i class="icon icon-book"></i><span>数据字典</span></a>
                    </div>
                    <div class="xos1 misu " style="margin-right: 0;">
                        <a href="/employee" class="boxsmall bgszs"><i class="icon icon-table"></i><span>员工管理</span></a>
                    </div>
                    <div class="xos2  misu ">
                        <a href="/expend" class="boxbig bgths"><i class="icon icon-columns"></i><span>支出明细</span></a>
                    </div>
                </div>
                <div class="col-xs-3 ">
                    <div class="xos1  misu ">
                        <a href="/product.do" class="boxin bgsclv"><i class="icon icon-th-list"></i><span>商品列表</span></a>
                        <a href="/productmenu_list" class="boxsmall bgxxzs"><i class="icon icon-list-alt"></i><span>商品分类</span></a>
                    </div>
                </div>
            </div>
        </div>
        <!--首页的磁贴 end---->
    </section>
    <!--主体内容导航 end------->
    <!----脚部 start-------->
    <footer class="index_footer" id="index_footer"></footer>
    <!----脚部 end-------->

</div>

    <style> 
    body{
	width:100%;
	height:100%;
	background:url(/static/images/999.jpg);
	}
</style> 
</body>
</html>