<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>

<head>
	<title>SendinaUV</title>
	<link rel="stylesheet" type="text/css" href="custom.css"/>
</head>

<body>

	<%@ include file="header_03.jsp" %>
		
		
	<div class="container" style="margin-top:30px">
		
		<div class="card mb-4">
		
			<div class="card-header navbar navbar-expand-sm p-4">
				<span class="navbar-text mr-auto">
		    		<b>Usuarios</b>
				</span>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
				    	<a href="ServletUsuarioCargar?id_usuario=0" class="btn btn-info card-link">Agregar usuario</a>
				    </li>
				</ul>
			</div>

			<%
			@SuppressWarnings("unchecked")
			List<UsuarioJB> lista = (List<UsuarioJB>) request.getAttribute("lista");
			if (lista != null) {
				for (UsuarioJB usuario : lista) {
					String nombre = usuario.get_nombre();
					String rol = usuario.get_rol_usuario();
					//out.print(logo_url);
					
			%>
			<ul class="list-group list-group-flush">
		 
			 	<li class="list-group-item">
			 		<div class="row">
					 	<div class="col">
					 		<% out.print(nombre);%>
					 		<p class="text-secondary"> <%out.print(rol);%> </p>
				 		</div>
				 		<div class="col-md-auto">
				 			<a href="ServletUsuarioCargar?id_usuario=<%=usuario.get_id_usuario()%>" class="btn btn-secondary card-link">Editar</a>	   
				 		</div>
			 		</div>
			 	</li>
			
			</ul>
			 
		<%
			}
		}
		else {
			out.print("No hay nada");
		}
		%>
		</div>
	</div>
</body>
</html>