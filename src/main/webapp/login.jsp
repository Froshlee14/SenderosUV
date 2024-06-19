<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SendinaUV</title>
	</head>

	<body class="bg-light text-center">
	
		<%@ include file="header_03.jsp" %>
			
		<div class="card pt-3 mx-auto align-self-center " style="width:300px">
			<form action="ServletLogin" method="post" class="form-signin">
			

			<img class="rounded " src="icon.ico" alt="" width="72" height="72">

			
			<div class="card-body ">
			
				
				<div class="form-group">
<!-- 					<label for="usuario">Usuario:</label>  -->
					<input class="form-control" id="usuario" type="text" name="inputUsuario" placeholder="Nombre">
				</div>

				<div class="form-group">
<!-- 					<label class="w3-text-blue" for="password">Contraseña:</label>  -->
					<input class="form-control" id="password" type="password" name="inputPassword" placeholder="Contraseña">
				</div>

				<div class=" text-center">
					<input type="submit" name="loginBoton" value="Iniciar Sesion" class="btn btn-primary btn-block">
				</div>
			</div>
			
			</form>
		</div>
			
		<%
		String mensaje = (String) request.getAttribute("mensaje_login");
		if (mensaje != null && !mensaje.isEmpty()) {
		%>
		<p><%=mensaje%></p>
		<%
		}
		%>

	</body>

</html>