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
	<link rel="stylesheet" type="text/css" href="custom.css" />
</head>
	
<body>

	<%@ include file="header_02.jsp" %>
	
	<%
		int id_estacion = (Integer) request.getAttribute("id_estacion");
		int id_sendero = (Integer) request.getAttribute("id_sendero");
	
		int id_recurso = 0;
		int numero = 0;
		String url = "";
		String creditos = "";
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
	
	<div class="container" style="margin-top:30px">
	
		<div class="card mb-4">
	
			<form class="needs-validation" method="post" accept-charset="UTF-8" id="recursoForm">
			
				<div class="card-header navbar navbar-expand-sm p-4">
					<span class="navbar-text mr-auto">
			    		<b>Información de recurso </b>
					</span>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item mr-3">
							<input type="submit" value="<%= (recurso != null) ? "Actualizar" : "Guardar" %>" class="btn btn-primary" onclick="prepareSubmit('guardar')">
					    </li>
						<% if (recurso != null) { %>
						<li class="nav-item">
							<input type="submit" value="Eliminar" class="btn btn-danger" onclick="prepareSubmit('borrar')">
				  		</li>
				  		<% } %>
					</ul>
				</div>
			
	
	 			<div class="card-body">
		
		    		<input id="id_recurso" type=hidden name="id_recurso" value="<%=id_recurso%>"> 
		    		<input id="id_estacion" type=hidden name="id_estacion" value="<%=id_estacion%>"> 
		    		<input id="id_senero" type=hidden name="id_sendero" value="<%=id_sendero%>">    		
					
					<div class="row">
						<div class="form-group col">
							<label for="nombre">Numero de recurso:</label>
			   				<input required class="form-control" id="numero" type="number" value="<%=numero%>" name="numero">
			   			</div>
			   			
			   			
						<%
						@SuppressWarnings("unchecked")
						List<TipoRecursoJB> tipo_recursos = (List<TipoRecursoJB>) request.getAttribute("tipo_recursos");
						%>
							
						<div class="form-group col">
							<label for="fabricante">Tipo de recurso:</label>
				   			<select required class="form-control" id="id_tipo_recurso" name="id_tipo_recurso">
									<% for (TipoRecursoJB tr : tipo_recursos) { %>
		        						<option value="<%= tr.get_id_tipo_recurso() %>" <% if (tr.get_id_tipo_recurso()==id_tipo_recurso) { %> selected <% } %>>
		            						<%= tr.get_tipo() %>
		        						</option>
				    				<% } %>
							</select>
						</div>
		   			</div>
		   			
		   			<div class="form-group">
		   				<label for="sede">URL o ruta del recurso:</label>
		   				<input required class="form-control" id="url" type="text" value="<%=url%>" maxlength="100" name="url" >
					</div>
					
					<div class="form-group">
						<label for="sede">Créditos:</label>
		   				<input required class="form-control" id="creditos" type="text" value="<%=creditos%>" maxlength="100" name="creditos" >
					</div>
		
		    	
	    		</div>
	    	</form>
	    	
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
	        
	        //form.submit();
	    }
	</script>

	</body>
</html>