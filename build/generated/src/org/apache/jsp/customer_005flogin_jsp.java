package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customer_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            div.container {\n");
      out.write("                width: 100%;\n");
      out.write("                border: 3px solid gray;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            header, footer {\n");
      out.write("                padding: 1em;\n");
      out.write("                color: white;\n");
      out.write("                background-color: black;\n");
      out.write("                clear: left;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            nav {\n");
      out.write("                float: left;\n");
      out.write("                max-width: 160px;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 1em;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            nav ul {\n");
      out.write("                list-style-type: none;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            nav ul a {\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("                \n");
      out.write("            article {\n");
      out.write("                margin-left: 170px;\n");
      out.write("                border-left: 1px solid gray;\n");
      out.write("                padding: 1em;\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            \n");
      out.write("            <header>\n");
      out.write("                <h1>Login Cliente </h1>\n");
      out.write("            </header>\n");
      out.write("             \n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                   <li><a href=\"customer_login.jsp\">Cliente</a></li>\n");
      out.write("                   <li><a href=\"operator_login.jsp\">Operador</a></li>\n");
      out.write("                   <li><a href=\"administrator_login.jsp\">Administrador</a></li> \n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            \n");
      out.write("            <article>\n");
      out.write("                <img src=\"oso.gif-c200\" alt=\"HTML Icon\" style=\"width:100px;height:100px;\">             \n");
      out.write("             </article>\n");
      out.write("                       \n");
      out.write("            <article>\n");
      out.write("                <form action=\"CustomerLoginServlet\" method=\"get\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                Nombre de usuario: \n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" name=\"username\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                            \n");
      out.write("                        <tr>                    \n");
      out.write("                            <td>\n");
      out.write("                                Contraseña:\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"password\" name=\"password\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                            \n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"submit\" value=\"Ingresar\" />\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"reset\" value=\"Cancelar\" />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>                \n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </article>\n");
      out.write("                \n");
      out.write("            <footer>Proyecto de programación 2</footer>\n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
