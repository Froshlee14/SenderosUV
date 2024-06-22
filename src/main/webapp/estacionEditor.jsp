<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="modelo.UsuarioJB"%>
<%@ page import="modelo.EstacionJB"%>
<%@ page import="modelo.RecursoJB"%>
<!DOCTYPE html>

<html>

<head>
	<title>SendinaUV</title>
</head>

<body>

	<%@ include file="header_02.jsp" %>
	
	<%
		int id_sendero = (Integer) request.getAttribute("id_sendero");
		int id_estacion = 0;
		int numero = 0;
		String nombre = "";
		String descripcion = "";
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
	
	<div class="container" style="margin-top:30px">
	
 		<div class="card mb-4">
			<form class="needs-validation" id="estacionForm" method="post" accept-charset="UTF-8">
	
				<div class="card-header navbar navbar-expand-sm p-4">
						<span class="navbar-text mr-auto">
				    		<b>Información de estación </b>
						</span>
						<ul class="navbar-nav ml-auto">
							<li class="nav-item mr-3">
								<input type="submit" value="<%= (estacion != null) ? "Actualizar" : "Guardar" %>" class="btn btn-primary" onclick="prepareSubmit('guardar')">
						    </li>
							<% if (estacion != null) { %>
							<li class="nav-item">
								<input type="submit" value="Eliminar" class="btn btn-danger" onclick="prepareSubmit('borrar')">
					  		</li>
					  		<% } %>
						</ul>
				</div>
			
				<div class="card-body">
					
					<div class="form-group">
						<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">  
			    		<input id="id_estacion" type=hidden name="id_estacion" value="<%=id_estacion%>"> 
			    	</div>
			    	
			    	<div class="row">
				    	<div class="form-group col-4">
				    		<label for="nombre">Numero:</label>
				   			<input required class="form-control" id="numero" type="number"  value="<%=numero%>" name="numero">
				    	</div>
				    		
				    	<div class="form-group col">
							<label for="nombre">Nombre de la estacion:</label>
				   			<input required class="form-control" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre">
				   		</div>
			   		</div>
			   		
			   		<div class="form-group">
			   			<label for="descripcion">Descripción:</label>
			   			<input required class="form-control" id="descripcion" type="text" value="<%=descripcion%>" maxlength="200" name="descripcion" >	
					</div>
					
					<div class="row">
						<div class="form-group col">
				    		<label for="latitud">Latitud:</label>
				   			<input required class="form-control" id="latitud" type="text"  value="<%=latitud%>" maxlength="20" name="latitud">
				   		</div>
				   		
				   		<div class="form-group col">
				    		<label for="longitud">Longitud:</label>
				   			<input required class="form-control" id="longitud" type="text"  value="<%=longitud%>" maxlength="20" name="longitud">
						</div>
			   		</div>
			   		
			   	</div>
			   	
   			</form>
   		</div>
   	
		<%
	   	if (id_estacion!=0){
			@SuppressWarnings("unchecked")
			List<RecursoJB> recursos = (List<RecursoJB>) request.getAttribute("recursos");
		%>
		
		<div class="card mb-4">
		
	  		<div class="card-header navbar navbar-expand-sm p-4">
				<span class="navbar-text mr-auto">
		    		<b>Recursos</b>
				</span>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
				    	<a href="ServletRecursoCargar?id_sendero=<%=id_sendero%>&id_estacion=<%=id_estacion%>&id_recurso=0"
				    	class="btn btn-info card-link">Agregar recurso</a>
				    </li>
				</ul>
			</div>
			
			<%		
				if (recursos != null && !recursos.isEmpty() ) {
					int n_recursos = recursos.size();
				    int contador = 0;
					for (RecursoJB recurso : recursos) {
			%>
			
			 <ul class="list-group list-group-flush">
			 	<li class="list-group-item">
					<div class="row">
					 	<div class="col">
					 		<b> <% out.print("#"+recurso.get_numero()+":");%> </b> <%out.print(recurso.get_tipo_recurso()); %>
					 		<p class="text-secondary"> <% out.print(recurso.get_url()); %> </p>
				 		</div>
				 		<div class="col-md-auto">
				 			<a href="ServletRecursoCargar?id_sendero=<%=id_sendero%>&id_estacion=<%=id_estacion%>&id_recurso=<%=recurso.get_id_recurso()%>"
				    	class="btn btn-secondary card-link">Editar</a>
				 		</div>
			 		</div>
				</li>
			</ul>
				 
			<%
					contador++;
					}
				}
				else {
					out.print("Esta estacion no tiene recursos");
				}
		
		   	}
			%>
   	
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
        //form.submit();
    }
</script>

</body>
</html>