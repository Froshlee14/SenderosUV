/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-06-11 01:22:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import modelo.UsuarioJB;
import modelo.EstacionJB;

public final class estacionEditor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header_02.jsp", Long.valueOf(1718068443122L));
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>SendinaUV</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body class=\"w3-theme-l4\">\r\n");
      out.write("\r\n");
      out.write("\t\t");

UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
String mensaje = "";

if (usuario != null) {
    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
} else {
    mensaje = "Sesión iniciada como invitado";
}


      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"w3-bar w3-border w3-light-grey \">\r\n");
      out.write("  \t<a href=\"index.jsp\" class=\"w3-bar-item w3-button\"> <b class=\"w3-text-blue\">SENDINA</b><b class=\"w3-text-green\">UV</b> </a>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"w3-dropdown-click w3-right w3-hover-blue\">\r\n");
      out.write("      <button class=\"w3-button\" onclick=\"myFunction()\">\r\n");
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
      out.write("   \r\n");
      out.write("\t<a class=\"w3-bar-item w3-text-gray\" >");
      out.print(mensaje);
      out.write("</a>\r\n");
      out.write("\t<a href=\"ServletSenderoLista\" class=\"w3-bar-item w3-button w3-right w3-hover-blue\">Senderos</a>\r\n");
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
      out.write("<style>\r\n");
      out.write("body, h1, h2, h3, h4, h5, h6  {\r\n");
      out.write("  font-family: Roboto, sans-serif;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

			int id_sendero = (Integer) request.getAttribute("id_sendero");
			int id_estacion = 0;
			int numero = 0;
			String nombre = "Nombre de estacion ejemplo";
			String descripcion = "Esta es una descripcion breve de la estacion";
			String latitud = "";
			String longitud = "";
			
			EstacionJB estacion = (EstacionJB) request.getAttribute("estacion");
			if (estacion != null) {
				id_estacion = estacion.get_id_estacion();
				numero = estacion.get_numero();
				nombre = estacion.get_nombre();
				descripcion = estacion.get_descripcion();
				latitud = estacion.get_latitud();
				longitud = estacion.get_longitud();
				
			}
		
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"w3-container w3-content\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p> </p>\r\n");
      out.write("\t\t<div class=\"w3-bar\">\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <a href=\"#\" class=\"w3-bar-item w3-button\"> <b> Información del sendero </b> </a>\r\n");
      out.write("\t\t  ");
 if (estacion != null) { 
      out.write("\r\n");
      out.write("\t\t  \t<a href=\"#\" class=\"w3-bar-item w3-button w3-hover-red w3-right\" onclick=\"prepareSubmit('borrar')\">Eliminar</a>\r\n");
      out.write("\t\t  ");
 } 
      out.write("\r\n");
      out.write("\t\t  <a href=\"#\" class=\"w3-bar-item w3-button w3-hover-blue w3-right\" onclick=\"prepareSubmit('guardar')\">");
      out.print( (estacion != null) ? "Actualizar" : "Guardar" );
      out.write("</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"w3-panel w3-white w3-card w3-display-container\">\r\n");
      out.write(" \t\t\r\n");
      out.write(" \t\t\t<p></p>\r\n");
      out.write("\t\t\t<form class=\"w3-container\" id=\"estacionForm\" method=\"post\" accept-charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<input id=\"id_sendero\" type=hidden name=\"id_sendero\" value=\"");
      out.print(id_sendero);
      out.write("\">  \r\n");
      out.write("\t    \t\t<input id=\"id_estacion\" type=hidden name=\"id_estacion\" value=\"");
      out.print(id_estacion);
      out.write("\">  \r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t\t\t\t<label class=\"w3-text-blue\" for=\"nombre\">Nombre de la estacion:</label>\r\n");
      out.write("    \t\t\t<input class=\"w3-input w3-border\" id=\"nombre\" type=\"text\"  value=\"");
      out.print(nombre);
      out.write("\" maxlength=\"50\" name=\"nombre\">\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\t<label class=\"w3-text-blue\" for=\"descripcion\">Descripción:</label>\r\n");
      out.write("    \t\t\t<input class=\"w3-input w3-border\" id=\"descripcion\" type=\"text\" value=\"");
      out.print(descripcion);
      out.write("\" maxlength=\"200\" name=\"descripcion\" >\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<label class=\"w3-text-blue\" for=\"nombre\">Numero de estacion:</label>\r\n");
      out.write("    \t\t\t<input class=\"w3-input w3-border\" id=\"numero\" type=\"number\"  value=\"");
      out.print(numero);
      out.write("\" name=\"numero\">\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t\t<label class=\"w3-text-blue\" for=\"url_recursos\">Latitud:</label>\r\n");
      out.write("    \t\t\t<input class=\"w3-input w3-border\" id=\"latitud\" type=\"text\"  value=\"");
      out.print(latitud);
      out.write("\" maxlength=\"20\" name=\"latitud\">\r\n");
      out.write("    \t\t\t\r\n");
      out.write("\t    \t\t<label class=\"w3-text-blue\" for=\"url_recursos\">Longitud:</label>\r\n");
      out.write("    \t\t\t<input class=\"w3-input w3-border\" id=\"longitud\" type=\"text\"  value=\"");
      out.print(longitud);
      out.write("\" maxlength=\"20\" name=\"longitud\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("    \t\t</form>\r\n");
      out.write("    \t\t<p></p>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\t\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t    function prepareSubmit(action) {\r\n");
      out.write("\t        var form = document.getElementById('estacionForm');\r\n");
      out.write("\t        \r\n");
      out.write("\t        if (action === 'guardar') {\r\n");
      out.write("\t            form.method = 'post';\r\n");
      out.write("\t            form.action = 'ServletEstacionGuardar';\r\n");
      out.write("\t        } else if (action === 'borrar') {\r\n");
      out.write("\t            form.method = 'get';\r\n");
      out.write("\t            form.action = 'ServletEstacionBorrar';\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t        form.submit();\r\n");
      out.write("\t    }\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t</body>\r\n");
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
