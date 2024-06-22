<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>


<head>
	<title>SendinaUV</title>
	<link rel="stylesheet" type="text/css" href="custom.css" />
</head>

<body>

	<%@ include file="header_03.jsp" %>
	
	<%
		int id_usuario = 0;
		String nombre = "";
		String password = "";
		int id_rol_usuario = 1;
		
		UsuarioJB user = (UsuarioJB) request.getAttribute("usuario");
		if (user != null) {
			id_usuario = user.get_id_usuario();
			nombre = user.get_nombre();
			password = user.get_contrasena();
	        id_rol_usuario = user.get_id_rol_usuario();
			
		}
	
	%>
	
	<div class="container" style="margin-top:30px">

		<div class="card mb-4">

			<form class="needs-validation" method="post" accept-charset="UTF-8" id="usuarioForm">
	
			<div class="card-header navbar navbar-expand-sm p-4">
				<span class="navbar-text mr-auto">
		    		<b>Información de usuario </b>
				</span>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mr-3">
						<input type="submit" value="<%= (user != null) ? "Actualizar" : "Guardar" %>" class="btn btn-primary" onclick="prepareSubmit('guardar')">
				    </li>
					<% if (user != null) { %>
					<li class="nav-item">
						<input type="submit" value="Eliminar" class="btn btn-danger" onclick="prepareSubmit('borrar')">
			  		</li>
			  		<% } %>
				</ul>
			</div>
		

 			<div class="card-body">
 		
			
	    		<input id="id_usuario" type=hidden name="id_usuario" value="<%=id_usuario%>">    		
	
				<div class="form-group">
					<label for="nombre">Nombre de usuario:</label>
	   				<input required class="form-control" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre">
	   			</div>
	   			
	   			<div class="form-group">
	   				<label for="sede">Contraseña:</label>
	   				<input required class="form-control" id="contrasena" type="text" value="<%=password%>" maxlength="50" name="contrasena" >
				</div>
				
				<div class="form-group">
					<label  for="id_rol_usuario">Rol de usuario:</label>
		   			<select required class="form-control" id="id_rol_usuario" name="id_rol_usuario">
						<option value="1" <% if (id_rol_usuario==1) { %> selected <% } %>>
		  						Administrador
						</option>
						<option value="2" <% if (id_rol_usuario==2) { %> selected <% } %>>
		  						Editor
						</option>
					</select>
				</div>
	    	
    		</div>
			</form>
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
	        
	        //form.submit();
	    }
	</script>

	</body>
</html>