$(function () {

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


    $("#cc").combobox({
        onSelect: function (record) {
            //本月
            if (record.value == 1) {
                $("#begin").datebox("setValue", getMonthStartDate());
                $("#end").datebox("setValue", getMonthEndDate());
                setLoad();
            }
            //本周
            else if (record.value == 2) {
                $("#begin").datebox("setValue", getWeekStartDate());
                $("#end").datebox("setValue", getWeekEndDate());
                setLoad();
            }
            //上月
            else if (record.value == 3) {
                $("#begin").datebox("setValue", getLastMonthStartDate());
                $("#end").datebox("setValue", getLastMonthEndDate());
                setLoad();
            }
            //本季度
            else if (record.value == 4) {
                $("#begin").datebox("setValue", getQuarterStartDate());
                $("#end").datebox("setValue", getQuarterEndDate());
                setLoad();
            }
            //上季度
            else if (record.value == 5) {
                $("#begin").datebox("setValue", getQuarterStartDateLast());
                $("#end").datebox("setValue", getQuarterEndDateLast());
                setLoad();
            }
            //今年
            else if (record.value == 6) {
                $("#begin").datebox("setValue", getYearStartDate());
                $("#end").datebox("setValue", getYearEndDate());
                setLoad();
            }
            //去年
            else if (record.value == 7) {
                $("#begin").datebox("setValue", getLastYearStartDate());
                $("#end").datebox("setValue", getLastYearEndDate());
                setLoad();
            }
        }
    })

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

})




