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
    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
} else {
    mensaje = "Sesión iniciada como invitado";
}

%>

<nav class="navbar navbar-expand-sm navbar-light border ">

	<ul class="navbar-nav mr-auto">
	
		<li class="nav-item mr-3">
	      <a class="nav-link text-dark " href="index.jsp" type="button"> Inicio </a>
	    </li>
	    
	    <li class="nav-item mr-3">
	      <a class="nav-link text-dark" href="ServletSenderoLista" > Senderos </a>
	    </li>
	</ul>
    
    <ul class="navbar-nav ml-auto">
    
	    <span class="navbar-text">
	    	<%=mensaje%>
		</span>
	    
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

