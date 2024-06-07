package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

import javax.servlet.*;


import modelo.EstacionJB;
import datos.EstacionDAO;
import modelo.SenderoEstacionJB;
import datos.SenderoEstacionDAO;

@WebServlet("/ServletEstacionGuardar")

public class ServletEstacionGuardar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
	    int id_sendero = Integer.parseInt(request.getParameter("id_sendero"));
	    
	    int id_estacion = Integer.parseInt(request.getParameter("id_estacion"));
	    int numero = Integer.parseInt(request.getParameter("numero"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		
		EstacionJB estacion = new EstacionJB(id_estacion, numero, nombre, descripcion, latitud, longitud);
		EstacionDAO estaciondao = new EstacionDAO();
		
		if (id_estacion == 0 ) {
			//Verificamos si el registro se agregó correctamente
			//De ser asi, agregamos la referencia en la tabla-relacion
			int id_generado = estaciondao.insert(estacion);
			if (id_generado!=0) {
				
				SenderoEstacionJB senderoestacion = new SenderoEstacionJB(id_sendero, id_generado);
				SenderoEstacionDAO senderoestaciondao = new SenderoEstacionDAO();
				senderoestaciondao.insert(senderoestacion);
			}
			else {
				System.out.println("No se pudo obtener la id generada");
			}
		}
		else {
			estaciondao.update(estacion);
		}
        
        
        response.sendRedirect("ServletSenderoCargar?id_sendero=" + id_sendero);

        
	}
}