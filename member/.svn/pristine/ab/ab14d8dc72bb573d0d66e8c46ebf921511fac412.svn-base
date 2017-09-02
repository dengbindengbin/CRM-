<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>每日销售明细管理</title>
<%@include file="/static/common/common.jsp" %>
<script type="text/javascript" src="/static/js/reportFrom.js"></script>
</head>
<body>

<div id="tt" class="easyui-tabs" style="width:900px;height:850px;" data-options="closable:true,fit:true">   
    <div title="销售报表" style="padding:20px;display:none;" data-options="iconCls:'icon-reload',closable:false,fit:true">   
     <!--     <iframe id="ff" frameborder=0 height='20%' width='100%' src="/search_index"></iframe>      -->
         <iframe id="dd" frameborder=0 height='100%' width='100%' src="/stockOutcomeBillItem"></iframe>     
    </div>   
    <div title="充值报表" data-options="iconCls:'icon-reload',closable:false,fit:true" style="padding:20px;display:none;">   
         <iframe id="dd" frameborder=0 height='100%' width='100%' src="/recharge"></iframe> 
    </div>   
    <div title="每日对账单" data-options="iconCls:'icon-reload',closable:false,fit:true" style="padding:20px;display:none;">   
         <iframe id="dd" frameborder=0 height='100%' width='100%' src="/billResport"></iframe> 
    </div>   
</div>
  <!--   <script type="text/javascript">
        $(function(){
            var tabs = $('#tt').tabs().tabs('tabs');
            for(var i=0; i<tabs.length; i++){
                tabs[i].panel('options').tab.unbind().bind('mouseenter',{index:i},function(e){
                    $('#tt').tabs('select', e.data.index);
                });
            }
        });
    </script> -->
</body>
</html>