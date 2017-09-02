$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var integralChangeDatagrid,integralChangeDialog,integralChangeForm,integralChangeMsg;
	integralChangeDatagrid = $("#integralChange_datagrid");
	integralChangeDialog = $("#integralChange_dialog");
	integralChangeForm = $("#integralChange_form");
	integralChangeMsg = $("#integralChangeMsg_dialog");
	integralChangeMsgDatagrid = $("#integralChangeMsg_datagrid")
	/*
	 * 初始化数据表格 
	 */
	integralChangeDatagrid.datagrid({
		url:"/integralChange_list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,

		toolbar:'#integralChange_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	integralChangeDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#integralChange_dialog_bt'
	});

    integralChangeMsg.dialog({
        width:700,
        height:500,
        title:"会员信息表",
        closed:true,
	})
    integralChangeMsgDatagrid.datagrid({
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
                title : '当前积分',
                width : 100,
            }, {
                field : 'usedintegral',
                title : '使用积分',
                width : 100,
            }, {
                field : 'deadline',
                title : '过期时间',
                width : 100,
            } , {
                field : 'totalMoney',
                title : '消费金额',
                width : 100,
            },] ],
        onDblClickRow:function (rowIndex, rowData) {
			$("[name=id]").val(rowData.id)
			$("[name=sn]").val(rowData.sn);
            $("[name=name]").val(rowData.name);
            $("[name=level]").val(rowData.level.id);
            $("[name=birthday]").val(rowData.birthday);
            $("[name=totalMoney]").val(rowData.totalMoney);
            $("[name=integral]").val(rowData.integral);
            $("[name=usedintegral]").val(rowData.usedintegral);
            $("[name=deadline]").val(rowData.deadline);
            $("[name=totalConsume]").val(rowData.totalConsume);
            $("#integralChangeMsg_dialog").dialog("close")
            var id = rowData.id;
            $("#integralChange_datagrid").datagrid({
                url:"/integralChange_list?memberId="+id,
                fit:true,
                rownumbers:true,
                singleSelect:true,
                striped:true,
                pagination:true,
                fitColumns:true,
                toolbar:'#integralChange_datagrid_tb'
            });
        } 
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
				integralChangeDatagrid.datagrid("reload");
			},

	}
});
function openMemberMsg () {
	$("#integralChangeMsg_dialog").dialog("open")
}
function memberFormatter(value,row,index) {
	if (value){
		return value.name
	}
	return value
}
function levelFormatter(value,row,index) {
	if (value){
		return value.name
	}
	return value
}
function remarkFormatter(value,row,index) {
     console.log(arguments)
    if (row.type == 0) {

        return "<font style='color: #CC2222'>订单消费</font>"

    }
    if (row.type== 1) {

        return "<font style='color: #00ee00'>扣除积分</font>"
    }
}
function typeFormatter(value,row,index) {
	if (value==1){
        return "<font style='color: #27ee20'>扣除</font>"
	}
	if (value==0){
        return "<font style='color: #CC2222'>增加</font>"
    }
	return row
}
function confirm() {
	if ($("[name=sn]").val().length==0){
		layer.msg("请选择会员后再进行积分操作！");
		return;
	}
    var index = layer.confirm('确认要操作该会员积分吗？', {
        btn: ['确定','我考虑一下吧'] //按钮
    }, function(){
        var id= $("[name=id]").val();
        var sn = $("[name=sn]").val();
        var level = $("[name=level]").val();
        var integral =  Number($("[name=integral]").val())+Number($("[name=changecount]").val())
        console.log(level)
        $("#integralChangeyment_form").form('submit',{
            url:"/integralChange_save",
            onSubmit:function (param) {
                param["member.id"]=id
                param.sn=sn
                param["level.id"]=level

            },
            success:function (data) {
				$("#integralChange_datagrid").datagrid("load",{})
                //重新发送sql去修改总积分
                $.post("/IntegralChangeByPaymentId",{id:id,integral:integral},function () {
                })
                //修改总积分
                $("[name=integral]").val(integral)
                layer.tips('积分变动哦，快来看看吧，嘻嘻', $('.tipintegral'), {
                    tips: [1, '#3595CC'],
                    time: 4000
                });
            }
		})
        layer.msg('操作成功了', {icon: 1});
    }, function(){
        layer.close(index)
    });
}
function RemoveIntegral() {
    if ($("[name=sn]").val().length==0){
        layer.msg("请选择会员后再进行积分操作！");
        return;
    }
    //发送ajax请求来清除该会员的积分
    var index = layer.confirm('确认要清除该会员积分吗？', {
        btn: ['确定','我考虑一下吧'] //按钮
    }, function(){
        var id= $("[name=id]").val();
        $("#integralChangeyment_form").form('submit',{
            url:"/member_deleteIntegral?id="+id,
            success:function (data) {
                $("[name=integral]").val(0)
                layer.tips('积分清零，快来看看吧，嘻嘻', $('.tipintegral'), {
                    tips: [1, '#3595CC'],
                    time: 4000
                });
            }
        })
        layer.msg('操作成功了', {icon: 1});
    }, function(){
        layer.close(index)
    });
}
//时间的改变
function TodaySearch(todaySeacher) {
    $("#integralChange_datagrid").datagrid("load",{
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
    $("#integralChange_datagrid").datagrid("load",{
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
    $("#integralChange_datagrid").datagrid("load",{
            'StreeDate':StreeeDateStree,
            'current':currentTate
        }
    )
}

