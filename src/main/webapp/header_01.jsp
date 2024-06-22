<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
<style>
body, h1, h2, h3, h4, h5, h6  {
  font-family: "Varela Round", sans-serif;
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

<nav class="navbar navbar-expand-sm navbar-light border">

	<div class="navbar-nav mr-auto ">

		<a class="nav-item nav-link text-dark mr-3" href="index.jsp" type="button"> Inicio </a>
		<a class="nav-item nav-link text-dark mr-3" href="ServletSenderoLista" > Senderos </a>
		<a class="nav-item nav-link text-dark mr-3" href="#" type="button"> Conocenos </a>
		<a class="nav-item nav-link text-dark mr-3" href="#" type="button"> Ayuda </a>
	        
	</div>
    

    
    <div class="navbar-nav ml-auto">
    
    	<span class="navbar-text">
	    	<%=mensaje%>
		</span>
	    
	    <div class="nav-item dropdown">
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
	    </div>
	
	</div>

</nav>

<jsp:useBean id="usuarios" class="modelo.UsuarioJB" scope="request" />

