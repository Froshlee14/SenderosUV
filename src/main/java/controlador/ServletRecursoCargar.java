package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.RecursoDAO;
import modelo.RecursoJB;
import datos.TipoRecursoDAO;
import modelo.TipoRecursoJB;

@WebServlet("/ServletRecursoCargar")

//Este servlet será usado para cargar la vista del registro de nuevos senderos ó cargar los datos 
//de uno ya existente para la modificacion de éstos.

public class ServletRecursoCargar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RecursoJB recurso = new RecursoJB();
		RecursoDAO recursodao = new RecursoDAO();
	  	
	  	int id_recurso = Integer.parseInt(request.getParameter(("id_recurso")));
	  	int id_estacion = Integer.parseInt(request.getParameter(("id_estacion")));
	  	int id_sendero = Integer.parseInt(request.getParameter(("id_sendero")));
	  	
	  	
	  	if (id_recurso!=0) {
		    recurso = recursodao.select(id_recurso);
		    request.setAttribute("recurso", recurso);
	  	}
	  
	  	request.setAttribute("id_estacion", id_estacion);
	  	request.setAttribute("id_sendero", id_sendero);
	  	
	    //Tambien mando los tipos de recursos para mostrarlos en el <option>
	  	TipoRecursoDAO tiporecursodao = new TipoRecursoDAO();
	    List<TipoRecursoJB> tipo_recursos = tiporecursodao.selectAll();
	    request.setAttribute("tipo_recursos",tipo_recursos);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("recursoEditor.jsp");
	    dispatcher.forward(request, response);
	 
	}
}