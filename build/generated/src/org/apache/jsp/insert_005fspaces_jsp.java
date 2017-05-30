package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Domain.ParkingLot;

public final class insert_005fspaces_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>parqueos oso polar - Espacios</title>\n");
      out.write("        ");

            int numberOfSpaces = Integer.parseInt(request.getParameter("numberOfSpaces"));
            int numberOfSpacesDisabilityPresented = Integer.parseInt(request.getParameter("numberOfSpacesDisabilityPresented"));
        
      out.write("\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,maximum-scale=1.0\" />\n");
      out.write("        <link href=\"//fonts.googleapis.com/css?family=Exo+2:300,500,600,regular,italic&subset=latin,latin-ext,cyrillic\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/designs/_shared/css/layout-shared.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/designs/_shared/css/menu-bones.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/layout.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/editable.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/animation.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/designs/impress-stripe/css/theme-stripe.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <link href=\"https://dss4hwpyv4qfp.cloudfront.net/mozello.ico\" rel=\"shortcut icon\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/backend/css/backend.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://dss4hwpyv4qfp.cloudfront.net/libs/js/fancybox/jquery.fancybox.css?v=1.241\" type=\"text/css\" />\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://dss4hwpyv4qfp.cloudfront.net/cache/preview-es.1.241.js\"></script>\n");
      out.write("\n");
      out.write("        <style class=\"customizer\">\n");
      out.write("            #title { background-color :  #05679b  }\n");
      out.write("            #title:after { border-top-color :  #05679b  }\n");
      out.write("            #title .mz_wysiwyg { color :  #ffffff  }\n");
      out.write("            #menu > ul > li > a { color :  #ffffff  }\n");
      out.write("            #menu > ul > li.selected > a, #menu > ul > li > a:hover { color :  #0088d1  }\n");
      out.write("            #bigbar-colorizer { background-color :  hsla(0, 0%, 0%, 0.5)  }\n");
      out.write("            #languages li > a { color :  #ffffff  }\n");
      out.write("            #languages li > a.selected, #languages li > a:hover { background-color :  #05679b  }\n");
      out.write("            #languages li > a.selected, #languages li > a:hover { color :  #ffffff  }\n");
      out.write("            a, .mz_editable a { color :  #0088d1  }\n");
      out.write("            a:hover, .mz_editable a:hover, .mz_recentposts a:hover { color :  #05679b  }\n");
      out.write("            .moze-form .moze-formbutton, .moze-button, .moze-button-large, ul.moze-gallery li, #submenu li:hover a, #submenu li.selected a { background-color :  #05679b  }\n");
      out.write("            .moze-form .moze-formbutton:hover, .moze-button:hover, .moze-button-large:hover { background-color :  #a0a0a0  }\n");
      out.write("            .mz_editable h1, .mz_editable h1.moze-megatitle, .mz_editable h1 a { color :  #444444  }\n");
      out.write("            .mz_editable h2, .sidebox h2 { color :  #444444  }\n");
      out.write("            .mz_editable h3 { color :  #444444  }\n");
      out.write("            body { background-color :  #05679b  }\n");
      out.write("            #bottom .mz_editable { color :  #a3dfff  }\n");
      out.write("            #bottom a { color :  #ffffff  }\n");
      out.write("            #bottom a:hover { color :  #a3dfff  }\n");
      out.write("        </style>\n");
      out.write("        <style class=\"customizer-fonts\"></style>\n");
      out.write("        <script src=\"https://dss4hwpyv4qfp.cloudfront.net/designs/impress/js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            // resize banner\n");
      out.write("            function InitLayout() {\n");
      out.write("                //var setHeight = $(\"#bigbar\").outerHeight();\n");
      out.write("                //$('#bigbar>div.mz_banner').css(\"min-height\", setHeight);\n");
      out.write("            }\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                // Resize on window size\n");
      out.write("                $(window).resize(function () {\n");
      out.write("                    InitLayout();\n");
      out.write("                });\n");
      out.write("                // Resize on key up\n");
      out.write("                $(\"#bigbar\").keyup(function () {\n");
      out.write("                    InitLayout();\n");
      out.write("                });\n");
      out.write("                // Resize on load\n");
      out.write("                InitLayout();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"\" lang=\"es\">               \n");
      out.write("        <div id=\"top\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <div id=\"title\">\n");
      out.write("                    <div class=\"mz_component mz_wysiwyg mz_editable\">\n");
      out.write("                        <div class=\"moze-wysiwyg-editor moze-no-select-border\" >\n");
      out.write("                            parqueos oso polar\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"mz_component mz_menu\" id=\"menu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"/\" >Inicio</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"/servicios/\" >Parqueos</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/servicios/ingresar/\" >Ingresar</a></li>\n");
      out.write("                                <li><a href=\"/servicios/consultar/\" >Consultar</a></li>\n");
      out.write("                                <li><a href=\"/servicios/modificar/\" >Modificar</a></li>\n");
      out.write("                                <li><a href=\"/servicios/eliminar/\" >Eliminar</a></li>\n");
      out.write("                            </ul></li>\n");
      out.write("                        <li><a href=\"/trabajos/\" >Clientes</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/trabajos/agregar/\" >Agregar</a></li>\n");
      out.write("                                <li><a href=\"/trabajos/consultar/\" >Consultar</a></li>\n");
      out.write("                                <li><a href=\"/trabajos/eliminar/\" >Eliminar</a></li>\n");
      out.write("                                <li><a href=\"/trabajos/modificar/\" >Modificar</a></li>\n");
      out.write("                            </ul></li>\n");
      out.write("                        <li><a href=\"/sobre-mi/\" >Vehiculos</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/sobre-mi/consular/\" >Consular</a></li>\n");
      out.write("                            </ul></li>\n");
      out.write("                        <li><a href=\"/precios/\" >Precios</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/precios/consular_modificar/\" >Consultar y modificar</a></li>\n");
      out.write("                            </ul></li>\n");
      out.write("                        <li><a href=\"/contacto/\" >Contacto</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/contacto/tarifas/\" >Tarifas</a></li>\n");
      out.write("                            </ul></li>\n");
      out.write("                        <li class=\"selected\"><a href=\"/pagina/\" >Espacios</a>\n");
      out.write("                        </li></ul>\n");
      out.write("                </div>\n");
      out.write("                <br style=\"clear: both\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"belowfold\">\n");
      out.write("\n");
      out.write("            <div id=\"wrap\">\n");
      out.write("                <div class=\"mz_component mz_menu\" id=\"submenu\"></div>\n");
      out.write("                <div class=\"mz_component mz_grid\" data-cid=\"11169221\" data-pid=\"2593015\">\n");
      out.write("                    <div class=\"section section-customizable\" data-rowid=\"1270392\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"gridrow\">\n");
      out.write("                                <div class=\"column-12-12\" data-cellid=\"1673295\">\n");
      out.write("                                    <div class=\"mz_component mz_wysiwyg mz_editable\">\n");
      out.write("                                        <div class=\"moze-wysiwyg-editor moze-no-select-border\" >\n");
      out.write("                                            <p></p>\n");
      out.write("                                            <table class=\"moze-table-border\">\n");
      out.write("                                                <tbody>\n");
      out.write("                                                    <tr class=\"moze-th\">\n");
      out.write("                                                        <td style=\"text-align: center;\"><b>Numero de espacio<b></b></td>\n");
      out.write("                                                        <td style=\"text-align: center;\"><b>Discapacidad presente<b></b></td>\n");
      out.write("                                                        <td style=\"text-align: center;\"><b>Estado</b></td>\n");
      out.write("                                                        <td style=\"text-align: center;\"><b>Tipo de vehículo<b></td>\n");
      out.write("                                                                    </tr>\n");
      out.write("                                                                    <tr>\n");
      out.write("                                                                        ");

                                                                            for (int x = 1; x <= numberOfSpaces; x++) {;
      out.write("\n");
      out.write("                                                                    <tr>\n");
      out.write("                                                                        <td style=\"text-align: center;\"> ");
      out.print(x);
      out.write(" </td>\n");
      out.write("                                                                        <td style=\"text-align: center;\">");
 if (x <= numberOfSpacesDisabilityPresented) {;
      out.write("\n");
      out.write("                                                                            Si ");
} else {;
      out.write("\n");
      out.write("                                                                            No ");
};
      out.write("\n");
      out.write("\n");
      out.write("                                                                        </td>\n");
      out.write("                                                                        <td style=\"text-align: center;\"> Disponible</td>\n");
      out.write("                                                                        <td style=\"text-align: center;\"> \n");
      out.write("                                                                            <div  id=\"VehicleTypeHolder\" >\n");
      out.write("                                                                                <select  id=\"Gender\" name=\"VehicleType\" >\n");
      out.write("                                                                                    <option value=\"\">Selecciona</option>\n");
      out.write("                                                                                    <option  value=\"Automovil\" >Automovil</option>\n");
      out.write("                                                                                    <option  value=\"Moto\" >Moto</option>\n");
      out.write("                                                                                    <option  value=\"Bicicleta\" >Bicicleta</option>\n");
      out.write("                                                                                    <option  value=\"Camion\" >Camión</option>\n");
      out.write("                                                                                </select>\n");
      out.write("                                                                </div></td>\n");
      out.write("                                                            ");
 };
      out.write("\n");
      out.write("                                                        </tr>\n");
      out.write("                                                    </tbody>\n");
      out.write("                                                </table>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"bottom\">\n");
      out.write("                    <div class=\"mz_component mz_wysiwyg mz_editable\">    \n");
      out.write("                            <div class=\"moze-wysiwyg-editor moze-no-select-border\" >Proyecto programación 2 - UCR 2017</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("      </body>\n");
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
