<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>


	<head>
		<title>SendinaUV</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
	</head>

	<body class="w3-theme-l4">

		<%@ include file="headerMenu.jsp" %>
		
		<div class="w3-container w3-padding-32 w3-theme-d1">
			<h1>Senderos interpetativos</h1>
		</div>
		
		<div class="w3-row-padding">
		
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
		
		<div class="w3-third w3-section ">
				<form action="ServletSenderoCargar" method="get" accept-charset="UTF-8">
					<input id="id_sendero" type=hidden name="id_sendero" value="<%=sendero.get_id_sendero()%>">
					
					<div class="w3-container w3-white w3-round-large w3-border w3-display-container">
						<h4> <%out.print(sendero.get_nombre());%> </h4>
						<img src="<%= logo_url %>" style="width:100%; height:200px;">
						<input type="submit" value="Editar" class="w3-button w3-hover-blue w3-display-topright">
					</div>
					
    			</form>
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