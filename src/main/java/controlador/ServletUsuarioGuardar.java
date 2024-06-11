package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

import javax.servlet.*;


import modelo.UsuarioJB;
import datos.UsuarioDAO;

@WebServlet("/ServletUsuarioGuardar")

public class ServletUsuarioGuardar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
	    int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		int id_rol_usuario = Integer.parseInt(request.getParameter("id_rol_usuario"));
		
		UsuarioJB usuario = new UsuarioJB(id_usuario, nombre, contrasena, id_rol_usuario);
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		if (id_usuario == 0 ) {
			usuariodao.insert(usuario);

		}
		else {
			usuariodao.update(usuario);
		}
        
        
        response.sendRedirect("ServletUsuarioLista");

        
	}
}