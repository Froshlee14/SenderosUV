<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="modelo.SenderoJB"%>
<%@ page import="modelo.UsuarioJB"%>
<%@ page import="modelo.ZonaJB"%>
<%@ page import="modelo.EstacionJB"%>
<!DOCTYPE html>

<html>


	<head>
		<title>SendinaUV</title>
	</head>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<body  class="w3-theme-l4">

		<%@ include file="header_02.jsp" %>
		
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
		
		<div class="w3-container w3-content">

		<p> </p>
		<div class="w3-bar">
		  
		  <a href="#" class="w3-bar-item w3-button"> <b> Información del sendero </b> </a>
		  <% if (sendero != null) { %>
		  	<a href="#" class="w3-bar-item w3-button w3-hover-red w3-right" onclick="prepareSubmit('borrar')">Eliminar</a>
		  <% } %>
		  <a href="#" class="w3-bar-item w3-button w3-hover-blue w3-right" onclick="prepareSubmit('guardar')"><%= (sendero != null) ? "Actualizar" : "Guardar" %></a>
		</div>
		

 		<div class="w3-panel w3-white w3-card w3-display-container">
 		
 			<p></p>
			<form class="w3-container" method="post" accept-charset="UTF-8" id="senderoForm">
	
	    		<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">    		
	
				<label class="w3-text-blue" for="nombre">Nombre de sendero:</label>
	   			<input class="w3-input w3-border w3-round-large" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre">
	   			
	   			<label class="w3-text-blue" for="sede">Sede del sendero:</label>
	   			<input class="w3-input w3-border w3-round-large" id="sede" type="text" value="<%=sede%>" maxlength="50" name="sede" >
				
					<%
					@SuppressWarnings("unchecked")
					List<ZonaJB> zonas = (List<ZonaJB>) request.getAttribute("zonas");
				%>
					
				<label class="w3-text-blue" for="fabricante">Zona:</label>
	   			<select class="w3-input w3-border w3-round-large" id="zona" name="id_zona">
						<% for (ZonaJB z : zonas) { %>
	        						<option value="<%= z.get_id_zona() %>" <% if (z.get_id_zona()==zona) { %> selected <% } %>>
	            						<%= z.get_nombre() %>
	        						</option>
	    						<% } %>
				</select>  		
	
	
				<label class="w3-text-blue" for="year">Año de creación:</label>
	    		<input class="w3-input w3-border w3-round-large" id="year" type="date" value="<%=year%>" name="year" >
	    		
	    		<label class="w3-text-blue" for="url_recursos">Recursos (URL):</label>
	   			<input class="w3-input w3-border w3-round-large" id="url_recursos" type="text"  value="<%=url_recursos%>" maxlength="255" name="url_recursos">

	    	</form>
    		<p> </p>
    	</div>
		
    		
    	<%
    	if (id_sendero!=0){
			@SuppressWarnings("unchecked")
			List<EstacionJB> estaciones = (List<EstacionJB>) request.getAttribute("estaciones");
			
		%>
		
		<div class="w3-bar">
		  
			<a href="#" class="w3-bar-item w3-button"> <b> Estaciones </b> </a>
		  
			<form action="ServletEstacionCargar" method="get" accept-charset="UTF-8">
				<input id="id_estacion" type=hidden name="id_estacion" value="0">
				<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">
				<input type="submit" value="Agregar Estacion" class="w3-bar-item w3-button w3-hover-green w3-right">
			</form>
		  
		</div>
		
		<%
			
			
			if (estaciones != null && !estaciones.isEmpty() ) {
				int n_estaciones = estaciones.size();
			    int contador = 0;
				for (EstacionJB estacion : estaciones) {
		%>
		
		 <div class="w3-panel w3-white w3-card w3-display-container">
		 
		 <div class="w3-row">
		 
		 	<div class="w3-col" style="width:auto">
		 		<p><b> <%out.print("#"+estacion.get_numero()+":");%> </b></p>
		 	</div>
		 	
		 	<div class="w3-rest">
			<form action="ServletEstacionCargar" method="get" accept-charset="UTF-8">
			
				<input id="id_estacion" type=hidden name="id_estacion" value="<%=estacion.get_id_estacion()%>">
				<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">
				
				<p><b> <%out.print(estacion.get_nombre());%> </b></p>
				
				<p> <%out.print(estacion.get_descripcion());%> </p>
				
 				<input type="submit" value="Editar" class="w3-button w3-hover-blue w3-display-topright">
    		</form>
    		</div>
		
		</div>
		</div>
			 
		<%
				contador++;
				}
			}
			else {
				out.print("Este sendero no tiene estaciones");
			}

    	}
		%>
		
		</div>
	
	
	<script>
	    function prepareSubmit(action) {
	        var form = document.getElementById('senderoForm');
	        
	        if (action === 'guardar') {
	            form.method = 'post';
	            form.action = 'ServletSenderoGuardar';
	        } else if (action === 'borrar') {
	            form.method = 'get';
	            form.action = 'ServletSenderoBorrar';
	        }
	        
	        form.submit();
	    }
	</script>

	</body>
</html>