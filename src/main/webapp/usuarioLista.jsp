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
		
		
		<div class="w3-row-padding">
		


		<%
		@SuppressWarnings("unchecked")
		List<UsuarioJB> lista = (List<UsuarioJB>) request.getAttribute("usuarios");
		if (lista != null) {
			for (UsuarioJB usuario : lista) {
				String nombre = usuario.get_nombre();
				String rol = usuario.get_rol_usuario();
				//out.print(logo_url);
				
		%>
		
		<div class="w3-quarter w3-section ">
		
			<div class=" w3-white w3-round-large w3-border w3-display-container">

				<form action="ServletSenderoCargar" method="get" accept-charset="UTF-8">
					<input id="id_sendero" type=text name="id_sendero" value="<%=usuario.get_id_usuario()%>">
					<input type="submit" value="Editar" class="w3-button w3-hover-blue w3-display-topright">
				</form>	
					
				<h4> <%out.print(nombre);%> </h4>
				<p class="w3-text-gray"> <%out.print(rol);%> </p>

						
			</div>	
				
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