package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.EstacionDAO;

@WebServlet("/ServletEstacionBorrar")

public class ServletEstacionBorrar  extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id_sendero = Integer.parseInt(request.getParameter(("id_sendero")));
        int id_estacion = Integer.parseInt(request.getParameter(("id_estacion")));

		
        //Ahora si lo podemos borrar facilmente
        EstacionDAO estaciondao = new EstacionDAO();
        estaciondao.delete(id_estacion);
        
        response.sendRedirect("ServletSenderoCargar?id_sendero=" + id_sendero);
    }

}
