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
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>

	<body>

		<%@ include file="headerMenu.jsp" %>
		
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
		
		
		<div>
			<form class="w3-container" method="post" accept-charset="UTF-8" id="senderoForm">
	
	
				<div class="w3-container w3-gray">
		  			<h3>Información del sendero</h3>
		  			
			    	<button class="w3-btn w3-blue" type="submit" onclick="prepareSubmit('guardar')">
				        <%= (sendero != null) ? "Actualizar" : "Guardar" %>
				    </button>
				    
				    <% if (sendero != null) { %>
				    
				    <button class="w3-btn w3-red" type="submit" onclick="prepareSubmit('borrar')">
				        Eliminar
				    </button>
				    
				    <% } %>
		  			
				</div>

	
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
	   			<input class="w3-input w3-border w3-round-largeqec" id="url_recursos" type="text"  value="<%=url_recursos%>" maxlength="255" name="url_recursos">

	    	</form>
    		
    	</div>
    	
    	<div class="w3-container w3-green">
  			<h3>Estaciones</h3>
		</div>
    		
    	<%
    	if (id_sendero!=0){
			@SuppressWarnings("unchecked")
			List<EstacionJB> estaciones = (List<EstacionJB>) request.getAttribute("estaciones");
			if (estaciones != null && !estaciones.isEmpty() ) {
				for (EstacionJB estacion : estaciones) {
		%>
			<form action="ServletEstacionCargar" method="get" accept-charset="UTF-8">
				<input id="id_estacion" type=hidden name="id_estacion" value="<%=estacion.get_id_estacion()%>">
				<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">
				<p><%out.print(estacion.get_nombre());%> </p>
 				<input type="submit" value="Editar estacion" class="w3-button w3-grey">
    		</form>
			<p> </p>
			 
		<%
				}
			}
			else {
				out.print("Este sendero no tiene estaciones");
			}
			%>
			<form action="ServletEstacionCargar" method="get" accept-charset="UTF-8">
				<input id="id_estacion" type=hidden name="id_estacion" value="0">
				<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">
					<input type="submit" value="Agregar Estacion" class="w3-button w3-blue">
			</form>
			<%
    	}
		%>
	
	
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