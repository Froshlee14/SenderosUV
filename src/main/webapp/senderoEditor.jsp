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


<body class="bg-light" >

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
		
	<div class="container " style="margin-top:30px">
		<div class=" center mx-auto">
		
		<nav class="navbar navbar-expand-sm">
			<span class="navbar-text mr-auto">
	    		Información de sendero
			</span>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item mr-3">
			      <a href="#" class="btn btn-primary" onclick="prepareSubmit('guardar')"> <%= (sendero != null) ? "Actualizar" : "Guardar" %> </a>
			    </li>
				<% if (sendero != null) { %>
				<li class="nav-item mr-3">
		  			<a href="#" class="btn btn-danger" onclick="prepareSubmit('borrar')">Eliminar</a>
		  		</li>
		  		<% } %>
			</ul>
		</nav>

 		<div class="card p-3 container">
 		
			<form method="post" accept-charset="UTF-8" id="senderoForm">
	
	    		<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">    		
	
				<div class="form-group">
					<label for="nombre">Nombre de sendero:</label>
		   			<input class="form-control" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre" placeholder="Nombre de sendero">
	   			</div>
	   			
	   			<div class="form-group">
	   				<label for="sede">Sede del sendero:</label>
	   				<input class="form-control" id="sede" type="text" value="<%=sede%>" maxlength="50" name="sede" placeholder="Sede del sendero">
				</div>
				
				<%
				@SuppressWarnings("unchecked")
				List<ZonaJB> zonas = (List<ZonaJB>) request.getAttribute("zonas");
				%>
					
				<div class="form-group">
					<label for="zona">Zona:</label>
		   			<select class="form-control" id="zona" name="id_zona" >
						<% for (ZonaJB z : zonas) { %>
       						<option value="<%= z.get_id_zona() %>" <% if (z.get_id_zona()==zona) { %> selected <% } %>>
           						<%= z.get_nombre() %>
       						</option>
   						<% } %>
					</select> 
				</div> 		
	
				<div class="form-group">
					<label for="year">Año de creación:</label>
		    		<input class="form-control" id="year" type="number" value="<%=year%>" name="year" >
	    		</div>
	    		
	    		<div class="form-group">
		    		<label for="url_recursos">Ruta de logotipo:</label>
		   			<input class="form-control" id="url_recursos" type="text"  value="<%=url_recursos%>" maxlength="255" name="url_recursos">
				</div>
				
	    	</form>
    	</div>
		
    		
    	<%
    	if (id_sendero!=0){
			@SuppressWarnings("unchecked")
			List<EstacionJB> estaciones = (List<EstacionJB>) request.getAttribute("estaciones");
			
		%>
		
		<nav class="navbar navbar-expand-sm">
			<span class="navbar-text mr-auto">
	    		Estaciones del sendero
			</span>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item mr-3">
		  			<form action="ServletEstacionCargar" method="get" accept-charset="UTF-8">
						<input id="id_estacion" type=hidden name="id_estacion" value="0">
						<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">
						<input type="submit" value="Agregar Estacion" class="btn btn-info">
					</form>
		  		</li>
			</ul>
		</nav>
		
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
	</div>
	
	
	<script>
	    function prepareSubmit(action) {
	    	
	    	//Obtengo mi formulario
	        var form = document.getElementById('senderoForm');
	    	
	        // Obtiengo los valores de los campos del formulario
	        var form_nombre = form["nombre"].value.trim();
	        var form_sede = form["sede"].value.trim();
	        var form_year = form["year"].value.trim();
	        var form_url = form["url_recursos"].value.trim();

	        // Reviso que los campos no esten vacios
	        if (form_nombre == "") {
	            alert("Escriba un nombre");
	            return false;
	        }

	        if (form_sede == "") {
	            alert("Escriba una sede");
	            return false;
	        }
	        
	        if (form_year == "") {
	            alert("Escriba una fecha");
	            return false;
	        }
	        
	        if (form_url == "") {
	            alert("Escriba una ruta");
	            return false;
	        }
	        
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