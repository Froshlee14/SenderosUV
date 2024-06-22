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
	<link rel="stylesheet" type="text/css" href="custom.css" />
</head>


<body >

	<%@ include file="header_02.jsp" %>
	
	<%
		int id_sendero = 0;
		String nombre = "";
		String sede = "";
		int year = 2004;
		int zona = 1;
		String url_recursos = "";
		
		SenderoJB sendero = (SenderoJB) request.getAttribute("sendero");
		if (sendero != null) {
			id_sendero = sendero.get_id_sendero();
			nombre = sendero.get_nombre();
			sede = sendero.get_sede();
			year = sendero.get_year();
	        zona = sendero.get_id_zona();
			url_recursos = sendero.get_url_recursos();
		}
	%>
		
	<div class="container" style="margin-top:30px">

 		<div class="card mb-4">
 		
 			<form class="needs-validation" method="post" accept-charset="UTF-8" id="senderoForm">
 		
 			<div class="card-header navbar navbar-expand-sm p-4">
					<span class="navbar-text mr-auto">
			    		<b>Información de sendero </b>
					</span>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item mr-3">
							<input type="submit" value="<%= (sendero != null) ? "Actualizar" : "Guardar" %>" class="btn btn-primary" onclick="prepareSubmit('guardar')">
					    </li>
						<% if (sendero != null) { %>
						<li class="nav-item">
							<input type="submit" value="Eliminar" class="btn btn-danger" onclick="prepareSubmit('borrar')">
				  		</li>
				  		<% } %>
					</ul>
			</div>
 		
 			<div class="card-body">

	
	    		<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">    		
	
				<div class="form-group">
					<label for="nombre">Nombre de sendero:</label>
		   			<input required class="form-control" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre" placeholder="Nombre de sendero">
	   			</div>
	   			
	   			<div class="form-group">
	   				<label for="sede">Sede del sendero:</label>
	   				<input required class="form-control" id="sede" type="text" value="<%=sede%>" maxlength="50" name="sede" placeholder="Sede del sendero">
				</div>
				
				<%
				@SuppressWarnings("unchecked")
				List<ZonaJB> zonas = (List<ZonaJB>) request.getAttribute("zonas");
				%>
					
				<div class="row">
				
					<div class="form-group col">
						<label for="zona">Zona:</label>
			   			<select class="form-control" id="zona" name="id_zona" >
							<% for (ZonaJB z : zonas) { %>
	       						<option value="<%= z.get_id_zona() %>" <% if (z.get_id_zona()==zona) { %> selected <% } %>>
	           						<%= z.get_nombre() %>
	       						</option>
	   						<% } %>
						</select> 
					</div> 		
		
					<div class="form-group col">
						<label for="year">Año de creación:</label>
			    		<input required class="form-control" id="year" type="number" value="<%=year%>" name="year" >
		    		</div>
	    		
	    		</div>
	    		
	    		<div class="form-group">
		    		<label for="url_recursos">Ruta de logotipo:</label>
		   			<input required class="form-control" id="url_recursos" type="text"  value="<%=url_recursos%>" maxlength="255" name="url_recursos">
				</div>
				
	    	
	    	</div>
	    	</form>
    	</div>
		
    		
    	<%
    	if (id_sendero!=0){
			@SuppressWarnings("unchecked")
			List<EstacionJB> estaciones = (List<EstacionJB>) request.getAttribute("estaciones");
			
		%>
		
<!-- 	<form action="ServletEstacionCargar" method="get" accept-charset="UTF-8"> -->
<!-- 		<input id="id_estacion" type=hidden name="id_estacion" value="0"> -->
<%-- 		<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>"> --%>
<!-- 		<input type="submit" value="Agregar Estacion" class="btn btn-info"> -->
<!-- 	</form> -->

		<div class="card mb-4">
 		
 			<div class="card-header navbar navbar-expand-sm p-4">
				<span class="navbar-text mr-auto">
		    		<b>Estaciones del sendero</b>
				</span>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
				    	<a href="ServletEstacionCargar?id_sendero=<%=id_sendero%>&id_estacion=0" class="btn btn-info card-link">Agregar estación</a>
				    </li>
				</ul>
			</div>
		
		<%
			if (estaciones != null && !estaciones.isEmpty() ) {
				int n_estaciones = estaciones.size();
			    int contador = 0;
				for (EstacionJB estacion : estaciones) {
		%>
		
		 <ul class="list-group list-group-flush">
		 
		 	<li class="list-group-item">
		 		<div class="row">
				 	<div class="col">
				 		<b> <% out.print("#"+estacion.get_numero()+":");%> </b> <%out.print(estacion.get_nombre()); %>
				 		<p class="text-secondary"> <% out.print(estacion.get_descripcion()); %> </p>
			 		</div>
			 		<div class="col-md-auto">
			 			<a href="ServletEstacionCargar?id_sendero=<%=id_sendero%>&id_estacion=<%=estacion.get_id_estacion()%>" class="btn btn-secondary card-link">Editar</a>	   
			 		</div>
		 		</div>
		 	</li>
		
		</ul>
			 
		<%
				contador++; //Recuerda mandar este valor al formulario para crear estaciones
				}
			}
			else {
				out.print("Este sendero no tiene estaciones");
			}

    	}
		%>
		
		</div>

	</div>
	
	
	<script>
		//Tengo 2 botones dentro del mismo formulario, pero cada uno llama a un Servlet diferente.
	    function prepareSubmit(action) {
			
	    	var form = document.getElementById('senderoForm');
	        
	        if (action === 'guardar') {
	            form.method = 'post';
	            form.action = 'ServletSenderoGuardar';
	        } else if (action === 'borrar') {
	            form.method = 'get';
	            form.action = 'ServletSenderoBorrar';
	        }	        
	        //form.submit();
	    }
	</script>

	</body>
</html>