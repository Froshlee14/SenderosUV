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

	<body class="w3-theme-l4">

		<%@ include file="header_02.jsp" %>
		
		
		<%
			int id_sendero = (Integer) request.getAttribute("id_sendero");
			int id_estacion = 0;
			int numero = 0;
			String nombre = " ";
			String descripcion = " ";
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
		  
		  <a href="#" class="w3-bar-item w3-button"> <b> Información del estación </b> </a>
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
	    		
	    		<label class="w3-text-blue" for="nombre">Numero de estacion:</label>
    			<input class="w3-input w3-border" id="numero" type="number"  value="<%=numero%>" name="numero">
	    		 
	    		
				<label class="w3-text-blue" for="nombre">Nombre de la estacion:</label>
    			<input class="w3-input w3-border" id="nombre" type="text"  value="<%=nombre%>" maxlength="50" name="nombre">
    			
    			<label class="w3-text-blue" for="descripcion">Descripción:</label>
    			<input class="w3-input w3-border" id="descripcion" type="text" value="<%=descripcion%>" maxlength="200" name="descripcion" >	

	    		<label class="w3-text-blue" for="latitud">Latitud:</label>
    			<input class="w3-input w3-border" id="latitud" type="text"  value="<%=latitud%>" maxlength="20" name="latitud">
    			
	    		<label class="w3-text-blue" for="longitud">Longitud:</label>
    			<input class="w3-input w3-border" id="longitud" type="text"  value="<%=longitud%>" maxlength="20" name="longitud">
			
    		</form>
    		<p></p>
    	</div>
    	
    	
    	
    	
    	
		<%
    	if (id_estacion!=0){
			@SuppressWarnings("unchecked")
			List<RecursoJB> recursos = (List<RecursoJB>) request.getAttribute("recursos");
			
		%>
		
		<div class="w3-bar">
		  
			<a href="#" class="w3-bar-item w3-button"> <b> Recursos </b> </a>
		  
			<form action="ServletRecursoCargar" method="get" accept-charset="UTF-8">
				<input id="id_recurso" type=hidden name="id_recurso" value="0">
				<input id="id_estacion" type=hidden name="id_estacion" value="<%=id_estacion%>">
				<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">
				<input type="submit" value="Agregar Recurso" class="w3-bar-item w3-button w3-hover-green w3-right">
			</form>
		  
		</div>
		
		<%		
			if (recursos != null && !recursos.isEmpty() ) {
				int n_recursos = recursos.size();
			    int contador = 0;
				for (RecursoJB recurso : recursos) {
		%>
		
		 <div class="w3-panel w3-white w3-card w3-display-container">
		 
		 <div class="w3-row">
		 
		 	<div class="w3-col" style="width:auto">
		 		<p><b> <%out.print("#"+recurso.get_numero()+":");%> </b></p>
		 	</div>
		 	
		 	<div class="w3-rest">
			<form action="ServletRecursoCargar" method="get" accept-charset="UTF-8">
				
				<input id="id_recurso" type=hidden name="id_recurso" value="<%=recurso.get_id_recurso()%>">
				<input id="id_estacion" type=hidden name="id_estacion" value="<%=id_estacion%>">
				<input id="id_sendero" type=hidden name="id_sendero" value="<%=id_sendero%>">
				
				<p><b> <%out.print(recurso.get_tipo_recurso());%> </b></p>
				
				<p> <%out.print(recurso.get_url());%> </p>
				
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

	<script>
	    function prepareSubmit(action) {
	    	
	    	//Obtengo mi formulario
	        var form = document.getElementById('estacionForm');
	        
	        // Obtiengo los valores de los campos del formulario
	       	var form_numero = form["numero"].value.trim();
	        var form_nombre = form["nombre"].value.trim();
	        var form_desc = form["descripcion"].value.trim();
	        var form_latitud = form["latitud"].value.trim();
	        var form_longitud = form["longitud"].value.trim();

	        // Reviso que los campos no esten vacios
	        if (form_numero == "") {
	            alert("Escriba un numero");
	            return false;
	        }
	        
	        if (form_nombre == "") {
	            alert("Escriba un nombre");
	            return false;
	        }
	        
	        if (form_desc == "") {
	            alert("Escriba una descripcion");
	            return false;
	        }
	        
	        if (form_latitud == "") {
	            alert("Escriba una latitud");
	            return false;
	        }
	        
	        if (form_longitud == "") {
	            alert("Escriba una longitud");
	            return false;
	        }
	        
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