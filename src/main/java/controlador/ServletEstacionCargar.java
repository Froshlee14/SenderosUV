package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.EstacionDAO;
import modelo.EstacionJB;

@WebServlet("/ServletEstacionCargar")

//Este servlet será usado para cargar la vista del registro de nuevas estaciones ó cargar los datos 
//de uno ya existente para la modificacion de éstos.

public class ServletEstacionCargar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		EstacionJB estacion = new EstacionJB();
		EstacionDAO estaciondao = new EstacionDAO();
	  	
	  	int id_estacion = Integer.parseInt(request.getParameter(("id_estacion")));
	  	int id_sendero = Integer.parseInt(request.getParameter(("id_sendero")));
	  		
	  	if (id_estacion!=0) {
		    estacion = estaciondao.select(id_estacion);
		    request.setAttribute("estacion", estacion);
		    
	  	}
	    request.setAttribute("id_sendero", id_sendero);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("estacionEditor.jsp");
	    dispatcher.forward(request, response);
	 
	}
}