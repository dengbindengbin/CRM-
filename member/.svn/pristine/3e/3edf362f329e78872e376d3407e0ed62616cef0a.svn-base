
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



function thisMonth(){
/*	var myDate = new Date();
	var month = myDate.getMonth()+1;
	var year = myDate.getFullYear();
	var day = myDate.getDate()
	var begin = year+'-'+0+month+'-'+0+1;
	 var  day = new Date(year,month,0);   
     var end = year + '-' + 0 + month + '-' + day.getDate();//获取当月最后一天日期 
	console.log(begin);
	console.log(end);
	temp="#thisMonth";*/
	  $("#begin").datebox("setValue", getMonthStartDate());
      $("#end").datebox("setValue", getMonthEndDate());
	  document.getElementById("line_from").submit(function(){
	  });
	  
	  
}

function lastMonths(){
	/*var myDate = new Date()
	var month = myDate.getMonth();
	var year = myDate.getFullYear();
	var day = myDate.getDate()
	var begin = year+'-'+0+month+'-'+0+1;
	var  day = new Date(year,month,0);   
	var end = year + '-' + 0 + month + '-' + day.getDate();//获取当月最后一天日期 
	console.log(begin);
	console.log(end);
	temp="#lastMonth";*/
	 $("#begin").datebox("setValue", getLastMonthStartDate());
     $("#end").datebox("setValue", getLastMonthEndDate());
	document.getElementById("line_from").submit(function(){
	});
	 
}

function thisQuarter(){
	/*var myDate = new Date()
	var month = myDate.getMonth()+1;
	var year = myDate.getFullYear();
	var begin;
	var end
	if (month>=1 && month<=3) {
		begin = year+'-'+01+'-'+01; 
		end = year+'-'+03+'-'+31;
	}
	if (month>=4 && month<=6) {
		begin = year+'-'+04+'-'+30; 
		end = year+'-'+06+'-'+30;
	}
	if (month>=7 && month<=9) {
		begin = year+'-'+07+'-'+01; 
		end = year+'-'+09+'-'+30;
	}
	if (month>=10 && month<=12) {
		begin = year+'-'+10+'-'+01; 
		end = year+'-'+12+'-'+31;
	}
	console.log(begin);
	console.log(end);*/
	 $("#begin").datebox("setValue", getQuarterStartDate());
     $("#end").datebox("setValue", getQuarterEndDate());
	document.getElementById("line_from").submit();
}

function lastQuarter(){
	/*var myDate = new Date()
	var month = myDate.getMonth()+1;
	var year = myDate.getFullYear();
	var begin;
	var end
	if (month-3>=1 && month-3<=3) {
		begin = 2017+'-'+01+'-'+01; 
		end = 2017+'-'+03+'-'+31;
	}
	if (month-3>=4 && month-3<=6) {
		begin = 2017+'-'+04+'-'+30; 
		end = 2017+'-'+06+'-'+30;
	}
	if (month-3>=7 && month-3<=9) {
		begin = 2017+'-'+07+'-'+01; 
		end = 2017+'-'+09+'-'+30;
	}
	if (month-3 <=0) {
		year = year -1;
		begin = year+'-'+10+'-'+01; 
		end = year+'-'+12+'-'+31;
	}
	console.log(begin);
	console.log(end);*/
	  $("#begin").datebox("setValue", getQuarterStartDateLast());
      $("#end").datebox("setValue", getQuarterEndDateLast());
	document.getElementById("line_from").submit();
	// $("#select1 option[value='4']").attr("selected","selected"); 
}
function thisYear(){
	/*var myDate = new Date()
	var year = myDate.getFullYear();
	var begin =  year + '-' + 01 +'-'+01
	var end = year + '-' + 12 +'-'+ 30*/
	 $("#begin").datebox("setValue", getYearStartDate());
    $("#end").datebox("setValue", getYearEndDate());
	document.getElementById("line_from").submit();
	 //$("#select1 option[value='5']").attr("selected","selected"); 
}
function lastYears(){
	var YearStartDate = new Date(nowYear - 1, 0, 1);
	/*var myDate = new Date()
	var year = myDate.getFullYear()-1;
	var begin =  year + '-' + 01 +'-'+01
	var end = year + '-' + 12 +'-'+ 30*/
	 $("#begin").datebox("setValue", getLastYearStartDate());
    $("#end").datebox("setValue", getLastYearEndDate());
	document.getElementById("line_from").submit();
	// $("#select1 option[value='6']").attr("selected","selected"); 
}

