<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SendinaUV</title>
	</head>

	<body class="w3-theme-l4">

		<%@ include file="header_03.jsp" %>
		
		
		<div class="w3-container w3-content w3-padding">
		
		
		
		<div class="w3-bar">
		  
			<a href="#" class="w3-bar-item w3-button"> <b> Usuarios </b> </a>
		  
			<form action="ServletUsuarioCargar" method="get" accept-charset="UTF-8">
				<input id="id_usuario" type=hidden name="id_usuario" value="0">
				<input type="submit" value="Agregar usuario" class="w3-bar-item w3-button w3-hover-green w3-right">
			</form>
		  
		</div>
		


		<%
		@SuppressWarnings("unchecked")
		List<UsuarioJB> lista = (List<UsuarioJB>) request.getAttribute("lista");
		if (lista != null) {
			for (UsuarioJB usuario : lista) {
				String nombre = usuario.get_nombre();
				String rol = usuario.get_rol_usuario();
				//out.print(logo_url);
				
		%>
		
		<div class="w3-panel w3-white w3-card w3-round-large w3-display-container">
		

				<form action="ServletUsuarioCargar" method="get" accept-charset="UTF-8">
					<input id="id_usuario" type=hidden name="id_usuario" value="<%=usuario.get_id_usuario()%>">
					<input type="submit" value="Editar" class="w3-button w3-hover-blue w3-display-topright">
				</form>	
					
				<h4> <%out.print(nombre);%> </h4>
				<p class="w3-text-gray"> Rol de usuario:  <%out.print(rol);%> </p>

					
				
		</div>
			 
		<%
			}
		}
		else {
			out.print("No hay nada");
		}
		%>
	
		</div>
	</body>
</html>