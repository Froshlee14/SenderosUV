<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
body, h1, h2, h3, h4, h5, h6  {
  font-family: Roboto, sans-serif;
}
</style>

<%
UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
String mensaje = "";

if (usuario != null) {
    mensaje = "Sesi�n iniciada como " + usuario.get_rol_usuario();
} else {
    mensaje = "Sesi�n iniciada como invitado";
}

%>

<nav class="navbar navbar-expand-sm bg-light navbar-light sticky-top">

	<ul class="navbar-nav mr-auto">
	
		<li class="nav-item mr-3">
	      <a class="nav-link text-dark " href="index.jsp" type="button"> Inicio </a>
	    </li>
	    
	    <li class="nav-item mr-3">
	      <a class="nav-link text-dark" href="ServletSenderoLista" > Senderos </a>
	    </li>
	
	    <li class="nav-item mr-3">
	      <a class="nav-link text-dark" href="#" > Conocenos </a>
	    </li>
	    
	        <li class="nav-item mr-3">
	      <a class="nav-link text-dark" href="#" > Ayuda </a>
	    </li>
	        
	</ul>
    
	<span class="navbar-text ml-auto">
	    	<%=mensaje%>
	</span>
    
    <ul class="navbar-nav ml-auto">
	    
	    <li class="nav-item dropdown">
	      <a class="nav-link text-dark" href="#" id="navbardrop" data-toggle="dropdown">
	         &#9776;
	      </a>
	      <div class="dropdown-menu dropdown-menu-right">
	      	<% if (usuario == null) { %>
	        <a class="dropdown-item" href="login.jsp">Iniciar Sesion</a>
	        <% } else {%>
	        <a class="dropdown-item" href="ServletLogout">Cerrar sesion</a>
	        <% if (usuario.get_rol_usuario().equals("Administrador")){ %>
	        <a class="dropdown-item" href="ServletUsuarioLista">Gestionar usuarios</a>
	        <% }} %>
	      </div>
	    </li>
	
	</ul>

</nav>

<jsp:useBean id="usuarios" class="modelo.UsuarioJB" scope="request" />

