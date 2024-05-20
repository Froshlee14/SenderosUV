<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>


	<head>
		<title>SendinaUV</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>

	<body>

		<%
		UsuarioJB usuario = (UsuarioJB) request.getAttribute("usuario");
		String mensaje = "";
		//out.println("JSP: "+usuario);
		
		if (usuario != null) {
		    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
		} else {
		    mensaje = "Sesión iniciada como invitado";
		}
		
		session.setAttribute("usuario", usuario);
		%>
	
		<div class="w3-bar w3-border w3-light-grey">
		  <a href="ServletIndex" class="w3-bar-item w3-button">SENDINA UV</a>
        <form action="login.jsp" method="get" class="nav-form w3-right">
            <button type="submit" class="w3-bar-item w3-button w3-hover-blue nav-button w3-blue">Iniciar sesion</button>
        </form>
        	<a href="#" class="w3-bar-item w3-button w3-right w3-hover-blue">Ayuda</a>
			<a href="#" class="w3-bar-item w3-button w3-right w3-hover-blue">Conocenos</a>
			<a href="ServletSenderosLista" class="w3-bar-item w3-button w3-right w3-hover-blue">Senderos</a>
		</div>
	
		<jsp:useBean id="usuarios" class="modelo.UsuarioJB" scope="request" />
	
		<p><%= mensaje %></p>
		
		

		<!-- Fin de encabezado -->
		<%
		@SuppressWarnings("unchecked")
		List<SenderoJB> lista = (List<SenderoJB>) request.getAttribute("lista");
		if (lista != null) {
			for (SenderoJB sendero : lista) {
		%>
			<%--<tr onclick="seleccionarAutobus(<%= autobus.getNumUnidad() %>,this)"> --%>
			<p><%out.print(sendero.get_id_sendero());%> </p>
			<%out.print(sendero.get_nombre());%>
			<%out.print(sendero.get_nombre_sede());%>
			<%out.print(sendero.get_year());%>
			<p> </p>
			 
		<%
			}
		}
		else {
			out.print("No hay nada");
		}
		%>
	
	</body>
</html>