package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;


import modelo.UsuarioJB;

@WebServlet("/ServletIndex")

public class ServletIndex extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
        //System.out.println(usuario);
		request.setAttribute("usuario",usuario);
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward(request, response);   
        
    }

}
