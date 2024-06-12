package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.RecursoDAO;

@WebServlet("/ServletRecursoBorrar")

public class ServletRecursoBorrar  extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int id_recurso = Integer.parseInt(request.getParameter(("id_recurso")));
        int id_sendero = Integer.parseInt(request.getParameter(("id_sendero")));
        int id_estacion = Integer.parseInt(request.getParameter(("id_estacion")));

		
        //Ahora si lo podemos borrar facilmente
        RecursoDAO recursodao = new RecursoDAO();
        recursodao.delete(id_recurso);
        
        response.sendRedirect("ServletEstacionCargar?id_estacion=" + id_estacion+"&id_sendero="+id_sendero);
    }

}
