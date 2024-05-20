<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.UsuarioJB"%>
<!DOCTYPE html>

<html>


	<head>
		<title>SendinaUV</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>

	<body>
	
		<%
		UsuarioJB usuario = (UsuarioJB) request.getAttribute("usuario");
		String mensaje = "";
		
		if (usuario != null) {
		    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
		} else {
		    mensaje = "Sesión iniciada como invitado";
		}
		
		session.setAttribute("usuario", usuario);
		%>
	
		<div class="w3-bar w3-border w3-light-grey">
		  <a href="ServletIndex" class="w3-bar-item w3-button">SENDINA UV</a>
        <form action="login.jsp" method="get" class="nav-form w3-right">
            <button type="submit" class="w3-bar-item w3-button w3-hover-blue nav-button w3-blue">Iniciar sesion</button>
        </form>
        	<a href="#" class="w3-bar-item w3-button w3-right w3-hover-blue"">Ayuda</a>
			<a href="#" class="w3-bar-item w3-button w3-right w3-hover-blue"">Conocenos</a>
			<a href="ServletSenderosLista" class="w3-bar-item w3-button w3-right w3-hover-blue">Senderos</a>
		</div>
	
		<jsp:useBean id="usuarios" class="modelo.UsuarioJB" scope="request" />
	

		<p><%=mensaje%></p>	
	<p>	
Los Senderos Interpretativos son espacios que permiten tener un contacto directo con 
los visitantes para el desarrollo de una temática o un tópico particular y así, transmitir 
valores sobre los cuales se quiere dar un mensaje. Cada sendero tiene un objetivo 
específico que se sustenta en el desarrollo de las actividades, centrando la atención en 
aspectos con los que el visitante pueda interiorizar y que, a la vez, sirva de hilo conductor 
de los contenidos del mensaje.
</p>	
<p>
Para la Universidad Veracruzana los Senderos Interpretativos son espacios de escenarios 
reales de aprendizaje para los estudiantes. Estos espacios se han destinado a la 
construcción de proyectos ambientales con enfoques sustentables, siendo una fuente 
importante de formación de recursos humanos mediante el desarrollo de temas de tesis 
de grado de licenciatura y posgrado.
</p>	
<p>
Actualmente, la Universidad ha implementado 3 senderos interpretativos en sus distintas
facultadas distribuido en las regiones de Orizaba-Córdoba y Xalapa. El primer sendero 
desarrollado en el 2018 en el Centro Universitario para las Artes, Ciencias y Cultura, 
Córdoba, el segundo en el 2022 en la Universidad Veracruzana Intercultural (UVI), Sede 
Grandes Montañas y el ultimo en el 2023 en la Unidad de Ciencias de la Salud – Xalapa 
(UCS-X). Nuestros senderos interpretativos comparten una misma visión, la gestión
integral del agua como objetivo principal para el dialogo y la reflexión, pero cada uno 
abordado desde un tópico diferente como son: la importancia de los entornos naturales;
la relación del hombre, agua y cambio climático; la relación del hombre, agua y salud.
Descubre, aprende y divierte en nuestros corridos virtuales de nuestros senderos.
	</p>	
	
	</body>
</html>
