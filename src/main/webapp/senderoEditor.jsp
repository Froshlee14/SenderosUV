<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.UsuarioJB"%>
<%@ page import="modelo.ZonaJB"%>
<!DOCTYPE html>

<html>


	<head>
		<title>SendinaUV</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>

	<body>

		<%@ include file="headerMenu.jsp" %>
		
		<form class="w3-container" action="ServletSenderoGuardar" method="post" accept-charset="UTF-8">
				
						<%
							int id_sendero = 0;
							String nombre = "Sendero nombre ejemplo";
							String sede = "Sendero sede ejemplo";
							String year = "2024-04-11";
							int zona = 1;
							String url_recursos = "Inserte URL aqui";
							
							SenderoJB sendero = (SenderoJB) request.getAttribute("sendero");
							if (sendero != null) {
								id_sendero = sendero.get_id_sendero();
								nombre = sendero.get_nombre();
								sede = sendero.get_sede();
								
								Date date = sendero.get_year();
						        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						        year = sdf.format(date);
						        
						        zona = sendero.get_id_zona();
								url_recursos = sendero.get_url_recursos();
								
							}
						
						%>

			    		<input id="id_sendero" type=text name="id_sendero" value="<%=id_sendero%>">    		
 
						<label class="w3-text-blue" for="nombre">Nombre de sendero:</label>
		    			<input class="w3-input w3-border" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre">
		    			
		    			<label class="w3-text-blue" for="sede">Sede del sendero:</label>
		    			<input class="w3-input w3-border" id="sede" type="text" value="<%=sede%>" maxlength="50" name="sede" >
						
 						<%
							@SuppressWarnings("unchecked")
							List<ZonaJB> zonas = (List<ZonaJB>) request.getAttribute("zonas");
						%>
 						
						<label class="w3-text-blue" for="fabricante">Zona:</label>
		    			<select class="w3-input w3-border" id="zona" name="id_zona">
								<% for (ZonaJB z : zonas) { %>
           						<option value="<%= z.get_id_zona() %>" <% if (z.get_id_zona()==zona) { %> selected <% } %>>
               						<%= z.get_nombre() %>
           						</option>
       						<% } %>
						</select>  		


						<label class="w3-text-blue" for="year">Año de creación:</label>
			    		<input class="w3-input w3-border" id="year" type="date" value="<%=year%>" name="year" >
			    		
			    		<label class="w3-text-blue" for="url_recursos">Recursos (URL):</label>
		    			<input class="w3-input w3-border" id="url_recursos" type="text"  value="<%=url_recursos%>" maxlength="255" name="url_recursos">
		    			
 				
 					
 					<input class="w3-btn w3-blue" type="submit" value="<%= (sendero != null) ? "Actualizar" : "Guardar" %>">
				
    		</form>
	
	</body>
</html>