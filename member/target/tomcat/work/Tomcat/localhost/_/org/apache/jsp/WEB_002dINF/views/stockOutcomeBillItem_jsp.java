/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-09-01 01:16:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class stockOutcomeBillItem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/css/demo.css\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>每日销售明细管理</title>\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"/static/js/stockOutcomeBillItem.js\"></script>\r\n");
      out.write("<!-- <script type=\"text/javascript\" src=\"/static/js/search.js\"></script> -->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td style=\"width: 300px; padding: 15px 50px;\">\r\n");
      out.write("\t\t\t\t<div class=\"easyui-panel\" style=\"width: 100%; padding: 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<input id=\"searchId\" class=\"easyui-searchbox\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"prompt:'请输入查询信息',menu:'#mm',searcher:doSearch,fit:true\">\r\n");
      out.write("\t\t\t\t\t<div id=\"mm\">\r\n");
      out.write("\t\t\t\t\t\t<div data-options=\"name:'client_id',iconCls:'icon-ok'\">按会员信息</div>\r\n");
      out.write("\t\t\t\t\t\t<div data-options=\"name:'serial_number'\">按流水单号信息</div>\r\n");
      out.write("\t\t\t\t\t\t<div data-options=\"name:'productName'\">按商品信息</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td style=\"padding: 10px 30px;\">\r\n");
      out.write("\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\">导出</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td style=\"padding: 10px 30px;\">\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"TodaySearch(0)\">今天</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"TodaySearch(-1)\">昨天</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"TodaySearch(-2)\">前天</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"AllSearch()\">全部</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>支付方式:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<select id=\"cc\" class=\"easyui-combobox\" name=\"paytype\"\r\n");
      out.write("\t\t\t\t\tpanelHeight='auto' style=\"width: 143px;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"微信支付\">微信支付</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"支付宝支付\">支付宝支付</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"现金支付\">现金支付</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"信用卡支付\">信用卡支付</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"让别人支付\">让别人支付</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td>消费店铺:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input name=\"store.id\" type=\"text\" class=\"easyui-combobox\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"    \r\n");
      out.write("\t\t\t\t\t\t\t        valueField: 'id',    \r\n");
      out.write("\t\t\t\t\t\t\t        textField: 'name',    \r\n");
      out.write("\t\t\t\t\t\t\t        url: '/store_all',panelHeight:'auto',multiple:false\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<!-- 数据表格 -->\r\n");
      out.write("\t<table id=\"stockOutcomeBillItem_datagrid\"\">\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<!-- 新增编辑对话框 -->\r\n");
      out.write("\t<div id=\"stockOutcomeBillItem_dialog\">\r\n");
      out.write("\t\t<form id=\"stockOutcomeBillItem_form\" method=\"post\">\r\n");
      out.write("\t\t\t<table align=\"center\" style=\"margin-top: 15px;\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"id\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>销售总金额</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"saleamount\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>消费顾客:</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"client.id\" type=\"text\" class=\"easyui-combobox\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-options=\"    \r\n");
      out.write("\t\t\t\t\t\t\t        valueField: 'id',    \r\n");
      out.write("\t\t\t\t\t\t\t        textField: 'name',    \r\n");
      out.write("\t\t\t\t\t\t\t        url: '/client_all',panelHeight:'auto',multiple:false\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>消费店铺:</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"store.id\" type=\"text\" class=\"easyui-combobox\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-options=\"    \r\n");
      out.write("\t\t\t\t\t\t\t        valueField: 'id',    \r\n");
      out.write("\t\t\t\t\t\t\t        textField: 'name',    \r\n");
      out.write("\t\t\t\t\t\t\t        url: '/store_all',panelHeight:'auto',multiple:false\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>所属店铺:</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"parent.id\" type=\"text\" class=\"easyui-combobox\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-options=\"    \r\n");
      out.write("\t\t\t\t\t\t\t        valueField: 'id',    \r\n");
      out.write("\t\t\t\t\t\t\t        textField: 'name',    \r\n");
      out.write("\t\t\t\t\t\t\t        url: '/store_getparent',panelHeight:'auto',multiple:false\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>消费时间</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"intputtime\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>支付方式</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"paytype\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>总数量</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"number\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>单号</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"oddNumbers\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>单价</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"saleprice\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<!-- <td>商品名称:</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"products_combobox\"   name=\"product.id\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-combobox\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-options=\"    \r\n");
      out.write("\t\t\t\t\t\t\t        valueField: 'id',    \r\n");
      out.write("\t\t\t\t\t\t\t        textField: 'name',    \r\n");
      out.write("\t\t\t\t\t\t\t        url: '',panelHeight:'auto',multiple:true\" />\r\n");
      out.write("\t\t\t\t\t\t</td> -->\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>折扣</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"discount\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>流水号</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"serialNumber\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 数据表格CRUD按钮 -->\r\n");
      out.write("\t<div id=\"stockOutcomeBillItem_datagrid_tb\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\"\r\n");
      out.write("\t\t\t\tdata-cmd=\"add\">新增</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\"\r\n");
      out.write("\t\t\t\tdata-cmd=\"edit\">編輯</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\"\r\n");
      out.write("\t\t\t\tdata-cmd=\"del\">刪除</a>\r\n");
      out.write("\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\"\r\n");
      out.write("\t\t\t\tdata-cmd=\"reload\">刷新</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 对话框保存取消按钮 -->\r\n");
      out.write("\t<div id=\"stockOutcomeBillItem_dialog_bt\">\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-save\" plain=\"true\"\r\n");
      out.write("\t\t\tdata-cmd=\"save\">保存</a>\r\n");
      out.write("\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\"\r\n");
      out.write("\t\t\tdata-cmd=\"cancel\">取消</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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