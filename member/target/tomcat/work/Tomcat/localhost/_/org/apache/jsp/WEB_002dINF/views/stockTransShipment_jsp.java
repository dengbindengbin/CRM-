/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-09-01 01:09:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class stockTransShipment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>库存调拨</title>\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"/static/js/stockTransShipment.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t$.extend($.fn.datagrid.methods, {\r\n");
      out.write("\t\t\teditCell: function(jq,param){\r\n");
      out.write("\t\t\t\treturn jq.each(function(){\r\n");
      out.write("\t\t\t\t\tvar opts = $(this).datagrid('options');\r\n");
      out.write("\t\t\t\t\tvar fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));\r\n");
      out.write("\t\t\t\t\tfor(var i=0; i<fields.length; i++){\r\n");
      out.write("\t\t\t\t\t\tvar col = $(this).datagrid('getColumnOption', fields[i]);\r\n");
      out.write("\t\t\t\t\t\tcol.editor1 = col.editor;\r\n");
      out.write("\t\t\t\t\t\tif (fields[i] != param.field){\r\n");
      out.write("\t\t\t\t\t\t\tcol.editor = null;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t$(this).datagrid('beginEdit', param.index);\r\n");
      out.write("\t\t\t\t\tfor(var i=0; i<fields.length; i++){\r\n");
      out.write("\t\t\t\t\t\tvar col = $(this).datagrid('getColumnOption', fields[i]);\r\n");
      out.write("\t\t\t\t\t\tcol.editor = col.editor1;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar editIndex = undefined;\r\n");
      out.write("\t\tfunction endEditing(){\r\n");
      out.write("\t\t\tif (editIndex == undefined){return true}\r\n");
      out.write("\t\t\tif ($('#store_datagrid').datagrid('validateRow', editIndex)){\r\n");
      out.write("\t\t\t\t$('#store_datagrid').datagrid('endEdit', editIndex);\r\n");
      out.write("\t\t\t\teditIndex = undefined;\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction onClickCell(index, field){\r\n");
      out.write("\t\t\tif (endEditing()){\r\n");
      out.write("\t\t\t\t$('#store_datagrid').datagrid('selectRow', index)\r\n");
      out.write("\t\t\t\t\t\t.datagrid('editCell', {index:index,field:field});\r\n");
      out.write("\t\t\t\teditIndex = index;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"cc\" class=\"easyui-layout\" data-options=\"fit:true,border:false\">\r\n");
      out.write("\t\t<div data-options=\"region:'north',split:false\" style=\"height: 60px;\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"warehouse.id\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"store.id\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<span>仓库：</span>\r\n");
      out.write("\t\t\t\t<input id=\"warehouse\" type=\"text\" name=\"warehouse.id\"\r\n");
      out.write("\t\t\t\t\tclass=\"easyui-combobox\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"valueField: 'id',\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttextField: 'wname',\r\n");
      out.write("\t\t\t\t\t\t\t\t\trequired:true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\turl: '/warehouse_listAll.do',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tpanelHeight:'auto',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<span>商店：</span>\r\n");
      out.write("\t\t\t\t<input id=\"store\" type=\"text\" name=\"store.id\"\r\n");
      out.write("\t\t\t\t\tclass=\"easyui-combobox\" placeholder=\"请选择商店\"\r\n");
      out.write("\t\t\t\t\tdata-options=\"valueField: 'id',\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttextField: 'name',\r\n");
      out.write("\t\t\t\t\t\t\t\t\trequired:true,\r\n");
      out.write("\t\t\t\t\t\t\t\t\turl: '/store_all.do',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tpanelHeight:'auto',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'east',split:false\" style=\"width: 50%;\">\r\n");
      out.write("\t\t\t<form id=\"stockTransShipment_form\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table id=\"store_datagrid\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<div style=\"width: 100%; overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<span style=\"font-size: 15px; font-weight: 700;\">调拨备注：</span>\r\n");
      out.write("\t\t\t\t\t\t<textarea id=\"sv_remarks\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 150px; height: 18px; text-indent: 5px;\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"请输入不超过50个字\"></textarea>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<span style=\"font-size: 15px; font-weight: 700\">总数：</span>\r\n");
      out.write("\t\t\t\t\t\t<label id=\"sumnumber\" style=\"color: #0026ff; font-size: 16px;\"></label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<span style=\"font-size: 15px; font-weight: 700;\">合计金额：</span>\r\n");
      out.write("\t\t\t\t\t\t¥\r\n");
      out.write("\t\t\t\t\t\t<label id=\"summoney\" style=\"color: #ff0000; font-size: 15px;\"></label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"调拨\" onclick=\"saveStore()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-xs-1\" style=\"padding: 0;\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'west',split:false\" style=\"width: 50%;\">\r\n");
      out.write("\t\t\t<table id=\"warehouse_datagrid\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div id=\"warehouse_datagrid_tb\">\r\n");
      out.write("\t\t\t\t<a class=\"easyui-linkbutton\" iconCls=\"icon-redo\" plain=\"true\"\r\n");
      out.write("\t\t\t\t\tonclick=\"choosePruduct()\">选择</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
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
