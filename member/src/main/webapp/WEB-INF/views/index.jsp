<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>后台管理模板</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/static/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/static/css/matrix-style.css" />
<link rel="stylesheet" href="/static/css/matrix-media.css" />
<link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src="/static/js/time.js"></script>
</head>
<body>

	<!--Header-part-->
	<div id="header">
		<h1>
			<a href="dashboard.html">收购BAT</a>
		</h1>
	</div>
	<!--close-Header-part-->
	<!--top-Header-menu-->
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav">
			<li class="dropdown" id="profile-messages">
				<a title="" href="#" data-toggle="dropdown"
					data-target="#profile-messages" class="dropdown-toggle">
					<i class="icon icon-user"></i>
					&nbsp;
					<span class="text">
						欢迎你，
						<shiro:principal property="realname" />
					</span>
					&nbsp;
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a href="#" onclick="openMsg()">
							<i class="icon-bell"></i>
							系统资料
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">
							<i class="icon-check"></i>
							我的任务
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="login.jsp">
							<i class="icon-key"></i>
							退出系统
						</a>
					</li>
				</ul>
			</li>
			<li class="dropdown" id="menu-messages">
				<a href="#" data-toggle="dropdown" data-target="#menu-messages"
					class="dropdown-toggle">
					<i class="icon icon-envelope"></i>
					&nbsp;
					<span class="text">我的消息</span>
					&nbsp;
					<span class="label label-important">4</span>
					&nbsp;
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li>
						<div style="color: blue;"></div>
					</li>
					<li>
						<a class="sAdd" title="" href="#">
							<i class="icon-plus"></i>
							新消息
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a class="sInbox" title="" href="#">
							<i class="icon-envelope"></i>
							收件箱
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a class="sOutbox" title="" href="#">
							<i class="icon-arrow-up"></i>
							发件箱
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a class="sTrash" title="" href="#">
							<i class="icon-trash"></i>
							回收站
						</a>
					</li>
				</ul>
			</li>
			<li class="">
				<a title="" href="/counter">
					<i class="icon icon-hdd"></i>
					<span class="text">&nbsp;前台收银</span>
				</a>
			</li>
			<li class="">
				<a title="" href="login.html">
					<i class="icon icon-share-alt"></i>
					<span class="text">&nbsp;退出系统</span>
				</a>
			</li>
		</ul>
	</div>
	<!--close-top-Header-menu-->

	<!--start-top-serch-->
	<div id="search">
		<input type="text" placeholder="搜索..." />
		<button type="submit" class="tip-bottom" title="Search">
			<i class="icon-search icon-white"></i>
		</button>
	</div>
	<!--close-top-serch-->

	<!--sidebar-menu-->
	<div id="sidebar" style="OVERFLOW-Y: auto; OVERFLOW-X: hidden;">
		<ul>
			<li class="submenu active">
				<a class="menu_a" link="main.jsp">
					<i class="icon icon-home"></i>
					<span>控制面板</span>
				</a>
			</li>

			<li class="submenu">
				<a href="#">
					<i class="icon icon-cog"></i>
					<span>系统管理</span>
					<span class="label label-important">4</span>
				</a>
				<ul>
					<li>
						<a class="menu_a" link="/employee">
							<i class="icon icon-caret-right"></i>
							员工管理
						</a>
					</li>
					<li>
						<a class="menu_a" link="/department">
							<i class="icon icon-caret-right"></i>
							部门管理
						</a>
					</li>
					<li>
						<a class="menu_a" link="/dictionary">
							<i class="icon icon-caret-right"></i>
							数据字典
						</a>
					</li>
					<li>
						<a class="menu_a" link="/role">
							<i class="icon icon-caret-right"></i>
							角色管理
						</a>
					</li>
				</ul>
			</li>

			<li class="submenu">
				<a href="#">
					<i class="icon icon-user"></i>
					<span>会员管理</span>
					<span class="label label-important">3</span>
				</a>
				<ul>
					<li>
						<a class="menu_a" link="/member">
							<i class="icon icon-caret-right"></i>
							会员列表
						</a>
					</li>
					<li>
						<a class="menu_a" link="/memberPayment">
							<i class="icon icon-caret-right"></i>
							会员充值
						</a>
					</li>
					<li>
						<a class="menu_a" link="/integralChange">
							<i class="icon icon-caret-right"></i>
							积分变动
						</a>
					</li>
				</ul>
			</li>

			<li class="submenu">
				<a href="#">
					<i class="icon icon-th"></i>
					<span>日常支出</span>
					<span class="label label-important">3</span>
				</a>
				<ul>
					<li>
						<a class="menu_a" link="/expend">
							<i class="icon icon-caret-right"></i>
							支出明细
						</a>
					</li>
					<li>
						<a class="menu_a" link="/analyze">
							<i class="icon icon-caret-right"></i>
							支出分析
						</a>
					</li>
					<li>
						<a class="menu_a" link="/classify">
							<i class="icon icon-caret-right"></i>
							支出分类
						</a>
					</li>
				</ul>
			</li>

			<li class="submenu">
				<a href="#">
					<i class="icon icon-signal"></i>
					<span>智能分析</span>
					<span class="label label-important">3</span>
				</a>
				<ul>
					<li>
						<a class="menu_a" link="/sale_index">
							<i class="icon icon-caret-right"></i>
							销售分析
						</a>
					</li>
					<li>
						<a class="menu_a" link="/productResport">
							<i class="icon icon-caret-right"></i>
							产品分析
						</a>
					</li>
					<li>
						<a class="menu_a" link="/memberReport">
							<i class="icon icon-caret-right"></i>
							会员分析
						</a>
					</li>
				</ul>
			</li>

			<li class="submenu">
				<a href="#">
					<i class="icon icon-road"></i>
					<span>库存管理</span>
					<span class="label label-important">4</span>
				</a>
				<ul>
					<li>
						<a class="menu_a" link="/purchaseControl">
							<i class="icon icon-caret-right"></i>
							进货管理
						</a>
					</li>
					<li>
						<a class="menu_a" link="/stocktaking">
							<i class="icon icon-caret-right"></i>
							产品盘点
						</a>
					</li>
					<li>
						<a class="menu_a" link="/stockTransShipment">
							<i class="icon icon-caret-right"></i>
							库存调拨
						</a>
					</li>
				</ul>
			</li>

			<li class="submenu">
				<a href="#">
					<i class="icon icon-stop"></i>
					<span>商品管理</span>
					<span class="label label-important">2</span>
				</a>
				<ul>
					<li>
						<a class="menu_a" link="/product.do">
							<i class="icon icon-caret-right"></i>
							商品列表
						</a>
					</li>
					<li>
						<a class="menu_a" link="/productmenu_list">
							<i class="icon icon-caret-right"></i>
							商品分类
						</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
	<!--sidebar-menu-->

	<!--main-container-part-->
	<div id="content">
		<!--breadcrumbs-->
		<div id="content-header" style="color: black;">
			<div id="breadcrumb" style="color: black;">
				<a href="/index" title="Go to Home" class="tip-bottom">
					<i class="icon-home"></i>
					Home
				</a>
				<iframe style="background-color:;" width="250" scrolling="no"
					height="20" frameborder="0" allowtransparency="true"
					src="http://i.tianqi.com/index.php?c=code&id=34&icon=1&num=3"></iframe>
				<span id="time"></span>
			</div>
		</div>
		<!--End-breadcrumbs-->
		<iframe src="main.jsp" id="iframe-main" frameborder='0'
			style="color: black; width: 100%;"></iframe>
	</div>
	<!--end-main-container-part-->

	<script src="/static/js/excanvas.min.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.7.1.js"></script>
	<script src="/static/js/jquery.ui.custom.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/staticjs/nicescroll/jquery.nicescroll.min.js"></script>
	<script src="/static/js/matrix.js"></script>
	<script type="text/javascript">
		//初始化相关元素高度
		function init() {
			$("body").height($(window).height() - 80);
			$("#iframe-main").height($(window).height() - 90);
			$("#sidebar").height($(window).height() - 50);
		}

		$(function() {
			init();
			$(window).resize(function() {
				init();
			});
		});

		// This function is called from the pop-up menus to transfer to
		// a different page. Ignore if the value returned is a null string:
		function goPage(newURL) {
			// if url is empty, skip the menu dividers and reset the menu selection to default
			if (newURL != "") {
				// if url is "-", it is this page -- reset the menu:
				if (newURL == "-") {
					resetMenu();
				}
				// else, send page to designated URL            
				else {
					document.location.href = newURL;
				}
			}
		}

		// resets the menu selection upon entry to this page:
		function resetMenu() {
			document.gomenu.selector.selectedIndex = 2;
		}

		// uniform使用示例：
		// $.uniform.update($(this).attr("checked", true));
	</script>
	<script type="text/javascript" src="/static/plugins/layer/layer.js"></script>
	<script type="text/javascript">
		function openMsg() {
			layer
					.open({
						type : 1,
						title : false //不显示标题栏
						,
						closeBtn : false,
						area : '300px;',
						shade : 0.8,
						id : 'LAY_layuipro' //设定一个id，防止重复弹出
						,
						resize : false,
						btn : [ '我明白了' ],
						btnAlign : 'c',
						moveType : 1 //拖拽模式，0或者1
						,
						content : '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">'
								+ '亲，欢迎光临德客会员管理系统;'
								+ '<br>德客软件专注会员管理系统软件研发,为店铺商家提供前台收银,会员管理,商品管理,订单管理,智能分析,'
								+ '微信商城,会员积分,微信会员卡等功能。系统功能强大、操作简便、'
								+ '<br/>是店铺商家会员管理、会员营销、库存管理、'
								+ '微信会员卡管理、收银记账、会员积分管理、连锁会员管理的必备管理工具。</div>',
						success : function(layero) {
							var btn = layero.find('.layui-layer-btn');
							btn.find('.layui-layer-btn0').attr({
								target : '_blank'
							});
						}
					});
		}
		function openMemberBirsdayMsg() {
			layer.msg("nihs")
		}
	</script>
</body>
</html>