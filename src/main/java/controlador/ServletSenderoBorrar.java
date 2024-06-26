package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.SenderoDAO;
import datos.EstacionDAO;

@WebServlet("/ServletSenderoBorrar")

public class ServletSenderoBorrar  extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id_sendero = Integer.parseInt(request.getParameter(("id_sendero")));
        
		//Primero borramos sus estaciones
        EstacionDAO estaciondao = new EstacionDAO();
        estaciondao.deletePorSendero(id_sendero);
		
        //Ahora si lo podemos borrar facilmente
        SenderoDAO senderodao = new SenderoDAO();
        senderodao.delete(id_sendero);
        
        response.sendRedirect("ServletSenderoLista");
    }

}
