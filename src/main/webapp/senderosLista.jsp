<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>

<head>
	<title>SendinaUV</title>
	<link rel="stylesheet" type="text/css" href="custom.css" />
</head>

<body>

	<div class="jumbotron text-center" style="margin-bottom:0; background: linear-gradient(315deg, #0499f2 0%, #26f596 74%);">
		<img src="logo.png" width="300">
	</div>

	<%@ include file="header_01.jsp"%>
	
	<div class="container" style="margin-top:30px; margin-bottom:30px">
	
		<nav class="navbar navbar-expand-sm navbar-light ">
			<ul class="navbar-nav mr-auto">
				<span class="navbar-text text-dark">
			    	<h1>Senderos Interpretativos</h1>
				</span>
			</ul>
			
			<ul class="navbar-nav ml-auto">
					<%
					if (usuario != null) {
						if (usuario.get_rol_usuario().equals("Administrador")) {
					%>
					<form action="ServletSenderoCargar" method="get" accept-charset="UTF-8">
						<input id="id_sendero" type=hidden name="id_sendero" value="0">
						<input type="submit" value="Agregar Sendero" class="btn btn-primary">
					</form>
					<%
						}
					}
					%>
			</ul>
		</nav>
		
<!-- 		<hr> -->
	
		<div class="row">
	
			<%
			@SuppressWarnings("unchecked")
			List<SenderoJB> lista = (List<SenderoJB>) request.getAttribute("lista");
			if (lista != null) {
				for (SenderoJB sendero : lista) {
					String url_recursos = sendero.get_url_recursos();
					String logo_url = request.getContextPath() + "/senderos/" + url_recursos;
					//out.print(logo_url);
			%>
	
			<div class="col-sm-4">
	
				<div class="card rounded clearfix ">
	
					<img  src="<%=logo_url%>" style="width: 100%; aspect-ratio: 1/1;">
					
					<div class="card-body bg-light text-center">
	
						<h5 class="text-primary"> <% out.print(sendero.get_nombre()); %> </h5>
						<p class="text-secondary"> <% out.print(sendero.get_sede()); %> </p>
	
<!-- 						<form action="ServletSenderoVer" method="get" accept-charset="UTF-8"> -->
<%-- 							<input id="id_sendero" type=hidden name="id_sendero" value="<%=sendero.get_id_sendero()%>"> --%>
<!-- 							<input type="submit" value="Ver sendero" class="btn btn-primary"> -->
<!-- 						</form> -->
						
						<a href="ServletSenderoVer?id_sendero=<%=sendero.get_id_sendero()%>" class="btn btn-primary card-link">Ver sendero</a>
    					
    					<% if (usuario != null) { %>
    						<a href="ServletSenderoCargar?id_sendero=<%=sendero.get_id_sendero()%>" class="btn btn-secondary card-link">Editar</a>
						<% } %>
						
					</div>
	
				</div>
	
			</div>
	
			<%
				}
			} else {
			out.print("No hay nada");
			}
			%>
	
		</div>
	</div>

</body>
</html>