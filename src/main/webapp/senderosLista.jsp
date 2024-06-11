<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SendinaUV</title>
	</head>

	<body class="w3-theme-l4">

		<%@ include file="header_01.jsp" %>
		
		<div class="w3-bar w3-theme-d1 w3-border w3-light-grey w3-display-container">
			<div class="w3-container w3-bar-item">
				<h1>Senderos interpetativos</h1>
			</div>
			
			
	     	<%
			if (usuario != null) {
				//out.print(usuario.get_rol_usuario());
				if (usuario.get_rol_usuario().equals("Administrador")){
			%>
				
			<div class="w3-container w3-bar-item w3-display-right">
				<form action="ServletSenderoCargar" method="get" accept-charset="UTF-8">
					<input id="id_sendero" type=hidden name="id_sendero" value="0">
 					<input type="submit" value="Agregar Sendero" class="w3-button w3-light-blue w3-hover-light-gray w3-round">
    			</form>
    		</div>
				
			<%  
				}
			}
	     	%>
			
		</div>
		
		<div class="w3-row-padding">
		


		<%
		@SuppressWarnings("unchecked")
		List<SenderoJB> lista = (List<SenderoJB>) request.getAttribute("lista");
		if (lista != null) {
			for (SenderoJB sendero : lista) {
				String url_recursos = sendero.get_url_recursos();
				String logo_url = request.getContextPath() + "/" + url_recursos + "/logo.png";
				//out.print(logo_url);
				
		%>
		
		<div class="w3-quarter w3-section ">
		
			<div class=" w3-white w3-round-large w3-border w3-display-container">

			
		     	<%
				if (usuario != null) {
				%>
				
				<form action="ServletSenderoCargar" method="get" accept-charset="UTF-8">
					<input id="id_sendero" type=hidden name="id_sendero" value="<%=sendero.get_id_sendero()%>">
					<input type="submit" value="Editar" class="w3-button w3-hover-blue w3-display-topright">
				</form>
				
				<%  
				}
				%>	
					
				
				<div class="w3-light-gray">
					<img src="<%= logo_url %>" style="width:100%; aspect-ratio: 1 / 1;">
				</div>
				<div class="w3-light-gray w3-container w3-round-large w3-center">
					
					<h4> <%out.print(sendero.get_nombre());%> </h4>
					<p class="w3-text-gray"> <%out.print(sendero.get_sede());%> </p>
					
					<form action="ServletSenderoVer" method="get" accept-charset="UTF-8" class="w3-padding">
						<input id="id_sendero" type=hidden name="id_sendero" value="<%=sendero.get_id_sendero()%>">
						<input type="submit" value="Ver sendero" class="w3-button w3-blue w3-hover-light-gray">
					</form>
				</div>
						
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