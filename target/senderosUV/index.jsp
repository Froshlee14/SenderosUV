<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>
<body>
	<h2>Hello World!</h2>

	<jsp:useBean id="usuarios" class="modelo.UsuarioJB" scope="request" />

	<%
	UsuarioJB usuario = (UsuarioJB) request.getAttribute("usuario");
	String mensaje = (String) request.getAttribute("mensaje_sesion");

	if (mensaje != null && !mensaje.isEmpty()) {
	%>
	<p><%=mensaje%></p>
	<%
	}
	%>

	<form action="login.jsp" method="get">
		<button type="submit">Iniciar sesion</button>
	</form>



</body>
</html>
