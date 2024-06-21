/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-06-20 21:49:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.SenderoJB;
import modelo.UsuarioJB;

public final class senderosLista_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header_01.jsp", Long.valueOf(1718913346599L));
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>SendinaUV</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"custom.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"jumbotron text-center\" style=\"margin-bottom:0; background: linear-gradient(315deg, #0499f2 0%, #26f596 74%);\">\r\n");
      out.write("\t\t<img src=\"logo.png\" width=\"300\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Varela+Round&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("body, h1, h2, h3, h4, h5, h6  {\r\n");
      out.write("  font-family: \"Varela Round\", sans-serif;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");

UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
String mensaje = "";

if (usuario != null) {
    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
} else {
    mensaje = "Sesión iniciada como invitado";
}


      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-sm navbar-light sticky-top border\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"navbar-nav mr-auto\">\r\n");
      out.write("\r\n");
      out.write("\t\t<a class=\"nav-item nav-link text-dark mr-3\" href=\"index.jsp\" type=\"button\"> Inicio </a>\r\n");
      out.write("\t\t<a class=\"nav-item nav-link text-dark mr-3\" href=\"ServletSenderoLista\" > Senderos </a>\r\n");
      out.write("\t\t<a class=\"nav-item nav-link text-dark mr-3\" href=\"#\" type=\"button\"> Conocenos </a>\r\n");
      out.write("\t\t<a class=\"nav-item nav-link text-dark mr-3\" href=\"#\" type=\"button\"> Ayuda </a>\r\n");
      out.write("\t        \r\n");
      out.write("\t</div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"navbar-nav ml-auto\">\r\n");
      out.write("    \r\n");
      out.write("    \t<span class=\"navbar-text\">\r\n");
      out.write("\t    \t");
      out.print(mensaje);
      out.write("\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <div class=\"nav-item dropdown\">\r\n");
      out.write("\t      <a class=\"nav-link text-dark\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">\r\n");
      out.write("\t         &#9776;\r\n");
      out.write("\t      </a>\r\n");
      out.write("\t      <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("\t      \t");
 if (usuario == null) { 
      out.write("\r\n");
      out.write("\t        <a class=\"dropdown-item\" href=\"login.jsp\">Iniciar Sesion</a>\r\n");
      out.write("\t        ");
 } else {
      out.write("\r\n");
      out.write("\t        <a class=\"dropdown-item\" href=\"ServletLogout\">Cerrar sesion</a>\r\n");
      out.write("\t        ");
 if (usuario.get_rol_usuario().equals("Administrador")){ 
      out.write("\r\n");
      out.write("\t        <a class=\"dropdown-item\" href=\"ServletUsuarioLista\">Gestionar usuarios</a>\r\n");
      out.write("\t        ");
 }} 
      out.write("\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      modelo.UsuarioJB usuarios = null;
      usuarios = (modelo.UsuarioJB) _jspx_page_context.getAttribute("usuarios", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (usuarios == null){
        usuarios = new modelo.UsuarioJB();
        _jspx_page_context.setAttribute("usuarios", usuarios, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"container\" style=\"margin-top:30px; margin-bottom:30px\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<nav class=\"navbar navbar-expand-sm navbar-light \">\r\n");
      out.write("\t\t\t<ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("\t\t\t\t<span class=\"navbar-text text-dark\">\r\n");
      out.write("\t\t\t    \t<h1>Senderos Interpretativos</h1>\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\t\t\t\t\t");

					if (usuario != null) {
						if (usuario.get_rol_usuario().equals("Administrador")) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<form action=\"ServletSenderoCargar\" method=\"get\" accept-charset=\"UTF-8\">\r\n");
      out.write("\t\t\t\t\t\t<input id=\"id_sendero\" type=hidden name=\"id_sendero\" value=\"0\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Agregar Sendero\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t");

						}
					}
					
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t\r\n");
      out.write("<!-- \t\t<hr> -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t");

			@SuppressWarnings("unchecked")
			List<SenderoJB> lista = (List<SenderoJB>) request.getAttribute("lista");
			if (lista != null) {
				for (SenderoJB sendero : lista) {
					String url_recursos = sendero.get_url_recursos();
					String logo_url = request.getContextPath() + "/senderos/" + url_recursos;
					//out.print(logo_url);
			
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<div class=\"card rounded clearfix \">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t<img  src=\"");
      out.print(logo_url);
      out.write("\" style=\"width: 100%; aspect-ratio: 1/1;\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body bg-light text-center\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t<h5 class=\"text-primary\"> ");
 out.print(sendero.get_nombre()); 
      out.write(" </h5>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"text-secondary\"> ");
 out.print(sendero.get_sede()); 
      out.write(" </p>\r\n");
      out.write("\t\r\n");
      out.write("<!-- \t\t\t\t\t\t<form action=\"ServletSenderoVer\" method=\"get\" accept-charset=\"UTF-8\"> -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t<input type=\"submit\" value=\"Ver sendero\" class=\"btn btn-primary\"> -->\r\n");
      out.write("<!-- \t\t\t\t\t\t</form> -->\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a href=\"ServletSenderoVer?id_sendero=");
      out.print(sendero.get_id_sendero());
      out.write("\" class=\"btn btn-primary card-link\">Ver sendero</a>\r\n");
      out.write("    \t\t\t\t\t\r\n");
      out.write("    \t\t\t\t\t");
 if (usuario != null) { 
      out.write("\r\n");
      out.write("    \t\t\t\t\t\t<a href=\"ServletSenderoCargar?id_sendero=");
      out.print(sendero.get_id_sendero());
      out.write("\" class=\"btn btn-secondary card-link\">Editar</a>\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t");

				}
			} else {
			out.print("No hay nada");
			}
			
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t</div>\r\n");
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
