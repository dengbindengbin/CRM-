<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2017/8/4
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试layui的表单元素</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
</head>
<body>

<form method="post" id="#" class="layui-form">
    <table align="center">
        <tr>
            <td>产品名称</td>
            <td><input name="name" readonly="true" style="color: #7e7e7e" class="layui-input"></td>
            <td>编号</td>
            <td><input name="sn" readonly="true" style="color: #7e7e7e" class="layui-input"></td>
        </tr>
        <tr>
            <td>单价</td>
            <td><input name="costPrice" readonly="true" style="color: #7e7e7e" class="layui-input"></td>
            <td>库存数量</td>
            <td><input type="text" name="shortnumber" readonly="true" style="color: #7e7e7e" class="layui-input"></td>
        </tr>
        <tr>
            <td>盘点数</td>
            <td><input type="text" name="allNumber" class="layui-input"></td>
        </tr>
    </table>
</form>
</body>
</html>
