<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/static/css/Richangzhichu.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 	<meta charset="utf-8">
    <title>ECharts</title>
    <link rel="stylesheet" type="text/css" href="/static/css/component.css" />
<%@include file="/static/common/common.jsp"%>
<script type="text/javascript" src="/static/js/linechart.js"></script>
</head>
<body>
<form action="/linechart" method="post" id="line_from">
	<div class="Fxjuzczxtu borbot1">
                        <div class="maxks mat15">
                            <p>开始时间：<i> <em><input type="text" name="begin" id="begin" class="easyui-datebox" /> </em> </i></p>
                            <p>结束时间：<i> <em><input type="text" name="end" id="end" class="easyui-datebox" /></em> </i></p>
                            <p>自定义：<i> <em>
                            <select id="select1">
                            <option id="0"  value="0" onclick="all()">---请选择---</option>
                            <option id="thisMonth"  onclick="thisMonth()" value="1" >本月</option>
                            <option id="lastMonth" onclick="lastMonths()" value="2" >上月</option>
                            <option id="thisQuarter" onclick="thisQuarter()" value="3">本季</option>
                            <option id="lastQuarter" onclick="lastQuarter()" value="4">上季</option>
                            <option id="thisYear" onclick="thisYear()" value="5">今年</option>
                            <option id="lastYears" onclick="lastYears()" value="6">去年</option>
                            </select>
                            </em> </i></p>
                        </div>
                        </div>
                       <input class="act-buts submits" style="color: #FFFFFF" type="submit" value="查询">
                        </form>
<a href="/analyze"><img alt="线形图" src="/linchart.jpg" width="50" height="50"></a>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
   <script type="text/javascript" src="/static/js/echarts-all.js"></script>
    <script type="text/javascript">
 // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('main')); 
    option = {
    	    title : {
    	        text: '支出总额',
    	        subtext: '金额'
    	    },
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	        data:['商品']
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            magicType : {show: true, type: ['line', 'bar']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'category',
    	            data : ${names}//名字
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'支出额度',
    	            type:'bar',
    	            data:${prices},//价格
    	            markPoint : {
    	                data : [
    	                    {type : 'max', name: '最大值'},
    	                    {type : 'min', name: '最小值'}
    	                ]
    	            },
    	            markLine : {
    	                data : [
    	                    {type : 'average', name: '平均值'}
    	                ]
    	            }
    	        }
    	        
    	    ]
    	};
    

    myChart.setOption(option); 
    </script>
    <script type="text/javascript">
    var now = new Date(); //当前日期
    var nowDayOfWeek = now.getDay(); //今天本周的第几天
    var nowDay = now.getDate(); //当前日
    var nowMonth = now.getMonth(); //当前月
    var nowYear = now.getYear(); //当前年
    nowYear += (nowYear < 2000) ? 1900 : 0;

    var lastMonthDate = new Date(); //上月日期
    lastMonthDate.setDate(1);
    lastMonthDate.setMonth(lastMonthDate.getMonth() - 1);
    var lastYear = lastMonthDate.getYear();
    var lastMonth = lastMonthDate.getMonth();
    //月开始
    var monthStartDate = new Date(nowYear, nowMonth, 1);
    //月结束
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));
    //上月开始
    var lastMonthStartDate = new Date(nowYear, lastMonth, 1);
    //上月结束
    var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));
    //本季度开始
	var quarterStartDate = new Date(nowYear, getQuarterStartMonth(nowMonth), 1);
    //本季度结束
     var quarterEndMonth = getQuarterStartMonth(nowMonth) + 2;
    var quarterStartDates = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));
   //  上季度开始 
   var lastquarterStartDate = new Date(nowYear, getQuarterStartMonth(nowMonth - 3), 1);
   //上季度结束
     var lastquarterEndMonth = getQuarterStartMonth(nowMonth - 3) + 2;
    var lastquarterStartDates = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));
   
    //去年开始
    var lastYearStartDate = new Date(nowYear - 1, 0, 1);
    console.log(lastYearStartDate.getFullYear())

    //去年结束
    var lastYearEndDate = new Date(nowYear - 1, 11, 31);
    
    //今年开始
     var YearStartDate = new Date(nowYear, 0, 1);
    
    //今年结束
    var YearEndDate = new Date(nowYear, 11, 31);
    console.log(YearEndDate.getFullYear())
    var beginMonth = ${beginMonth};
    var endMonth = ${endMonth};
    var beginYear = ${beginYear}+1900;
    var endYear = ${endYear}+1900;
    //本月选定
    if(beginYear == YearStartDate.getFullYear() && endYear == YearEndDate.getFullYear() && beginMonth == monthStartDate.getMonth()+1 && endMonth == monthEndDate.getMonth()+1){
    	$("#thisMonth").attr("selected","selected"); 
    }
  //上月选定
    if(beginYear == YearStartDate.getFullYear() && endYear == YearEndDate.getFullYear() && beginMonth == lastMonthStartDate.getMonth()+1 && endMonth == lastMonthEndDate.getMonth()+1){
    	$("#lastMonth").attr("selected","selected"); 
    	
    }
  
    //本季度
    if(beginMonth == quarterStartDate.getMonth()+1 && endMonth == quarterEndMonth+1){
    	
    	$("#thisQuarter").attr("selected","selected"); 
    }
    //上季度
    if(beginMonth == lastquarterStartDate.getMonth()+1 && endMonth == lastquarterEndMonth+1){
    	$("#lastQuarter").attr("selected","selected"); 
    }
    //今年
    if(beginYear == YearStartDate.getFullYear() && endYear == YearEndDate.getFullYear()&& endMonth == YearEndDate.getMonth()+1 && beginMonth == YearStartDate.getMonth()+1){
    	$("#thisYear").attr("selected","selected"); 
    }
    //去年
    if(beginYear == lastYearStartDate.getFullYear() && endYear == lastYearEndDate.getFullYear() && endMonth == lastYearEndDate.getMonth()+1 && beginMonth == lastYearStartDate.getMonth()+1){
    	$("#lastYears").attr("selected","selected"); 
    }
    </script>
</body>
</html>