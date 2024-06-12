package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.UsuarioDAO;

@WebServlet("/ServletUsuarioBorrar")

public class ServletUsuarioBorrar  extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id_usuario = Integer.parseInt(request.getParameter(("id_usuario")));

		
        //Ahora si lo podemos borrar facilmente
        UsuarioDAO usuariodao = new UsuarioDAO();
        usuariodao.delete(id_usuario);
        
        response.sendRedirect("ServletUsuarioLista");
    }

}
