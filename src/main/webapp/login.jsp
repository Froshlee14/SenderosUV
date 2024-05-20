<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>SENDINAUV</title>
	</head>
	
	<body >
		
		
		<div  class="window" style="width: 250px; margin: 32px; ">
  			
  			<img src="https://southcentralus1-mediap.svc.ms/transform/thumbnail?provider=spo&inputFormat=png&cs=fFNQTw&docid=https%3A%2F%2Fuvmx-my.sharepoint.com%3A443%2F_api%2Fv2.0%2Fdrives%2Fb!oJKEwJay50WL-LGImx-vq-yYdZtzRRNIsw7iP38B-fmH95NNCKqzTajWF4INBMRc%2Fitems%2F01LU5DPTWGSDIRK3QCCNF3YU5MTQS5XXG2%3Fversion%3DPublished&access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvdXZteC1teS5zaGFyZXBvaW50LmNvbUAzYzkwNzY1MS1kOGM2LTRjYTYtYThhNC02YTI0MjQzMGU2NTMiLCJjYWNoZWtleSI6IjBoLmZ8bWVtYmVyc2hpcHx1cm4lM2FzcG8lM2Fhbm9uIzdjMDczYTNmNWJlMGIyYWM5MjA3ODdlYzhkYzJlMmEyMThjMzlhZTNkYTkwOWVjNTI0MzEyODdjOTg4ZTY3NjQiLCJlbmRwb2ludHVybCI6IlFXN1V3Yk52WVI0UWU4WkZzWDNLc3UyY1Q3bU9TbnI0UDZIL2lGS0FvZXM9IiwiZW5kcG9pbnR1cmxMZW5ndGgiOiIxMTQiLCJleHAiOiIxNzE2MTc0MDAwIiwiaXBhZGRyIjoiMjgwNjoxMGE2OjExOjc4NTM6YjU3MDo4NDE5OmU2YzU6MWQ3OCIsImlzbG9vcGJhY2siOiJUcnVlIiwiaXNzIjoiMDAwMDAwMDMtMDAwMC0wZmYxLWNlMDAtMDAwMDAwMDAwMDAwIiwiaXN1c2VyIjoidHJ1ZSIsIm5hbWVpZCI6IjAjLmZ8bWVtYmVyc2hpcHx1cm4lM2FzcG8lM2Fhbm9uIzdjMDczYTNmNWJlMGIyYWM5MjA3ODdlYzhkYzJlMmEyMThjMzlhZTNkYTkwOWVjNTI0MzEyODdjOTg4ZTY3NjQiLCJuYmYiOiIxNzE2MTUyNDAwIiwibmlpIjoibWljcm9zb2Z0LnNoYXJlcG9pbnQiLCJzaGFyaW5naWQiOiJHU1R4OG1NRUxFQ2xSalcwS2Rib0NBIiwic2l0ZWlkIjoiWXpBNE5Ea3lZVEF0WWpJNU5pMDBOV1UzTFRoaVpqZ3RZakU0T0RsaU1XWmhabUZpIiwic25pZCI6IjYiLCJzdHAiOiJ0IiwidHQiOiIwIiwidmVyIjoiaGFzaGVkcHJvb2Z0b2tlbiJ9.tn2QfbGDiCPGXC9fdtDNYNgNWvNNBKGMvPzgFW8rnEo&cTag=%22c%3A%7B15D190C6-026E-4B13-BC53-AC9C25DBDCDA%7D%2C3%22&encodeFailures=1&width=714&height=714&srcWidth=1024&srcHeight=1024" style="width: 100%"/>
  			
  			<div class="window-body">
			<form action="ServletLogin" method="post">
			
				<div class="field-row-stacked">
			
				<div class="field-row-stacked" style="width: 100%">
					<label for="usuario">Usuario:</label>
			    	<input id="usuario" type="text" name="inputUsuario"> 
			    </div>
			    
			    <div class="field-row-stacked" style="width: 100%">
			    	<label for="password">Contraseña:</label>
			    	<input id="password" type="password" name="inputPassword"> 
			    </div>
			    
				<%
				String mensaje = (String) request.getAttribute("mensaje");
				if (mensaje != null && !mensaje.isEmpty()) {
				%>
    				<p><%= mensaje %></p>
				<% } %>

        		<input type="submit" name="loginBoton" value="Iniciar Sesion">
        		
        		</div>
        		
    		</form>
    		</div>
    	</div>

	</body>
	
</html>