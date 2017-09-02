$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
    var memberDatagrid,memberDialog,memberForm;
    memberDatagrid = $("#member_datagrid");
    memberDialog = $("#member_dialog");
    memberForm = $("#member_form");
    memberTree = $("#member_tree");
    setTingDialog = $("#setTing_dialog");
	/*
	 * 初始化数据表格
	 */
    memberDatagrid.datagrid({
        url:"/member_list",
        fitColumns : true,
        striped : true,
        fit : true,
        pagination : true,
        singleSelect : true,
        toolbar:'#member_datagrid_tb',
        onBeforeLoad:function () {
            $.get("/member_load",function (data) {
                console.log(data)
                $("#bircount").html(data.memberName)
                $("#usercount").html(data.totalMembers)
                $("#recelivableCount").html(data.totalAmount)
            })
        },
        onClickRow : function(rowIndex, rowData) {
            // 如果当前行的状态是离职,就禁用编辑和离职按钮
            if (!rowData.state) {
                // 禁用按钮
                $("#emp_tb_cs").linkbutton('disable');
                $("#emp_tb_edit").linkbutton('disable');
            } else {
                // 显示按钮
                $("#emp_tb_cs").linkbutton('enable');
                $("#emp_tb_edit").linkbutton('enable');
            }
        },
        onDblClickCell:function (index,field,value) {
            var rowData = memberDatagrid.datagrid("getSelected");
            var id = rowData.id;
            console.log(rowData)
            if (field=='phone'){
                var index = layer.prompt({
                    title: '输入与该类型的数据匹配，能够快速修改哦',
                    formType: 0 //prompt风格，支持0-2，
                }, function(date) {
                    //发送sql更改数据
                 /*   var phone = $.ajax({
                        url: "/memberUpdatePhone?phone="+date+'&id='+id,
                        async: false //同步
                    }).responseText;*/
                 $.post("/memberUpdatePhone",{id:id,phone:date},function () {
                    $("#member_datagrid").datagrid("reload")
                     layer.msg("修改电话号码成功了")
                 })
                    layer.close(index)
                })
            }
        }
    });

    $("#member_datagrid").datagrid("hideColumn",'qq')
    $("#member_datagrid").datagrid("hideColumn",'totalMoney')
    $("#member_datagrid").datagrid("hideColumn",'deadline')
    $("#member_datagrid").datagrid("hideColumn",'remark')
	/*
	 * 初始化新增/编辑对话框
	 */
    memberDialog.dialog({
        width:600,
        height:400,
        closed:true,
        buttons:'#member_dialog_bt'
    });
    //列表显示的dialog
    setTingDialog.dialog({
        width:150,
        height:200,
        title:"列表显示",
        closed:true,
        buttons:'#setTing_dialog_bt'

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
        add:function(){
            memberForm.form("clear");
            memberDialog.dialog("setTitle","新增");
            memberDialog.dialog("open");
        },
        edit:function(){
            var rowData = memberDatagrid.datagrid("getSelected");
            console.log(rowData)
            if(rowData){
                memberForm.form("clear");
                memberDialog.dialog("setTitle","编辑");
                memberDialog.dialog("open");
                if(rowData.level){
                    rowData["level.id"] = rowData.level.id;}
                if(rowData.referrer){
                    rowData["referrer.id"] = rowData.referrer.id;}
                     memberForm.form("load",rowData);
            }else{
                $.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
            }
        },
        del:function(){
           var rowData = memberDatagrid.datagrid("getSelected");
          var index =   layer.confirm('你确定要删除数据', {
                btn: ['确定','我考虑一下吧'] //按钮
            }, function(){
                $.get("/member_delete?memberId="+rowData.id,function(data){
                    if(data.success){
                        layer.msg('删除成功了', {icon: 1});
                            memberDatagrid.datagrid("reload");
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                },"json")
            }, function(){
              layer.close(index)
            });
       /*     if(rowData){
                $.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
                    if(yes){
                        $.get("/member_delete?memberId="+rowData.id,function(data){
                            if(data.success){
                                $.messager.alert("温馨提示",data.msg,"info",function(){
                                    memberDatagrid.datagrid("reload");
                                });
                            }else{
                                $.messager.alert("温馨提示",data.msg,"error");
                            }
                        },"json")
                    }
                });
            }else{
                $.messager.alert("温馨提示","请选择需要删除的数据!","warining");
            }*/
        },
        reload:function(){
            memberDatagrid.datagrid('load', {});
           // $("#sss1").searchbox("options").prompt="";
        },
        save:function(){
            var url;
            var idVal = $("[name='id']").val();
            if(idVal){
                url = "/member_update"
            }else{
                url = "/member_save";
            }
            memberForm.form("submit",{
                url:url,
                onSubmit:function () {
                    //随机成功会员卡号
                    var billNumber=new Date()
                    var yyyy = billNumber.getFullYear();
                    var MM = billNumber.getMonth()+1;
                    var dd = billNumber.getDate();
                    var hh=billNumber.getHours();
                    var mm=billNumber.getMinutes();
                    var number = Math.round(Math.random()*10000);
                    var iHTML = yyyy +""+ MM +"" + dd+"" + hh+"" + mm+""+number;
                    $('[name=sn]').val(iHTML);
                    //计算消费总金额
                },
                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            memberDialog.dialog("close");
                            memberDatagrid.datagrid("reload");
                        });
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                }
            });
        },
        cancel:function (){
            memberDialog.dialog("close");
        },cancelItem:function () {
            setTingDialog.dialog("close")
        }
        ,
        setTing:function () {
            //打开对话框
            setTingDialog.dialog("open")
        },exportFile:function () {
            window.location.href="/member_export";
        },state:function () {
           var rowData = memberDatagrid.datagrid("getSelected");
           var id =  rowData.id;
           var state = rowData.state;
           var stateMsg = $("#stateId").html()
            if (rowData){
                var index =  layer.confirm('您确认要'+stateMsg+'该会员吗？', {
                    btn: ['确定','我考虑一下吧'] //按钮

                }, function(){
                    if (rowData.state="挂失"){
                    if(state ==1){
                        $("#stateId").html("取消挂失")
                    }else {
                        $("#stateId").html("挂失")
                    }}
                    $.post("/member_state",{id:id,state:state},function(data){
                        if(data.success){
                            layer.msg(''+stateMsg+'成功了', {icon: 1});
                            //重新加载页面
                            memberDatagrid.datagrid("reload");
                        }else{
                            $.messager.alert("温馨提示",data.msg,"error");
                        }
                    },"json")
                }, function(){
                    layer.close(index)
                });
            }else {
                layer.msg("请先择您要挂失的会员，不能选择多个！");
            }
        }
    }


    //会员等级菜单信息
    memberTree.tree({
        url:"/static/json/member.json",
        onClick:function (node) {
            if (node.id==1){
                layer.tab({
                    area: ['600px', '300px'],
                    tab: [{
                        title: '会员普通等级',
                        content: '会员：生日当天有礼物赠送，购买服装享受9折哦，会员有效期1年，' +
                        '积分范围：0--1999'
                    }, {
                        title: '会员黄金等级',
                        content: '亲：会员：生日当天有礼物赠送，购买服装享受8折哦，会员有效期1年，' +
                        '积分范围：2000--4999'
                    }, {
                        title: '会员白金等级',
                        content: '亲：会员：生日当天有礼物赠送，购买服装享受7.5折哦，会员有效期1年，' +
                        '积分范围：4999--9999'
                    },
                     {
                            title: '会员钻石等级',
                            content: '亲：会员：生日当天有礼物赠送，购买服装享受7折哦，会员有效期1年，' +
                            '积分范围：9999--14999'
                      }
                    ]
                });
            }else{
                console.log(node.attributes.levelId)
                memberDatagrid.datagrid({
                  //树菜单执行下面的子节点
                   url:"/member_list?levelId="+node.attributes.levelId,
                    onLoadSuccess:function () {
                       layer.msg("加载数据成功了")
                    }
                })

            }

        }
    })
});
function saveItem() {
  //首先获取到所有的列数
  var rows =  $("#member_datagrid").datagrid("getColumnFields");
  console.log(rows)
  //获取到隐藏的列数
  var list = $("#setTing_dialog :input")
  //遍历隐藏的列数，再碰到
    var itemName;
    $.each(list,function (index,item) {
        itemName = item.name
        if(item.checked){
            //显示进度条
            var win = $.messager.progress({
                title: '顾客稍慢',
                msg: '努力加载中'
            });
            setTimeout(function () {
                $.messager.progress('close');
            }, 5000)
            $("#member_datagrid").datagrid("showColumn",itemName)
            $("#setTing_dialog").dialog("close")
        }else {
            $("#member_datagrid").datagrid("hideColumn",itemName)
        }
    })
}

function genderFormatter(value,row,index) {
    if (value){
    return "女士";
    }
     return "男士";
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
function referrerFormatter(value,row,index) {
    if (row){
        return row.name;
    }
    return row;
}

function stateFormatter(value,row,index) {
    console.log(row.state)
    if (row.state==0){
        return "<font style='color: #ff0000'>挂失</font>"
    }
    return "正常"
}