$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var memberPaymentDatagrid,memberPaymentDialog,memberPaymentForm;
	memberPaymentDatagrid = $("#memberPayment_datagrid");
	memberDatagrid = $("#member_datagrid");
	memberMsgDialog = $("#memberMsg_dialog");
	memberPayment = $("#memberPayment_dialog")
    memberPaymentDialogdialog =$("#memberPaymentDialog_dialog");
	/*
	 * 初始化数据表格 
	 */

    $("#memberPayment_datagrid").datagrid({
        fit:true,
        rownumbers:true,
        singleSelect:true,
        striped:true,
        pagination:true,
        fitColumns:true,
        toolbar:'#memberPayment_datagrid_tb'
    });
	memberDatagrid.datagrid({
        url:"/member_list",
        fit:true,
        rownumbers:true,
        singleSelect:true,
        striped:true,
        pagination:true,
        fitColumns:true,
        columns : [ [
           {
            field : 'id',
           title : '会员id',
          width : 100
          },{
         field : 'sn',
         title : '会员卡号',
         width : 100
         },
         {
            field : 'name',
            title : '会员姓名',
            width : 100
        }, {
            field : 'level',
            title : '会员等级',
            width : 100,
            formatter:levelFormatter
        }, {
            field : 'birthday',
            title : '生日',
            width : 100
        }, {
            field : 'totalMoney',
            title : '卡上余额',
            width : 100
        }, {
            field : 'integral',
            title : '会员积分',
            width : 100,
        }, {
            field : 'deadline',
            title : '过期时间',
            width : 100,
        } ] ],
        onDblClickRow:function (rowIndex, rowData) {
            console.log(rowData)
            $("[name=id]").val(rowData.id)
         $("[name=sn]").html(rowData.sn);
         $("[name=name]").html(rowData.name)
         $("[name=level]").html(rowData.level.name)
         $("[name=birthday]").html(rowData.birthday)
         $("[name=totalMoney]").html(rowData.totalMoney)
         $("[name=integral]").html(rowData.integral)
         $("[name=deadline]").html(rowData.deadline)
            $("#memberMsg_dialog").dialog("close")
            var id = rowData.id;
            $("#memberPayment_datagrid").datagrid({
                url:"/memberPayment_list?memberId="+id,
                fit:true,
                rownumbers:true,
                singleSelect:true,
                striped:true,
                pagination:true,
                fitColumns:true,
                toolbar:'#memberPayment_datagrid_tb'
            });
        }
	})
	//弹出会员信息表
    memberMsgDialog.dialog({
        width:800,
        height:500,
        title:"会员信息表",
        closed:true,
	})
	/*
	 * 对页面按钮进行统一监听
	 */
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
	/*
	 * 所有的操作封装到cmdObj对象中,方便管理
	 */
	var cmdObj = {
			reload:function(){
				memberPaymentDatagrid.datagrid("reload");
			}
	}
});
function paytypeFormatter(value,row,index) {

    if (value == 1) {

        return "<font style='color: #CC2222'>现金</font>"

    } else if (value == 2) {

        return "<font style='color: #00ee00'>微信</font>"

    } else if (value == 3) {

        return "<font style='color: #0000FF'>支付宝</font>"

    } else if (value == 4) {

        return "<font style='color: #985f0d'>银行卡</font>"
    }
}
function levelFormatter(value,row,index) {
    if (value.id ==1){
        return value.name
    }
    if (value.id==2){
        return "<font style='color: #ffee10'>"+value.name+"</font>"
    }
    if(value.id==3){
        return "<font style='color: #eefffb'>"+value.name+"</font>"
    }
    if (value.id==4){
        return "<font style='color: #50ff0f'>"+value.name+"</font>"
    }
    if (value.id==5){
        return "<font style='color: #ff568f'>"+value.name+"</font>"
    }
    return "不是会员哦";
}
function openMemberMsg() {
   memberMsgDialog.dialog("open")
}
function saveItem() {
    var sn = $("[name=sn]").html();
    console.log(sn)
    var payMoney = $("[name=payMoney]").val()
    console.log(payMoney)
    var totalMoney =Number($("[name=totalMoney]").html())+Number($("[name=payMoney]").val())+Number($("[name=giveMoney]").val())
    console.log(totalMoney)
    var id = $("[name=id]").val();
    if (sn){
        $("#memberPayment_form").form('submit',{
            url:"/memberPayment_save",
            onSubmit: function(param){
                //额外的提交参数
                param.sn=sn,
                    param.payMoney=payMoney,
                    param.totalMoney=totalMoney,
                    param["member.id"]=id
            },
            success:function(data){
                console.log(data)
                $("#memberPayment_datagrid").datagrid({
                    url:"/memberPayment_listAll?sn="+sn,
                    fit:true,
                    rownumbers:true,
                    singleSelect:true,
                    striped:true,
                    pagination:true,
                    fitColumns:true,
                    toolbar:'#memberPayment_datagrid_tb'
                })
                //修改总金额
                $.post("/memberByPaymentId",{id:id,totalMoney:totalMoney},function () {
                })
                $("[name=totalMoney]").html(totalMoney)
                layer.tips('会员金额改变了，快来看看吧，嘻嘻', $('.tipintegral'), {
                    tips: [1, '#3595CC'],
                    time: 4000
                });
            }

        })
    }else {
        layer.msg('亲，请选择你需要充值的会员', {
            time: 2000, //2s后自动关闭
            btn: ['明白了', '知道了']
        });
    }

}

//重置按钮
function cancelItem() {
    $("#memberPayment_form").form("clear")
    $("#memberPayment_datagrid").datagrid("loadData",{total:0,rows:[]})
    //清空会员的详细信息
    $("[name=sn]").html("")
    $("[name=name]").html("")
    $("[name=level]").html("")
    $("[name=birthday]").html("")
    $("[name=totalMoney]").html("")
    $("[name=integral]").html("")
    $("[name=deadline]").html("")
}
//时间的改变
function TodaySearch(todaySeacher) {
    $("#memberPayment_datagrid").datagrid("load",{
        'amount':todaySeacher}
    )
}
function TodaySearchStree() {
    var now = new Date();
    var nowDay = now.getDate(); //当前日
    var nowMonth = now.getMonth(); //当前月
    var nowYear = now.getFullYear();
    var nowDay = nowDay-3+31;
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
    var StreeeDateStree = nowYear+'-'+'0'+nowMonth+'-'+nowDay;
    var currentTate = formatDate(new Date())
    console.log(StreeeDateStree)
      console.log(currentTate)
    $("#memberPayment_datagrid").datagrid("load",{
        'StreeDate':StreeeDateStree,
        'current':currentTate
      }
    )
}
function TodaySearchseven() {
    var now = new Date();
    var nowDay = now.getDate(); //当前日
    var nowMonth = now.getMonth(); //当前月
    var nowYear = now.getFullYear();
    var nowDay = nowDay-7+31;
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
    var StreeeDateStree = nowYear+'-'+'0'+nowMonth+'-'+nowDay;
    var currentTate = formatDate(new Date())
    console.log(StreeeDateStree)
    console.log(currentTate)
    $("#memberPayment_datagrid").datagrid("load",{
            'StreeDate':StreeeDateStree,
            'current':currentTate
        }
    )
}
