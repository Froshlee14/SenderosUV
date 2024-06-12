<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="modelo.RecursoJB"%>
<%@ page import="modelo.UsuarioJB"%>
<%@ page import="modelo.TipoRecursoJB"%>
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
			int id_estacion = (Integer) request.getAttribute("id_estacion");
			int id_sendero = (Integer) request.getAttribute("id_sendero");
		
			int id_recurso = 0;
			int numero = 0;
			String url = "senderos/";
			String creditos = "Autor de este recurso";
			int id_tipo_recurso = 1;
			
			RecursoJB recurso = (RecursoJB) request.getAttribute("recurso");
			if (recurso != null) {
				id_recurso = recurso.get_id_recurso();
				numero = recurso.get_numero();
				url = recurso.get_url();		  
		        creditos = recurso.get_creditos();
				id_tipo_recurso = recurso.get_id_tipo_recurso();
				
			}
		
		%>
		
		<div class="w3-container w3-content">

		<p> </p>
		<div class="w3-bar">
		  
		  <a href="#" class="w3-bar-item w3-button"> <b> Información del recurso </b> </a>
		  <% if (recurso != null) { %>
		  	<a href="#" class="w3-bar-item w3-button w3-hover-red w3-right" onclick="prepareSubmit('borrar')">Eliminar</a>
		  <% } %>
		  <a href="#" class="w3-bar-item w3-button w3-hover-blue w3-right" onclick="prepareSubmit('guardar')"><%= (recurso != null) ? "Actualizar" : "Guardar" %></a>
		</div>
		

 		<div class="w3-panel w3-white w3-card w3-display-container">
 		
 			<p></p>
			<form class="w3-container" method="post" accept-charset="UTF-8" id="recursoForm">
	
	    		<input id="id_recurso" type=hidden name="id_recurso" value="<%=id_recurso%>"> 
	    		<input id="id_estacion" type=hidden name="id_estacion" value="<%=id_estacion%>"> 
	    		<input id="id_senero" type=hidden name="id_sendero" value="<%=id_sendero%>">    		
	
				<label class="w3-text-blue" for="nombre">Numero de recurso:</label>
	   			<input class="w3-input w3-border w3-round-large" id="numero" type="number" value="<%=numero%>" name="numero">
	   			
	   			<label class="w3-text-blue" for="sede">URL o ruta del recurso:</label>
	   			<input class="w3-input w3-border w3-round-large" id="url" type="text" value="<%=url%>" maxlength="100" name="url" >
				
					<%
					@SuppressWarnings("unchecked")
					List<TipoRecursoJB> tipo_recursos = (List<TipoRecursoJB>) request.getAttribute("tipo_recursos");
				%>
					
				<label class="w3-text-blue" for="fabricante">Tipo de recurso:</label>
	   			<select class="w3-input w3-border w3-round-large" id="id_tipo_recurso" name="id_tipo_recurso">
						<% for (TipoRecursoJB tr : tipo_recursos) { %>
	        						<option value="<%= tr.get_id_tipo_recurso() %>" <% if (tr.get_id_tipo_recurso()==id_tipo_recurso) { %> selected <% } %>>
	            						<%= tr.get_tipo() %>
	        						</option>
	    						<% } %>
				</select> 
				
				<label class="w3-text-blue" for="sede">Créditos:</label>
	   			<input class="w3-input w3-border w3-round-large" id="creditos" type="text" value="<%=creditos%>" maxlength="100" name="creditos" >
				 		
	
	    	</form>
    		<p> </p>
    	</div>
    	
</div>
	
	
	<script>
	    function prepareSubmit(action) {
	        var form = document.getElementById('recursoForm');
	        
	        if (action === 'guardar') {
	            form.method = 'post';
	            form.action = 'ServletRecursoGuardar';
	        } else if (action === 'borrar') {
	            form.method = 'get';
	            form.action = 'ServletRecursoBorrar';
	        }
	        
	        form.submit();
	    }
	</script>

	</body>
</html>