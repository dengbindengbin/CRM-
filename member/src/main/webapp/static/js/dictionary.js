$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var dictionaryDatagrid, dictionaryDialog, dictionaryForm
        , dictionaryItemDatagrid, dictionaryItemDialog, dictionaryItemForm;
    dictionaryDatagrid = $("#dictionary_datagrid");
    dictionaryDialog = $("#dictionary_dialog");
    dictionaryForm = $("#dictionary_form");

    //数据字典的明细
    dictionaryItemDatagrid = $("#dictionaryItem_datagrid");
    dictionaryItemDialog = $("#dictionaryItem_dialog");
    dictionaryItemForm = $("#dictionaryitem_form");
    dictionaryDatagrid.datagrid({
        url: "/dictionary_list",
        fit: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        pagination: true,
        fitColumns: true,
        toolbar: '#dictionary_datagrid_tb',
        onClickRow:function (rowindex,rowData) {
            //依据数据字典的ID来查询数据字典明细的所有数据
            var options = dictionaryItemDatagrid.datagrid("options")
            options.url="/dictionaryitem_queryByDictionId?id="+rowData.id,
                //重新加载数据
                dictionaryItemDatagrid.datagrid("load",{id:rowData
                    .id});
        }
    });
    dictionaryDialog.dialog({
        width: 300,
        height: 300,
        closed: true,
        buttons: '#dictionary_dialog_bt'
    });

    dictionaryItemDatagrid.datagrid({
        url: "/dictionaryitem_list",
        fit: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        pagination: true,
        fitColumns: true,
        toolbar: '#dictionaryItem_datagrid_tb'
    })
    dictionaryItemDialog.dialog({
        width: 300,
        height: 300,
        closed: true,
        buttons: '#dictionaryitem_dialog_bt'
    });


    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    /*
     * 所有的操作封装到cmdObj对象中,方便管理
     */
    var cmdObj = {
        add: function () {
            dictionaryForm.form("clear");
            dictionaryDialog.dialog("setTitle", "新增");
            dictionaryDialog.dialog("open");
            $("#comboboxDictionary").combobox("setValue","职位")
        },
        addItem: function () {
            $("#comboboxDictionary").combobox("setValue","职位")
            dictionaryItemForm.form("clear");
            dictionaryItemDialog.dialog("setTitle", "新增");
            dictionaryItemDialog.dialog("open");
        },
        edit: function () {
            var rowData = dictionaryDatagrid.datagrid("getSelected");
            console.log(rowData)
            if (rowData) {
                dictionaryForm.form("clear");
                dictionaryDialog.dialog("setTitle", "编辑");
                dictionaryDialog.dialog("open");
                if (rowData.datdict)
                    rowData["datdict.id"] = rowData.datdict.id;
                dictionaryForm.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据!", "warining");
            }
        },
        editItem: function () {
            var rowData = dictionaryItemDatagrid.datagrid("getSelected");
            console.log(rowData)
            if (rowData) {
                dictionaryItemForm.form("clear");
                dictionaryItemDialog.dialog("setTitle", "编辑");
                dictionaryItemDialog.dialog("open");
                if (rowData.datdict){
                    rowData["datdict.id"] = rowData["datdict"].id;
                }
                dictionaryItemForm.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据!", "warining");
            }
        },
        del: function () {
            var rowData = dictionaryDatagrid.datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "您确定需要删除选中数据吗？", function (yes) {
                    if (yes) {
                        $.get("/dictionary_delete?dictionaryId=" + rowData.id, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    dictionaryDatagrid.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "error");
                            }
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的数据!", "warining");
            }
        },
        delItem: function () {
            var rowData = dictionaryItemDatagrid.datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "您确定需要删除选中数据吗？", function (yes) {
                    if (yes) {
                        $.get("/dictionaryitem_delete?dictionaryId=" + rowData.id, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    dictionaryItemDatagrid.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "error");
                            }
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的数据!", "warining");
            }
        },
        reload: function () {
            dictionaryDatagrid.datagrid("reload");
        },
        reloadItem:function () {
            dictionaryItemDatagrid.datagrid("reload");
        },
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            console.log(idVal)
            if (idVal) {
                url = "/dictionary_update"
            } else {
                url = "/dictionary_save";
            }
            dictionaryForm.form("submit", {
                url: url,
                success: function (data) {
                    console.log(data)
                    data = $.parseJSON(data);
                    console.log(data)
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            dictionaryDialog.dialog("close");
                            dictionaryDatagrid.datagrid("reload");
                            $("#dictionaryItem_datagrid").datagrid('load', {});
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            });
        },
        saveitem:function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/dictionaryitem_update"
            } else {
                url = "/dictionaryitem_save";
            }
            dictionaryItemForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            dictionaryItemDialog.dialog("close");
                            dictionaryItemDatagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            });
        },
        cancel: function () {
            dictionaryDialog.dialog("close");
        },
        cancelitem:function () {
            dictionaryItemDialog.dialog("close")
        }
    }
});
function dictoryName(value,row,index) {
    console.log(arguments)
    if (value){
        return value.name;
    }
    return value;
}
