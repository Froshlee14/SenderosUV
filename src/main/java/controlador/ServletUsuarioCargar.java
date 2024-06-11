package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.UsuarioDAO;
import modelo.UsuarioJB;

@WebServlet("/ServletUsuarioCargar")

//Este servlet será usado para cargar la vista del registro de nuevas estaciones ó cargar los datos 
//de uno ya existente para la modificacion de éstos.

public class ServletUsuarioCargar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		UsuarioJB usuario = new UsuarioJB();
		UsuarioDAO usuariodao = new UsuarioDAO();
	  	
	  	int id_usuario = Integer.parseInt(request.getParameter(("id_usuario")));
	  		
	  	if (id_usuario!=0) {
		    usuario = usuariodao.select(id_usuario);
		    request.setAttribute("usuario", usuario);
		    
	  	}
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioEditor.jsp");
	    dispatcher.forward(request, response);
	 
	}
}