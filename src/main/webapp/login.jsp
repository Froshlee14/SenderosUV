<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SendinaUV</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>

	<body>
		<div class="w3-container">
			<form action="ServletLogin" method="post" class="w3-container">
					<label class="w3-text-blue" for="usuario">Usuario:</label> 
					<input class="w3-input w3-border" id="usuario" type="text" name="inputUsuario">

					<label class="w3-text-blue" for="password">Contraseña:</label> 
					<input class="w3-input w3-border" id="password" type="password" name="inputPassword">


					<input type="submit" name="loginBoton" value="Iniciar Sesion">

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

</body>

</html>