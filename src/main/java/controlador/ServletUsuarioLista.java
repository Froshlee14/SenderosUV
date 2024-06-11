package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.UsuarioJB;
import datos.UsuarioDAO;

@WebServlet("/ServletUsuarioLista")

public class ServletUsuarioLista extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		List<UsuarioJB> lista = usuariodao.selectAll();
			
		if (lista.isEmpty()) {
	         System.out.println("Lista vacia ");
		}
		
		request.setAttribute("lista",lista);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioLista.jsp");
	    dispatcher.forward(request, response);   
        
    }

}