//获得某月的天数
function getMonthDays(myMonth) {
    var monthStartDate = new Date(nowYear, myMonth, 1);
    var monthEndDate = new Date(nowYear, myMonth + 1, 1);
    var days = (monthEndDate - monthStartDate) / (1000 * 60 * 60 * 24);
    return days;
};

//获得季度的开始月份
function getQuarterStartMonth(nowMonth1) {
    var quarterStartMonth = 0;
    if (nowMonth1 < 3) {
        quarterStartMonth = 0;
    }
    if (2 < nowMonth1 && nowMonth1 < 6) {
        quarterStartMonth = 3;
    }
    if (5 < nowMonth1 && nowMonth1 < 9) {
        quarterStartMonth = 6;
    }
    if (nowMonth1 > 8) {
        quarterStartMonth = 9;
    }
    return quarterStartMonth;
};


//获得本周的开始日期
function getWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
    return formatDate(weekStartDate);
};

//获得本周的结束日期
function getWeekEndDate() {
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
    return formatDate(weekEndDate);
};

//获得本月的开始日期
function getMonthStartDate() {
    var monthStartDate = new Date(nowYear, nowMonth, 1);
    return formatDate(monthStartDate);
};

//获得本月的结束日期
function getMonthEndDate() {
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));
    return formatDate(monthEndDate);
};

//获得上月开始时间
function getLastMonthStartDate() {
    var lastMonthStartDate = new Date(nowYear, lastMonth, 1);
    return formatDate(lastMonthStartDate);
};

//获得上月结束时间
function getLastMonthEndDate() {
    var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));
    return formatDate(lastMonthEndDate);
};

//获得本季度的开始日期
function getQuarterStartDate() {

    var quarterStartDate = new Date(nowYear, getQuarterStartMonth(nowMonth), 1);
    return formatDate(quarterStartDate);
};

//获得本季度的结束日期
function getQuarterEndDate() {
    var quarterEndMonth = getQuarterStartMonth(nowMonth) + 2;
    var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));
    return formatDate(quarterStartDate);
};

//获得上季度的开始日期
function getQuarterStartDateLast() {

    var quarterStartDate = new Date(nowYear, getQuarterStartMonth(nowMonth - 3), 1);
    return formatDate(quarterStartDate);
};

//获得上季度的结束日期
function getQuarterEndDateLast() {
    var quarterEndMonth = getQuarterStartMonth(nowMonth - 3) + 2;
    var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));
    return formatDate(quarterStartDate);
};

//获得今年的开始日期
function getYearStartDate() {

    var YearStartDate = new Date(nowYear, 0, 1);
    return formatDate(YearStartDate);
};

//获得今年的结束日期
function getYearEndDate() {
    var YearEndDate = new Date(nowYear, 11, 31);
    return formatDate(YearEndDate);
};

//获得去年的开始日期
function getLastYearStartDate() {
    var YearStartDate = new Date(nowYear - 1, 0, 1);
    return formatDate(YearStartDate);
};

//获得去年的结束日期
function getLastYearEndDate() {
    var YearEndDate = new Date(nowYear - 1, 11, 31);
    return formatDate(YearEndDate);
};

//格式化日期：yyyy-MM-dd
function formatDate(date) {
    var myyear = date.getFullYear();
    var mymonth = date.getMonth() + 1;
    var myweekday = date.getDate();

    if (mymonth < 10) {
        mymonth = "0" + mymonth;
    }
    if (myweekday < 10) {
        myweekday = "0" + myweekday;
    }
    return (myyear + "-" + mymonth + "-" + myweekday);
}

function setLoad() {
    // 获取关键字文本框的值
    var begin = $("[name='begin']").val();
    var end = $("[name='end']").val();
    $("#expend_datagrid").datagrid('load', {
    	begin: begin,
    	end: end
    });
}