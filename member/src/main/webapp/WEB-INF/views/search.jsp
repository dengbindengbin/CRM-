<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/static/css/demo.css">
	<%@include file="/static/common/common.jsp" %>
	<script type="text/javascript"
	src="/static/js/search.js"></script>
<title>Insert title here</title>
</head>
<body>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:100%;max-width:400px;padding:15px 30px;">
        <input class="easyui-searchbox" data-options="prompt:'请输入查询信息',menu:'#mm',searcher:doSearch" style="width:100%">
    </div>
    <div id="mm">
        <div data-options="name:'all',iconCls:'icon-ok'">按会员信息</div>
        <div data-options="name:'sports'">按流水单号信息</div>
        <div data-options="name:'sports'">按商品信息</div>
    </div>
 
</body>
</html>