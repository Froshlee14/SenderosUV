<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SendinaUV</title>
	</head>

	<body class="w3-theme-l4">
	
		<%@ include file="header_03.jsp" %>
	
		<div>
		
		
			<div class="w3-panel w3-white w3-display-middle w3-card" style="width:300px">
			
				<form action="ServletLogin" method="post" >
				
					<p> </p>
					<label class="w3-text-blue" for="usuario">Usuario:</label> 
					<input class="w3-input w3-border" id="usuario" type="text" name="inputUsuario">

					<label class="w3-text-blue" for="password">Contraseña:</label> 
					<input class="w3-input w3-border" id="password" type="password" name="inputPassword">

					<p> </p>
					<input type="submit" name="loginBoton" value="Iniciar Sesion" class="w3-button w3-hover-light-grey w3-blue">
					<p> </p>
							
				</form>
	
				<%
				String mensaje = (String) request.getAttribute("mensaje_login");
				if (mensaje != null && !mensaje.isEmpty()) {
				%>
				<p><%=mensaje%></p>
				<%
				}
				%>
			</div>

		</div>

</body>

</html>