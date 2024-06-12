<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>


	<head>
		<title>SendinaUV</title>
	</head>

	<body  class="w3-theme-l4">

		<%@ include file="header_03.jsp" %>
		
		<%
			int id_usuario = 0;
			String nombre = "Nombre de usuario";
			String password = "Escriba una contraseña";
			int id_rol_usuario = 1;
			
			UsuarioJB user = (UsuarioJB) request.getAttribute("usuario");
			if (user != null) {
				id_usuario = user.get_id_usuario();
				nombre = user.get_nombre();
				password = user.get_contrasena();
		        id_rol_usuario = user.get_id_rol_usuario();
				
			}
		
		%>
		
		<div class="w3-container w3-content">

		<p> </p>
		<div class="w3-bar">
		  
		  <a href="#" class="w3-bar-item w3-button"> <b> Información del usuario </b> </a>
		  <% if (user != null) { %>
		  	<a href="#" class="w3-bar-item w3-button w3-hover-red w3-right" onclick="prepareSubmit('borrar')">Eliminar</a>
		  <% } %>
		  <a href="#" class="w3-bar-item w3-button w3-hover-blue w3-right" onclick="prepareSubmit('guardar')"><%= (user != null) ? "Actualizar" : "Guardar" %></a>
		</div>
		

 		<div class="w3-panel w3-white w3-card w3-display-container">
 		
 			<p></p>
			<form class="w3-container" method="post" accept-charset="UTF-8" id="usuarioForm">
	
	    		<input id="id_usuario" type=hidden name="id_usuario" value="<%=id_usuario%>">    		
	
				<label class="w3-text-blue" for="nombre">Nombre de usuario:</label>
	   			<input class="w3-input w3-border w3-round-large" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre">
	   			
	   			<label class="w3-text-blue" for="sede">Contraseña:</label>
	   			<input class="w3-input w3-border w3-round-large" id="contrasena" type="text" value="<%=password%>" maxlength="50" name="contrasena" >
					
				<label class="w3-text-blue" for="id_rol_usuario">Rol de usuario:</label>
	   			<select class="w3-input w3-border w3-round-large" id="id_rol_usuario" name="id_rol_usuario">
					<option value="1" <% if (id_rol_usuario==1) { %> selected <% } %>>
	  						Administrador
					</option>
					<option value="2" <% if (id_rol_usuario==2) { %> selected <% } %>>
	  						Editor
					</option>
				</select>  		
	    	</form>
    		<p> </p>
    	</div>
		
		
		</div>
	
	
	<script>
	    function prepareSubmit(action) {
	        var form = document.getElementById('usuarioForm');
	        
	        if (action === 'guardar') {
	            form.method = 'post';
	            form.action = 'ServletUsuarioGuardar';
	        } else if (action === 'borrar') {
	            form.method = 'get';
	            form.action = 'ServletUsuarioBorrar';
	        }
	        
	        form.submit();
	    }
	</script>

	</body>
</html>