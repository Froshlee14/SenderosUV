<%
UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
String mensaje = "";

if (usuario != null) {
    mensaje = "Sesión iniciada como " + usuario.get_rol_usuario();
} else {
    mensaje = "Sesión iniciada como invitado";
}

%>

<div class="w3-bar w3-border w3-light-grey">
  	<a href="index.jsp" class="w3-bar-item w3-button"> <b class="w3-text-blue">SENDINA</b><b class="w3-text-green">UV</b> </a>	
    <form action="login.jsp" method="get" class="nav-form w3-right">
        <button type="submit" class="w3-bar-item w3-button w3-hover-blue nav-button w3-blue">Iniciar sesion</button>
    </form>
    <a href="#" class="w3-bar-item w3-button w3-right w3-hover-blue">Ayuda</a>
	<a href="#" class="w3-bar-item w3-button w3-right w3-hover-blue">Conocenos</a>
	<a href="ServletSenderoLista" class="w3-bar-item w3-button w3-right w3-hover-blue">Senderos</a>
	<a class="w3-bar-item" ><%=mensaje%></a>
</div>

<jsp:useBean id="usuarios" class="modelo.UsuarioJB" scope="request" />


