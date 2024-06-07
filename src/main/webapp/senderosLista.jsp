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

		<%@ include file="headerMenu.jsp" %>
		
		<form action="ServletSenderoCargar" method="get" accept-charset="UTF-8">
			<input id="id_sendero" type=hidden name="id_sendero" value="0">
 			<input type="submit" value="Agregar Sendero" class="w3-button w3-blue">
    	</form>

		<%
		@SuppressWarnings("unchecked")
		List<SenderoJB> lista = (List<SenderoJB>) request.getAttribute("lista");
		if (lista != null) {
			for (SenderoJB sendero : lista) {
				String url_recursos = sendero.get_url_recursos();
				String logo_url = url_recursos + "/logo.png";
				
		%>
			<%--<tr onclick="seleccionarAutobus(<%= autobus.getNumUnidad() %>,this)"> --%>
			
			<form action="ServletSenderoCargar" method="get" accept-charset="UTF-8">
				<input id="id_sendero" type=hidden name="id_sendero" value="<%=sendero.get_id_sendero()%>">
				<p><%out.print(sendero.get_nombre());%> </p>
				<img src="<%= logo_url %>" width="200" height="200">
 				<input type="submit" value="Editar Sendero" class="w3-button w3-grey">
    		</form>
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