/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-09-01 01:16:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class analyze_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"/static/css/Richangzhichu.css\" rel=\"stylesheet\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write(" <meta charset=\"utf-8\">\r\n");
      out.write("    <title>ECharts</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("                  <div class=\"Fxjuzczxtu borbot1\">\r\n");
      out.write("                        <div class=\"maxks mat15\">\r\n");
      out.write("                            <p>本日支出：<i>¥ <em>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${day}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </em> 元</i></p>\r\n");
      out.write("                            <p>本月支出：<i>¥ <em>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mouth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </em> 元</i></p>\r\n");
      out.write("                            <p>本年支出：<i>¥ <em>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${year}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </em> 元</i></p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("<a href=\"/linechart\"><img alt=\"柱状图\" src=\"/columndiagram.jpg\" width=\"50px\" height=\"50px\"></a>\r\n");
      out.write("<!-- 为ECharts准备一个具备大小（宽高）的Dom -->\r\n");
      out.write("    <div id=\"main\" style=\"height:400px\"></div>\r\n");
      out.write("    <!-- ECharts单文件引入 -->\r\n");
      out.write("   <script type=\"text/javascript\" src=\"/static/js/echarts-all.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write(" // 基于准备好的dom，初始化echarts图表\r\n");
      out.write("    var myChart = echarts.init(document.getElementById('main')); \r\n");
      out.write("    option = {\r\n");
      out.write("    \t    title : {\r\n");
      out.write("    \t        text: '年度账单',\r\n");
      out.write("    \t        subtext: '金额'\r\n");
      out.write("    \t    },\r\n");
      out.write("    \t    tooltip : {\r\n");
      out.write("    \t        trigger: 'axis'\r\n");
      out.write("    \t    },\r\n");
      out.write("    \t    legend: {\r\n");
      out.write("    \t        data:['平均金额']\r\n");
      out.write("    \t    },\r\n");
      out.write("    \t    toolbox: {\r\n");
      out.write("    \t        show : true,\r\n");
      out.write("    \t        feature : {\r\n");
      out.write("    \t            mark : {show: true},\r\n");
      out.write("    \t            dataView : {show: true, readOnly: false},\r\n");
      out.write("    \t            magicType : {show: true, type: ['line', 'bar']},\r\n");
      out.write("    \t            restore : {show: true},\r\n");
      out.write("    \t            saveAsImage : {show: true}\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t    },\r\n");
      out.write("    \t    calculable : true,\r\n");
      out.write("    \t    xAxis : [\r\n");
      out.write("    \t        {\r\n");
      out.write("    \t            type : 'category',\r\n");
      out.write("    \t            boundaryGap : false,\r\n");
      out.write("    \t            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t    ],\r\n");
      out.write("    \t    yAxis : [\r\n");
      out.write("    \t        {\r\n");
      out.write("    \t            type : 'value',\r\n");
      out.write("    \t            axisLabel : {\r\n");
      out.write("    \t                formatter: '{value} 元'\r\n");
      out.write("    \t            }\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t    ],\r\n");
      out.write("    \t    series : [\r\n");
      out.write("    \t        {\r\n");
      out.write("    \t            name:'本月支出统计',\r\n");
      out.write("    \t            type:'line',\r\n");
      out.write("    \t            data:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("    \t            markPoint : {\r\n");
      out.write("    \t                data : [\r\n");
      out.write("    \t                    {type : 'max', name: '最大值'},\r\n");
      out.write("    \t                    {type : 'min', name: '最小值'}\r\n");
      out.write("    \t                ]\r\n");
      out.write("    \t            },\r\n");
      out.write("    \t            markLine : {\r\n");
      out.write("    \t                data : [\r\n");
      out.write("    \t                    {type : 'average', name: '平均值'}\r\n");
      out.write("    \t                ]\r\n");
      out.write("    \t            }\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t    ]\r\n");
      out.write("    \t};\r\n");
      out.write("    \r\n");
      out.write("    myChart.setOption(option);  \r\n");
      out.write("        function pp() {\r\n");
      out.write("        \tconsole.log(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(")\r\n");
      out.write("        }\r\n");
      out.write("        pp();\r\n");
      out.write("    </script>\r\n");
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
