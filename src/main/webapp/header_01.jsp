<%
UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
String mensaje = "";

if (usuario != null) {
    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
} else {
    mensaje = "Sesión iniciada como invitado";
}

%>

<style>
body, h1, h2, h3, h4, h5, h6  {
  font-family: Roboto, sans-serif;
}
</style>

<div class="w3-bar w3-border w3-light-grey ">
<!-- 	<b class="w3-text-blue">  SENDINA</b><b class="w3-text-green">UV</b> -->
  	<a href="index.jsp" class="w3-bar-item w3-button w3-hover-blue">  Inicio </a>
   	<a href="ServletSenderoLista" class="w3-bar-item w3-button  w3-hover-blue">Senderos</a>
	<a href="#" class="w3-bar-item w3-button  w3-hover-blue">Conocenos</a>
    <a href="#" class="w3-bar-item w3-button  w3-hover-blue">Ayuda</a>
  
	<div class="w3-dropdown-click w3-right">
      <button class="w3-button w3-hover-blue" onclick="myFunction()">
        &#9776;
      </button>
      <div id="demo" class="w3-dropdown-content w3-bar-block w3-card" style="display:none;right:0">
     	 <%
		if (usuario == null) {
		%>
		
		<form action="login.jsp">
        	<button type="submit" class="w3-bar-item w3-button w3-hover-blue">Iniciar sesion</button>
        </form> 
		
		<%  
		} else {
		%>
		
		<form action="ServletLogout" method="get">
        	<button type="submit" class="w3-bar-item w3-button w3-hover-blue">Cerrar sesion</button>
        </form> 
        
        <% 
			if (usuario.get_rol_usuario().equals("Administrador")){
		%>
        
        <form action="ServletUsuarioLista" method="get">
        	<button type="submit" class="w3-bar-item w3-button w3-hover-blue">Gestionar usuarios</button>
        </form>
		
		<% 
			}
		}
		
		%>
      </div>
    </div>

	<a class="w3-bar-item w3-text-gray w3-right" ><%=mensaje%></a>
</div>

<jsp:useBean id="usuarios" class="modelo.UsuarioJB" scope="request" />

<script>
	function myFunction() {
	  var x = document.getElementById("demo");
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	  }
	}
</script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">

