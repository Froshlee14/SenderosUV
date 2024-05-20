package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.SenderoJB;
import modelo.UsuarioJB;
import datos.SenderoDAO;

@WebServlet("/ServletSenderosLista")

public class ServletSenderosLista extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		UsuarioJB usuario = (UsuarioJB) session.getAttribute("usuario");
		//System.out.println("Servlet: "+usuario);
		request.setAttribute("usuario",usuario);
		
		SenderoDAO senderodao = new SenderoDAO();
		List<SenderoJB> lista = senderodao.selectAll();
			
		if (lista.isEmpty()) {
	         System.out.println("Lista vacia ");
		}
		
		request.setAttribute("lista",lista);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("senderosLista.jsp");
	    dispatcher.forward(request, response);   
        
    }

}
