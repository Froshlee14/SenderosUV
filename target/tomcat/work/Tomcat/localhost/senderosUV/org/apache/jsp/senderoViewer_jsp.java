/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-06-10 01:25:05 UTC
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
import modelo.SenderoJB;
import modelo.EstacionJB;

public final class senderoViewer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header_01.jsp", Long.valueOf(1717976515193L));
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>SendinaUV</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\t#map {\r\n");
      out.write("\t    \theight: 500px; /* The height is 400 pixels */\r\n");
      out.write("\t    \twidth: 100%; /* The width is the width of the web page */\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#info {\r\n");
      out.write("\t    \theight: 500px; /* The height is 400 pixels */\r\n");
      out.write("\t    \twidth: 30%; /* The width is the width of the web page */\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t.mySlides {display:none}\r\n");
      out.write("\t\t.w3-left, .w3-right, .w3-badge {cursor:pointer}\r\n");
      out.write("\t\t.w3-badge {height:13px;width:13px;padding:0}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".price-tag {\r\n");
      out.write("  background-color: #4285F4;\r\n");
      out.write("  border-radius: 8px;\r\n");
      out.write("  color: #FFFFFF;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  padding: 10px 15px;\r\n");
      out.write("  position: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".price-tag::after {\r\n");
      out.write("  content: \"\";\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  left: 50%;\r\n");
      out.write("  top: 100%;\r\n");
      out.write("  transform: translate(-50%, 0);\r\n");
      out.write("  width: 0;\r\n");
      out.write("  height: 0;\r\n");
      out.write("  border-left: 8px solid transparent;\r\n");
      out.write("  border-right: 8px solid transparent;\r\n");
      out.write("  border-top: 8px solid #4285F4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</style>\r\n");
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
      out.write("  \t\r\n");
      out.write("<!--     <form action=\"login.jsp\" method=\"get\" class=\"nav-form w3-right\"> -->\r\n");
      out.write("<!--         <button type=\"submit\" class=\"w3-bar-item w3-button w3-hover-blue nav-button w3-blue\">Iniciar sesion</button> -->\r\n");
      out.write("<!--     </form> -->\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"w3-dropdown-click w3-right w3-blue\">\r\n");
      out.write("      <button class=\"w3-button\" onclick=\"myFunction()\">\r\n");
      out.write("        &#9776;\r\n");
      out.write("      </button>\r\n");
      out.write("      <div id=\"demo\" class=\"w3-dropdown-content w3-bar-block w3-card\" style=\"display:none;right:0\">\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button\">Iniciar sesion</a>\r\n");
      out.write("        <a href=\"#\" class=\"w3-bar-item w3-button\">Editar usuarios</a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <a href=\"#\" class=\"w3-bar-item w3-button w3-right w3-hover-blue\">Ayuda</a>\r\n");
      out.write("\t<a href=\"#\" class=\"w3-bar-item w3-button w3-right w3-hover-blue\">Conocenos</a>\r\n");
      out.write("\t<a href=\"ServletSenderoLista\" class=\"w3-bar-item w3-button w3-right w3-hover-blue\">Senderos</a>\r\n");
      out.write("\t<a class=\"w3-bar-item w3-text-gray\" >");
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
      out.write("<style>\r\n");
      out.write("body, h1, h2, h3, h4, h5, h6  {\r\n");
      out.write("  font-family: Roboto, sans-serif;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

			int id_sendero = 0;
			String nombre = "Sendero nombre ejemplo";
			String sede = "Sendero sede ejemplo";
			String year = "2024-04-11";
			int zona = 1;
			String url_recursos = "Inserte URL aqui";
			
			SenderoJB sendero = (SenderoJB) request.getAttribute("sendero");
			if (sendero != null) {
				id_sendero = sendero.get_id_sendero();
				nombre = sendero.get_nombre();
				sede = sendero.get_sede();
				
				Date date = sendero.get_year();
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        year = sdf.format(date);
		        
		        zona = sendero.get_id_zona();
				url_recursos = sendero.get_url_recursos();
				
			}
			
			
			@SuppressWarnings("unchecked")
			List<EstacionJB> estaciones = (List<EstacionJB>) request.getAttribute("estaciones");
			
			if (estaciones != null && !estaciones.isEmpty() ) {
				for (EstacionJB estacion : estaciones) {

					estacion.get_nombre();
					estacion.get_latitud();
					estacion.get_longitud();
				}
			}
			else {
				out.print("Este sendero no tiene estaciones");
			}

    	
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"w3-container w3-content\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<p> <b> ");
      out.print(nombre);
      out.write(" </b> </p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"w3-panel w3-white w3-card w3-display-container\">\r\n");
      out.write("\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t<div class=\"w3-cell-row\">\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t\t\t<div id=\"info\" class=\"w3-container w3-light-grey w3-cell\">\r\n");
      out.write("\t\t\t\t\t<!--Aqui va la info -->\r\n");
      out.write("\t\t\t\t\t\t");
 if (estaciones != null && !estaciones.isEmpty()) { 
      out.write("\r\n");
      out.write("\t                        ");
 for (int i = 0; i < estaciones.size(); i++) { 
	                            EstacionJB estacion = estaciones.get(i); 
      out.write("\r\n");
      out.write("\t                            <div class=\"mySlides\" style=\"display: none;\">\r\n");
      out.write("\t                                <h3>");
      out.print( estacion.get_nombre() );
      out.write("</h3>\r\n");
      out.write("\t                                <p>Latitud: ");
      out.print( estacion.get_latitud() );
      out.write("</p>\r\n");
      out.write("\t                                <p>Longitud: ");
      out.print( estacion.get_longitud() );
      out.write("</p>\r\n");
      out.write("\t                                <p>Descripción: ");
      out.print( estacion.get_descripcion() );
      out.write("</p>\r\n");
      out.write("\t                            </div>\r\n");
      out.write("\t                        ");
 } 
      out.write("\r\n");
      out.write("\t                    ");
 } 
      out.write("\r\n");
      out.write("\t \t\t\t\t</div>\r\n");
      out.write("\t \t\t\t\t\r\n");
      out.write("\t \t\t\t\t<div class=\"w3-light-grey w3-cell\">\r\n");
      out.write("\t \t\t\t\t\t<div id=\"map\" class=\"w3-container\">\r\n");
      out.write("\t\t\t\t\t\t<!--Aqui va el mapa --> \r\n");
      out.write("\t \t\t\t\t\t</div>\r\n");
      out.write("\t \t\t\t\t\t<div id=\"navbar\" class=\"w3-center w3-container w3-large w3-blue\" style=\"width:100%\">\r\n");
      out.write("<!-- \t\t\t\t\t\t  <div class=\" \" style=\"width:100%\"> -->\r\n");
      out.write("\t\t\t\t\t\t    <button class=\"w3-button w3-left\" onclick=\"plusDivs(-1)\">&#10094; Prev</button>\r\n");
      out.write("  \t\t\t\t\t\t\t<button class=\"w3-button w3-right\" onclick=\"plusDivs(1)\">Next &#10095;</button>\r\n");
      out.write("  \t\t\t\t\t\t\t");
 for (int i = 0; i < estaciones.size(); i++) { 
      out.write("\r\n");
      out.write("                            \t<button class=\"w3-button demo\" onclick=\"currentDiv(");
      out.print( i + 1 );
      out.write(')');
      out.write('"');
      out.write('>');
      out.print( i + 1 );
      out.write("</button>\r\n");
      out.write("                        \t");
 } 
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t  </div> -->\r\n");
      out.write("\t \t\t\t\t\t</div>\r\n");
      out.write("\t \t\t\t\t\t\r\n");
      out.write("\t \t\t\t\t</div>\r\n");
      out.write("\t    \t\t</div>\r\n");
      out.write("\t    \t\t<p></p>\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("  (g=>{var h,a,k,p=\"The Google Maps JavaScript API\",c=\"google\",l=\"importLibrary\",q=\"__ib__\",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement(\"script\"));e.set(\"libraries\",[...r]+\"\");for(k in g)e.set(k.replace(/[A-Z]/g,t=>\"_\"+t[0].toLowerCase()),g[k]);e.set(\"callback\",c+\".maps.\"+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+\" could not load.\"));a.nonce=m.querySelector(\"script[nonce]\")?.nonce||\"\";m.head.append(a)}));d[l]?console.warn(p+\" only loads once. Ignoring:\",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})({\r\n");
      out.write("    key: \"AIzaSyANYrOfEcKN46yxrjSmY6JTjXLlpXKBK7w\",\r\n");
      out.write("    v: \"weekly\",\r\n");
      out.write("    // Use the 'v' parameter to indicate the version to use (weekly, beta, alpha, etc.).\r\n");
      out.write("    // Add other bootstrap parameters as needed, using camel case.\r\n");
      out.write("  });\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  let map;\r\n");
      out.write("  var slideIndex = 0;\r\n");
      out.write("\r\n");
      out.write("  //Cargamos las estaciones \r\n");
      out.write("  const estaciones = [\r\n");
      out.write("      ");
 if (estaciones != null && !estaciones.isEmpty()) { 
      out.write("\r\n");
      out.write("          ");
 for (int i = 0; i < estaciones.size(); i++) { 
              EstacionJB estacion = estaciones.get(i); 
      out.write("\r\n");
      out.write("              {\r\n");
      out.write("                  nombre: \"");
      out.print( estacion.get_nombre() );
      out.write("\",\r\n");
      out.write("                  numero: ");
      out.print( estacion.get_numero() );
      out.write(",        \r\n");
      out.write("                  latitud: ");
      out.print( estacion.get_latitud() );
      out.write(",\r\n");
      out.write("                  longitud: ");
      out.print( estacion.get_longitud() );
      out.write("\r\n");
      out.write("              }");
      out.print( (i < estaciones.size() - 1) ? "," : "" );
      out.write("\r\n");
      out.write("          ");
 } 
      out.write("\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("  ];\r\n");
      out.write("  \r\n");
      out.write("  async function initMap() {\r\n");
      out.write("    // The location of Uluru\r\n");
      out.write("    const position = { lat: -25.344, lng: 131.031 };\r\n");
      out.write("    \r\n");
      out.write("    //Si no hay senderos mostramos una posicion inicial predefinida\r\n");
      out.write("    let initialPosition;\r\n");
      out.write("    if (estaciones.length > 0) {\r\n");
      out.write("        initialPosition = { lat: estaciones[0].latitud, lng: estaciones[0].longitud };\r\n");
      out.write("    } else {\r\n");
      out.write("        initialPosition = { lat: -25.344, lng: 131.031 };\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    // Request needed libraries.\r\n");
      out.write("    //@ts-ignore\r\n");
      out.write("    const { Map } = await google.maps.importLibrary(\"maps\");\r\n");
      out.write("    const { AdvancedMarkerElement } = await google.maps.importLibrary(\"marker\");\r\n");
      out.write("\r\n");
      out.write("    // Configuracion del mapa\r\n");
      out.write("    const zoom = 18\r\n");
      out.write("    map = new Map(document.getElementById(\"map\"), {\r\n");
      out.write("\r\n");
      out.write("      zoom: zoom,\r\n");
      out.write("      minZoom: zoom - 1,\r\n");
      out.write("      maxZoom: zoom + 2,\r\n");
      out.write("      gestureHandling: \"cooperative\",\r\n");
      out.write("\r\n");
      out.write("      center: initialPosition,\r\n");
      out.write("      mapId: \"DEMO_MAP_ID\",\r\n");
      out.write("      //disableDefaultUI: true,\r\n");
      out.write("      streetViewControl: false,\r\n");
      out.write("      mapTypeControl: true,\r\n");
      out.write("      zoomControl: true,\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    estaciones.forEach(estacion => {\r\n");
      out.write("    \t\r\n");
      out.write("    \t//const priceTag = document.createElement(\"div\");\r\n");
      out.write("    \t//priceTag.className = \"price-tag\";\r\n");
      out.write("    \t//priceTag.textContent = \"#\"+estacion.numero;\r\n");
      out.write("        new AdvancedMarkerElement({\r\n");
      out.write("            map: map,\r\n");
      out.write("            position: { lat: estacion.latitud, lng: estacion.longitud },\r\n");
      out.write("            title: estacion.nombre,\r\n");
      out.write("            //content:priceTag,\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("\t//Variable para el control del slide\r\n");
      out.write("\tslideIndex = 1;\r\n");
      out.write("\tshowDivs(slideIndex);\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  initMap();\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write(" \t//Funcion para centrar el mapa a un punto en especifico \r\n");
      out.write("\tfunction centerMap(lat, lng) {\r\n");
      out.write("            map.panTo({ lat: lat, lng: lng });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\t//Funcion para aumentar el indice del slide\r\n");
      out.write("\tfunction plusDivs(n) {\r\n");
      out.write("\t  showDivs(slideIndex += n);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//Funcion para ir a un indice del slide en especifico\r\n");
      out.write("\tfunction currentDiv(n) {\r\n");
      out.write("\t  showDivs(slideIndex = n);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//Funcion para mostrar la informacion del slide actual en\r\n");
      out.write("\t//el div de informacion\r\n");
      out.write("\tfunction showDivs(n) {\r\n");
      out.write("\t  var i;\r\n");
      out.write("\t  var x = document.getElementsByClassName(\"mySlides\");\r\n");
      out.write("\t  var dots = document.getElementsByClassName(\"demo\");\r\n");
      out.write("\t  if (n > x.length) {slideIndex = 1}\r\n");
      out.write("\t  if (n < 1) {slideIndex = x.length}\r\n");
      out.write("\t  for (i = 0; i < x.length; i++) {\r\n");
      out.write("\t    x[i].style.display = \"none\";  \r\n");
      out.write("\t  }\r\n");
      out.write("\t  for (i = 0; i < dots.length; i++) {\r\n");
      out.write("\t    dots[i].className = dots[i].className.replace(\" w3-white\", \"\");\r\n");
      out.write("\t  }\r\n");
      out.write("\t  x[slideIndex-1].style.display = \"block\";  \r\n");
      out.write("\t  dots[slideIndex-1].className += \" w3-white\";\r\n");
      out.write("\t  \r\n");
      out.write("\t  const estacion = estaciones[slideIndex - 1];\r\n");
      out.write("      centerMap(estacion.latitud, estacion.longitud);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
