<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="modelo.UsuarioJB"%>
<%@ page import="modelo.EstacionJB"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SendinaUV</title>
	</head>

	<body class="w3-theme-l4">

		<%@ include file="header_02.jsp" %>
		
		
		<%
			int id_sendero = (Integer) request.getAttribute("id_sendero");
			int id_estacion = 0;
			int numero = 0;
			String nombre = "Nombre de estacion ejemplo";
			String descripcion = "Esta es una descripcion breve de la estacion";
			String latitud = "";
			String longitud = "";
			
			EstacionJB estacion = (EstacionJB) request.getAttribute("estacion");
			if (estacion != null) {
				id_estacion = estacion.get_id_estacion();
				numero = estacion.get_numero();
				nombre = estacion.get_nombre();
				descripcion = estacion.get_descripcion();
				latitud = estacion.get_latitud();
				longitud = estacion.get_longitud();
				
			}
		
		%>
		
		<div class="w3-container w3-content">
		
		<p> </p>
		<div class="w3-bar">
		  
		  <a href="#" class="w3-bar-item w3-button"> <b> Información del sendero </b> </a>
		  <% if (estacion != null) { %>
		  	<a href="#" class="w3-bar-item w3-button w3-hover-red w3-right" onclick="prepareSubmit('borrar')">Eliminar</a>
		  <% } %>
		  <a href="#" class="w3-bar-item w3-button w3-hover-blue w3-right" onclick="prepareSubmit('guardar')"><%= (estacion != null) ? "Actualizar" : "Guardar" %></a>
		</div>
		
		<div class="w3-panel w3-white w3-card w3-display-container">
 		
 			<p></p>
			<form class="w3-container" id="estacionForm" method="post" accept-charset="UTF-8">

				<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">  
	    		<input id="id_estacion" type=hidden name="id_estacion" value="<%=id_estacion%>">  
	    		
				<label class="w3-text-blue" for="nombre">Nombre de la estacion:</label>
    			<input class="w3-input w3-border" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre">
    			
    			<label class="w3-text-blue" for="descripcion">Descripción:</label>
    			<input class="w3-input w3-border" id="descripcion" type="text" value="<%=descripcion%>" maxlength="200" name="descripcion" >	

				<label class="w3-text-blue" for="nombre">Numero de estacion:</label>
    			<input class="w3-input w3-border" id="numero" type="number"  value="<%=numero%>" name="numero">
	    		
	    		<label class="w3-text-blue" for="url_recursos">Latitud:</label>
    			<input class="w3-input w3-border" id="latitud" type="text"  value="<%=latitud%>" maxlength="20" name="latitud">
    			
	    		<label class="w3-text-blue" for="url_recursos">Longitud:</label>
    			<input class="w3-input w3-border" id="longitud" type="text"  value="<%=longitud%>" maxlength="20" name="longitud">
			
    		</form>
    		<p></p>
    	</div>
    		
    </div>

	<script>
	    function prepareSubmit(action) {
	        var form = document.getElementById('estacionForm');
	        
	        if (action === 'guardar') {
	            form.method = 'post';
	            form.action = 'ServletEstacionGuardar';
	        } else if (action === 'borrar') {
	            form.method = 'get';
	            form.action = 'ServletEstacionBorrar';
	        }
	        
	        form.submit();
	    }
	</script>
	
	</body>
</html>