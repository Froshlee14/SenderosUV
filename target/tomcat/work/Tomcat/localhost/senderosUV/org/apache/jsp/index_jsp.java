/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-06-15 20:22:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.UsuarioJB;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header_01.jsp", Long.valueOf(1718482932288L));
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>SendinaUV</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("\t</head>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t<body class=\"w3-theme-l4\">\n");
      out.write("\t\n");
      out.write("\t");

UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
String mensaje = "";

if (usuario != null) {
    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
} else {
    mensaje = "Sesión iniciada como invitado";
}


      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("body, h1, h2, h3, h4, h5, h6  {\r\n");
      out.write("  font-family: Roboto, sans-serif;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div class=\"w3-bar w3-border w3-light-grey \">\r\n");
      out.write("<!-- \t<b class=\"w3-text-blue\">  SENDINA</b><b class=\"w3-text-green\">UV</b> -->\r\n");
      out.write("  \t<a href=\"index.jsp\" class=\"w3-bar-item w3-button w3-hover-blue\">  Inicio </a>\r\n");
      out.write("   \t<a href=\"ServletSenderoLista\" class=\"w3-bar-item w3-button  w3-hover-blue\">Senderos</a>\r\n");
      out.write("\t<a href=\"#\" class=\"w3-bar-item w3-button  w3-hover-blue\">Conocenos</a>\r\n");
      out.write("    <a href=\"#\" class=\"w3-bar-item w3-button  w3-hover-blue\">Ayuda</a>\r\n");
      out.write("  \r\n");
      out.write("\t<div class=\"w3-dropdown-click w3-right\">\r\n");
      out.write("      <button class=\"w3-button w3-hover-blue\" onclick=\"myFunction()\">\r\n");
      out.write("        &#9776;\r\n");
      out.write("      </button>\r\n");
      out.write("      <div id=\"demo\" class=\"w3-dropdown-content w3-bar-block w3-card\" style=\"display:none;right:0\">\r\n");
      out.write("     \t ");

		if (usuario == null) {
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"login.jsp\">\r\n");
      out.write("        \t<button type=\"submit\" class=\"w3-bar-item w3-button w3-hover-blue\">Iniciar sesion</button>\r\n");
      out.write("        </form> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
  
		} else {
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"ServletLogout\" method=\"get\">\r\n");
      out.write("        \t<button type=\"submit\" class=\"w3-bar-item w3-button w3-hover-blue\">Cerrar sesion</button>\r\n");
      out.write("        </form> \r\n");
      out.write("        \r\n");
      out.write("        ");
 
			if (usuario.get_rol_usuario().equals("Administrador")){
		
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <form action=\"ServletUsuarioLista\" method=\"get\">\r\n");
      out.write("        \t<button type=\"submit\" class=\"w3-bar-item w3-button w3-hover-blue\">Gestionar usuarios</button>\r\n");
      out.write("        </form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 
			}
		}
		
		
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<a class=\"w3-bar-item w3-text-gray w3-right\" >");
      out.print(mensaje);
      out.write("</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      modelo.UsuarioJB usuarios = null;
      usuarios = (modelo.UsuarioJB) _jspx_page_context.getAttribute("usuarios", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (usuarios == null){
        usuarios = new modelo.UsuarioJB();
        _jspx_page_context.setAttribute("usuarios", usuarios, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction myFunction() {\r\n");
      out.write("\t  var x = document.getElementById(\"demo\");\r\n");
      out.write("\t  if (x.className.indexOf(\"w3-show\") == -1) {\r\n");
      out.write("\t    x.className += \" w3-show\";\r\n");
      out.write("\t  } else { \r\n");
      out.write("\t    x.className = x.className.replace(\" w3-show\", \"\");\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/lib/w3-theme-blue-grey.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto\">\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<header class=\"w3-container w3-cyan w3-center\" style=\"padding:64px 16px; background: linear-gradient(315deg, #0499f2 0%, #26f596 74%);\">\n");
      out.write("<!-- \t\t<h1 class=\"w3-margin w3-jumbo\">SENDINAUV</h1> -->\n");
      out.write("\t\t<img src=\"logo.png\" class=\"w3-margin\" width=\"500\"> \n");
      out.write("\t\t\n");
      out.write("<!-- \t  \t<p class=\"w3-xlarge\">\n");
      out.write("\t  \tBienvenid@\n");
      out.write("\t  \t</p>\n");
      out.write(" -->\n");
      out.write("<!-- \t\t<button class=\"w3-button w3-black w3-padding-large w3-large w3-margin-top\">Ver senderos</button> -->\n");
      out.write("\t</header>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t<div class=\"w3-container w3-content\">\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"w3-panel  w3-display-container w3-card w3-white w3-round\">\n");
      out.write("\t  \t<p>\n");
      out.write("\t\t\tLos Senderos Interpretativos son espacios que permiten tener un contacto directo con \n");
      out.write("los visitantes para el desarrollo de una temática o un tópico particular y así, transmitir \n");
      out.write("valores sobre los cuales se quiere dar un mensaje. Cada sendero tiene un objetivo \n");
      out.write("específico que se sustenta en el desarrollo de las actividades, centrando la atención en \n");
      out.write("aspectos con los que el visitante pueda interiorizar y que, a la vez, sirva de hilo conductor \n");
      out.write("de los contenidos del mensaje.\n");
      out.write("\t\t</p>\n");
      out.write("\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
