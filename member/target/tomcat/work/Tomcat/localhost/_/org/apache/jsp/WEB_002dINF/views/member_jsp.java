/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-09-01 02:29:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class member_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/static/common/common.jsp", Long.valueOf(1503749843159L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>会员管理管理</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"/static/plugins/easyui/themes/ui-pepper-grinder/easyui.css\">\r\n");
      out.write("<!--æ ·å¼æä»¶-->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"/static/plugins/easyui/themes/icon.css\">\r\n");
      out.write("<!--å¾æ æ ·å¼-->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"/static/plugins/easyui/jquery.min.js\"></script>\r\n");
      out.write("<!--ç¹å®çæ¬çjQueryçæ ¸å¿æä»¶-->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"/static/plugins/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<!-- easyuiçæ ¸å¿å-->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"/static/plugins/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<!--è¯­è¨æ¯æå-->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"/static/js/base.js\"></script>\r\n");
      out.write("<!-- EasyUIæé®çè¡¥ä¸å -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/static/js/member.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/static/plugins/layer/layer.js\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/css/demo.css\">\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $(\".tips\").mouseenter(function () {\r\n");
      out.write("                layer.tips($(this).data(\"content\"),$(this),{\r\n");
      out.write("                    tips:[2,'#259926'],\r\n");
      out.write("                    maxWidth:200,\r\n");
      out.write("                    time:1200\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--会员详情-->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"cc\" class=\"easyui-layout\" fit=true>\r\n");
      out.write("\r\n");
      out.write("\t<div data-options=\"region:'west',title:'会员等级',split:true\" style=\"width:150px;background-color:bisque\">\r\n");
      out.write("\t\t<ul id=\"member_tree\" class=\"easyui-tree\">\r\n");
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div data-options=\"region:'center',title:'会员列表'\" style=\"padding:5px;\"\r\n");
      out.write("\t\t style=\"width:100px;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!--会员详情-->\r\n");
      out.write("\t\t<div style=\"background-color: #8D8D8D\" id=\"memberVo\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"leftpanel\"\r\n");
      out.write("\t\t\t\t style=\"border-radius:20px; border:1px solid #f26d7e; width:26%;height: 100px;margin: 35px 5px 20px 70px; float: left\">\r\n");
      out.write("\t\t\t\t<p style=\"font-size: medium;height: 1px\">今天过生日的会员:</p>\r\n");
      out.write("\t\t\t\t<p style=\"color: red;font-size: x-large;text-align: center\">\r\n");
      out.write("\t\t\t\t\t<i id=\"bircount\" style=\"font-size: 50px\"></i>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"centerpanel\"\r\n");
      out.write("                         style=\"border-radius:20px;border:1px solid #f26d7e; width:26%;height: 100px;margin: 35px 5px 20px 20px; float: left;\">\r\n");
      out.write("                        <p style=\"font-size: medium;height: 1px\">会员总数:</p>\r\n");
      out.write("                        <p style=\"color: red;font-size: x-large;text-align: center\"><i id=\"usercount\" style=\"font-size: 50px\"></i></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"rightpanel\"\r\n");
      out.write("                         style=\"border-radius:20px;border:1px solid #f26d7e; width:26%;height: 100px;margin: 35px 5px 20px 20px; float: left\">\r\n");
      out.write("                        <p style=\"font-size: medium;height: 1px\">累计消费金额:</p>\r\n");
      out.write("                        <p style=\"color: red;font-size: x-large;text-align: center\"><i id=\"recelivableCount\" style=\"font-size: 50px\"></i></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 数据表格 -->\r\n");
      out.write("\t<table id=\"member_datagrid\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'name',width:10,align:'center'\">会员姓名</th>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'sn',width:10,align:'center'\">会员卡号</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'phone',width:10,align:'center'\">电话号码\r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton tips\" iconCls=\"icon-question\" plain=\"true\" data-content=\"亲，主人，双击电话下面的单元格，输入电话号码，可以快速修改数据哦，开来试试哦m\"></a>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'gender',width:10,align:'center',formatter:genderFormatter\">性别</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'totalConsume',width:10,align:'center'\">卡上余额</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'birthday',width:10,align:'center'\">生日</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'integral',width:10,align:'center'\">会员积分</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'level',width:10,align:'center',formatter:levelFormatter\">会员等级</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'payment',width:10,align:'center',formatter:paytypeFormatter\">会员支付方式</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'referrer',width:10,align:'center',formatter:referrerFormatter\">推荐人</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'address',width:10,align:'center'\">会员家庭地址</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'state',width:10,align:'center',formatter:stateFormatter\">状态</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'usedintegral',width:10,align:'center'\">已使用积分</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'remark',width:10,align:'center'\">会员备注</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'deadline',width:10,align:'center'\">过期时间</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'qq',width:10,align:'center'\">QQ</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'totalMoney',width:10,align:'center'\">开卡总金额</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<!-- 新增编辑对话框 -->\r\n");
      out.write("\t<div id=\"member_dialog\">\r\n");
      out.write("\t\t<form id=\"member_form\" method=\"post\">\r\n");
      out.write("\t\t<table align=\"center\" style=\"margin-top: 15px;\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\">\r\n");
      out.write("\t\t\t<tr style=\"margin-top: 15px\">\r\n");
      out.write("\t\t\t\t<td>会员卡号</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"sn\" readonly=\"readonly\" style=\"background-color: #8D8D8D;color: whitesmoke\" placeholder=\"随机生成会员卡号\"  >\r\n");
      out.write("                    <a class=\"easyui-linkbutton tips\" iconCls=\"icon-question\" plain=\"true\" data-content=\"亲，主人，随机生成会员卡号，不需要手写哦\r\n");
      out.write("         防止会员卡号重复哦\"></a>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>会员姓名</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"name\" class=\"easyui-validatebox\"\r\n");
      out.write("                           data-options=\"required:true\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("            <br/>\r\n");
      out.write("\t\t\t<tr style=\"margin-top: 15px\">\r\n");
      out.write("\t\t\t\t<td>电话号码</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"phone\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("                <td>会员密码</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"password\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("                <td>性别</td>\r\n");
      out.write("                <td><input type=radio value=\"0\" name=\"gender\">男\r\n");
      out.write("                    <input type=radio value=\"1\" name=\"gender\">女\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>生日</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"birthday\" type=\"text\" class=\"easyui-datebox\">\r\n");
      out.write("                    <a class=\"easyui-linkbutton tips\" iconCls=\"icon-question\" plain=\"true\" data-content=\"亲，记得写上生日，我们会在你生日当天送给你一份精美礼品哦\r\n");
      out.write("          \"></a>\r\n");
      out.write("                </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>QQ</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"qq\"></td>\r\n");
      out.write("                <td>会员家庭地址</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"address\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>会员支付方式</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("                    <select  class=\"easyui-combobox\" name=\"payment\" data-options=\"panelHeight:'auto'\" style=\"width:150px;\">\r\n");
      out.write("                        <option value=\"1\">现金</option>\r\n");
      out.write("                        <option value=\"2\">微信</option>\r\n");
      out.write("                        <option value=\"3\">支付宝</option>\r\n");
      out.write("                        <option value=\"4\">银行卡</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>会员等级</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"text\" name=\"level.id\" class=\"easyui-combobox\"\r\n");
      out.write("                           data-options=\"\r\n");
      out.write("\t\t\t\t\t\t\t        valueField: 'id',\r\n");
      out.write("\t\t\t\t\t\t\t        textField: 'name',\r\n");
      out.write("\t\t\t\t\t\t\t        url: '/memberLevelBymember',panelHeight:'auto'\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>开卡总金额</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"totalMoney\"></td>\r\n");
      out.write("                <td>消费金额</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"totalConsume\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>会员积分</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"integral\"></td>\r\n");
      out.write("                <td>已使用积分</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"usedintegral\"></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>会员备注</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"remark\"></td>\r\n");
      out.write("                <td>过期时间</td>\r\n");
      out.write("                <td><input type=\"text\" name=\"deadline\" name=\"birthday\" type=\"text\" class=\"easyui-datebox\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>推荐人</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("                   ");
      out.write("\r\n");
      out.write("                       <input type=\"text\" name=\"referrer.id\" class=\"easyui-combobox\"\r\n");
      out.write("                              data-options=\"\r\n");
      out.write("\t\t\t\t\t\t      valueField: 'id',\r\n");
      out.write("\t\t\t\t\t\t\t  textField: 'name',\r\n");
      out.write("\t\t\t\t\t\t\t  url: '/meberId',panelHeight:'auto'\"/>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t   <a class=\"easyui-linkbutton tips\" iconCls=\"icon-question\" plain=\"true\" data-content=\"推荐人：是推荐你来这办会员卡，多多推荐，\r\n");
      out.write("      推荐人与被推荐人都有礼品相送哦\"></a>\r\n");
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("\t\t\t\t<td>状态:</td>\r\n");
      out.write("\t\t\t\t<td><select  class=\"easyui-combobox\" name=\"state\"\r\n");
      out.write("\t\t\t\t\t\t\t panelHeight='auto' style=\"width: 143px;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"1\">正常</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"0\">挂失</option>\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<!-- 隐藏的按钮的 -->\r\n");
      out.write("\t\t<div id=\"setTing_dialog\">\r\n");
      out.write("            <div>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"totalMoney\">:开卡总金额<br/>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"qq\">：qq<br/>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"deadline\">:过期时间<br/>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"remark\">:会员备注\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 数据表格CRUD按钮 -->\r\n");
      out.write("\t<div id=\"member_datagrid_tb\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" data-cmd=\"add\">新增</a>\r\n");
      out.write("\t\t\t<a id=\"emp_tb_edit\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" data-cmd=\"edit\">編輯</a>\r\n");
      out.write("\t\t\t<a  id=\"emp_tb_cs\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" data-cmd=\"del\">刪除</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\" data-cmd=\"reload\">刷新</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-list\" plain=\"true\" data-cmd=\"setTing\">列表显示</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton tips\" iconCls=\"icon-question\" plain=\"true\" data-content=\"列表显示：主人，为了让你有更好的体验，以及视觉效果，\r\n");
      out.write("\t\t\t通过这个按钮，你可以看到自己想要看到的数据\"></a>\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\t   data-options=\"iconCls:'icon-import',plain:true\" data-cmd=\"exportFile\" >导出</a><br/>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"margin:10px 0;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input id=\"sss1\" class=\"easyui-searchbox\" data-options=\"prompt:'请输入会员姓名或者会员地址',menu:'#mm',searcher:doSearch\" style=\"width:300px\"></input>\r\n");
      out.write("\t\t\t<div id=\"mm\" style=\"width:120px\">\r\n");
      out.write("\t\t\t\t<div data-options=\"name:'name',iconCls:'icon-ok'\">会员姓名</div>\r\n");
      out.write("\t\t\t\t<div data-options=\"name:'address'\">会员地址</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-state\" plain=\"true\" data-cmd=\"state\"><span id=\"stateId\">挂失</span></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("                function doSearch(value,name){\r\n");
      out.write("                  $(\"#member_datagrid\").datagrid('load',{\r\n");
      out.write("                      value:value,\r\n");
      out.write("\t\t\t\t\t  name:name\r\n");
      out.write("\t\t\t\t  })\r\n");
      out.write("                }\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 对话框保存取消按钮 -->\r\n");
      out.write("\t<div id=\"member_dialog_bt\">\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-save\" plain=\"true\" data-cmd=\"save\">保存</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\" data-cmd=\"cancel\">取消</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<!-- 列表显示保存取消按钮 -->\r\n");
      out.write("\t\t<div id=\"setTing_dialog_bt\">\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-save\" plain=\"true\" onclick=\"saveItem()\">保存</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\" data-cmd=\"cancelItem\">取消</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
