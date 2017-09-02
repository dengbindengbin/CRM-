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
<%@include file="/static/common/common.jsp"%>
</head>
<body>
                  <div class="Fxjuzczxtu borbot1">
                        <div class="maxks mat15">
                            <p>本日支出：<i>¥ <em>${day} </em> 元</i></p>
                            <p>本月支出：<i>¥ <em>${mouth} </em> 元</i></p>
                            <p>本年支出：<i>¥ <em>${year} </em> 元</i></p>
                        </div>
                        </div>
<a href="/linechart"><img alt="柱状图" src="/columndiagram.jpg" width="50px" height="50px"></a>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
   <script type="text/javascript" src="/static/js/echarts-all.js"></script>
    <script type="text/javascript">
 // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('main')); 
    option = {
    	    title : {
    	        text: '年度账单',
    	        subtext: '金额'
    	    },
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	        data:['平均金额']
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
    	            boundaryGap : false,
    	            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value',
    	            axisLabel : {
    	                formatter: '{value} 元'
    	            }
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'本月支出统计',
    	            type:'line',
    	            data:${list},
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
        function pp() {
        	console.log(${list})
        }
        pp();
    </script>
</body>
</html>