/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-09-01 01:16:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class stockoutcombillresport_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"/static/js/stockoutcombillresport.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".a {\r\n");
      out.write("\tbackground-color: blue;\r\n");
      out.write("\tborder: 1px solid #000;\r\n");
      out.write("\tborder-top-left-radius: 10px;\r\n");
      out.write("\tborder-top-right-radius: 10px;\r\n");
      out.write("\tborder-bottom-left-radius: 10px;\r\n");
      out.write("\tborder-bottom-right-radius: 10px;\r\n");
      out.write("\theight: 150px;\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".table {\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\tborder-spacing: 0;\r\n");
      out.write("\tborder-left: 1px solid #888;\r\n");
      out.write("\tborder-top: 1px solid #888;\r\n");
      out.write("\tbackground: #efefef;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".td {\r\n");
      out.write("\tborder-right: 1px solid #888;\r\n");
      out.write("\tborder-bottom: 1px solid #888;\r\n");
      out.write("\tpadding: 5px 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tr {\r\n");
      out.write("\tborder-right: 1px solid #888;\r\n");
      out.write("\tborder-bottom: 1px solid #888;\r\n");
      out.write("\tpadding: 5px 15px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tbackground: #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".b {\r\n");
      out.write("\tbackground-color: #c7dec6;\r\n");
      out.write("\t/* border-top-left-radius: 10px;\r\n");
      out.write("\tborder-top-right-radius: 10px;\r\n");
      out.write("\tborder-bottom-left-radius: 10px;\r\n");
      out.write("\tborder-bottom-right-radius: 10px; */\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\twidth: 150px;\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"padding: 10px 30px;\">\r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-abc5\" plain=\"true\">导出</a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td style=\"padding: 10px 30px;\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-abc6\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"TodaySearch(0)\">今天</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-abc2\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"TodaySearch(-1)\">昨天</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-abc3\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"TodaySearch(-7)\">本周</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-abc4\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"AllSearch()\">全部</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<hr size=\"5\">\r\n");
      out.write("\t\t<div style=\"margin:20px 0;\"></div>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t<div id=\"cc\" style=\"width:200px;height:650px;padding-right: 20px\" class=\"easyui-layout\" >\r\n");
      out.write("\t\t<div data-options=\"region:'center',split:false,collapsible:false\" style=\"width:150px;\">\r\n");
      out.write("\t\t<table class=\"table\" id=\"table1\" style=\"border: 1px\">\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\" colspan=\"3\">葫芦岛分店</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: right !important;\" colspan=\"3\">收银对账单</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: right !important;\" colspan=\"3\">填充时间</td>\r\n");
      out.write("\t\t\t\t</tr class=\"tr\">\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: right !important;\">散客消费</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"c6\" style=\"text-align: center !important;\" colspan=\"2\">2 人</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: right !important;\">会员消费</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"m6\" style=\"text-align: center !important;\" colspan=\"2\">1 人</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td style=\"vertical-align: middle; text-align: right !important;\"\r\n");
      out.write("\t\t\t\t\t\trowspan=\"1\">\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\" colspan=\"2\">1 个(银卡)</td>\r\n");
      out.write("\t\t\t\t</tr class=\"tr\">\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td style=\"vertical-align: middle; text-align: right !important;\"\r\n");
      out.write("\t\t\t\t\t\trowspan=\"4\">会员充值金额</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"a1\" style=\"text-align: center !important;\">￥100</td>\r\n");
      out.write("\t\t\t\t\t<td  style=\"text-align: center !important;\">现金</td>\r\n");
      out.write("\t\t\t\t</tr class=\"tr\">\r\n");
      out.write("\t\t\t\t<tr class=\"tr\">\r\n");
      out.write("\t\t\t\t\t<td id=\"a2\" style=\"text-align: center !important;\">￥0</td>\r\n");
      out.write("\t\t\t\t\t<td  style=\"text-align: center !important;\">微信</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"a3\" style=\"text-align: center !important;\">￥0</td>\r\n");
      out.write("\t\t\t\t\t<td  style=\"text-align: center !important;\">支付宝</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"a4\" style=\"text-align: center !important;\">￥0</td>\r\n");
      out.write("\t\t\t\t\t<td  style=\"text-align: center !important;\">银行卡</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"vertical-align: middle; text-align: right !important;\"\r\n");
      out.write("\t\t\t\t\t\trowspan=\"4\">充次储值金额</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">￥0</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">现金</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">￥0</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">微信</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">￥0</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">银行卡</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">￥0</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center !important;\">支付宝</td>\r\n");
      out.write("\t\t\t\t</tr> -->\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"a5\" style=\"text-align: center !important;\" colspan=\"3\">会员总收入\r\n");
      out.write("\t\t\t\t\t\t：￥100</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<div id=\"cc2\" style=\"width:300px;height:650px; padding-left: 30px\" class=\"easyui-layout\" >\r\n");
      out.write("\t\t<div data-options=\"region:'center'\" style=\"padding:10px\">\r\n");
      out.write("\t\t\t<table class=\"table\" id=\"table1\" style=\"border: 1px\">\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: left !important;\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>消费数据统计</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"vertical-align: middle; text-align: right !important;\"\r\n");
      out.write("\t\t\t\t\t\t\trowspan=\"7\">散客消费</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"c1\" style=\"text-align: center !important;\">￥30.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">现金</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"c2\" style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">微信</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"c3\" style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">银行卡</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"c4\" style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">支付宝</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td  style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">美团</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">口碑</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">闪惠</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td  style=\"text-align: right !important;\">散客消费总额</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"c5\" style=\"text-align: center !important;\" colspan=\"2\">￥30.00</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"vertical-align: middle; text-align: right !important;\"\r\n");
      out.write("\t\t\t\t\t\t\trowspan=\"9\">会员消费</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"m1\" style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">现金</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"m2\" style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">微信</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"m3\" style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">银行卡</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"m4\" style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">支付宝</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">美团</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">口碑</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">闪惠</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">￥0.00</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"text-align: center !important;\">赊账</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td  style=\"text-align: right !important;\">会员消费总额</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"m5\" style=\"text-align: center !important;\" colspan=\"2\">￥16.00</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"m7\" style=\"text-align: center !important;\" colspan=\"3\">时间\r\n");
      out.write("\t\t\t\t\t\t\t：2017/8/31 12:03:54</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t</div>  \r\n");
      out.write("</div>  </td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(\"#table1 tr\").addClass(\"tr\");\r\n");
      out.write("\t\t$(\"#table1 td\").addClass(\"td\");\r\n");
      out.write("\t</script>\r\n");
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
