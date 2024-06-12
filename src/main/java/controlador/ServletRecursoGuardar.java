package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

import javax.servlet.*;

import modelo.RecursoJB;
import datos.RecursoDAO;
import modelo.EstacionRecursoJB;
import datos.EstacionRecursoDAO;

@WebServlet("/ServletRecursoGuardar")

public class ServletRecursoGuardar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
	    int id_recurso = Integer.parseInt(request.getParameter("id_recurso"));
	    
	    System.out.println(id_recurso);
	    int id_estacion = Integer.parseInt(request.getParameter("id_estacion"));
	    int id_sendero = Integer.parseInt(request.getParameter("id_sendero"));
	    
	    int numero = Integer.parseInt(request.getParameter("numero"));
		String url = request.getParameter("url");
		String creditos = request.getParameter("creditos");
		int id_tipo_recurso = Integer.parseInt(request.getParameter("id_tipo_recurso"));
		
		RecursoJB recurso = new RecursoJB(id_recurso, numero, url, creditos, id_tipo_recurso);
		RecursoDAO recursodao = new RecursoDAO();
		
		//Si es igual a 0 significa que se trata de un nuevo registro
		if (id_recurso == 0 ) {
			//Verificamos si el registro se agregó correctamente
			//De ser asi, agregamos la referencia en la tabla-relacion
			int id_generado = recursodao.insert(recurso);
			if (id_generado!=0) {
				
				EstacionRecursoJB estacionrecurso = new EstacionRecursoJB(id_estacion, id_generado);
				EstacionRecursoDAO estacionrecursodao = new EstacionRecursoDAO();
				estacionrecursodao.insert(estacionrecurso);
			}
			else {
				System.out.println("No se pudo obtener la id generada");
			}
		}
		//De lo contrario se actualiza
		else {
			recursodao.update(recurso);
		}
        
        
		response.sendRedirect("ServletEstacionCargar?id_estacion=" + id_estacion+ "&id_sendero=" + id_sendero);

        
	}
}