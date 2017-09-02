<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2017/8/6
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试easyui的表单</title>
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/default/easyui.css"><!-- 样式包 -->
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui/themes/icon.css"><!-- 图标的样式 -->
    <script type="text/javascript" src="/js/jquery-easyui/jquery.easyui.min.js"></script><!-- EaysUI核心包 -->
    <script type="text/javascript" src="/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script><!-- 中文包 -->
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <script>
        $(function () {
            $('#productId').dialog({
                title: 'My Dialog',
                width: 500,
                height: 500,
                closed: false,
                cache: false,
                href: 'get_content.php',
                modal: true
            });
        /*    function save() {
                $('#productId').dialog("open")
            }*/
        })
    </script>
</head>
<body>

<%--创建一个库存盘点--%>
<div id="productId">
    <form method="post" id="product_form"  class="layui-form" >
        <table align="center">
            <div class="layui-form-item">
                <label class="layui-form-label">产品名称</label>
                <div class="layui-input-block">
                <input name="name"  style="color: #7e7e7e;width: 300px"  placeholder="请输入产品名称" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">编号</label>
                <div class="layui-input-block">
                    <input name="sn"  style="color: #7e7e7e;width: 300px"  placeholder="请输入产品名称" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">单价</label>
                <div class="layui-input-block">
                    <input name="costPrice"  style="color: #7e7e7e;width: 300px"  placeholder="请输入产品名称" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">产品名称</label>
                <div class="layui-input-block">
                    <input name="name"  style="color: #7e7e7e;width: 300px"  placeholder="请输入产品名称" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">库存数量</label>
                <div class="layui-input-block">
                    <input name="shortnumber"  style="color: #7e7e7e;width: 300px"  placeholder="请输入产品名称" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">单行选择框</label>
                <div class="layui-input-block">
                    <select name="interest" lay-filter="aihao">
                        <option value=""></option>
                        <option value="0">写作</option>
                        <option value="1" selected="">阅读</option>
                        <option value="2">游戏</option>
                        <option value="3">音乐</option>
                        <option value="4">旅行</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">验证日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
                </div>
            </div>
        </table>
    </form>

    <%--创建底部的对话框--%>
    <div id="vip_dialog_bt">
        <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
    </div>
    <script>
        layui.use('form', function(){


        });
    </script>

</div>


</body>
</html>
