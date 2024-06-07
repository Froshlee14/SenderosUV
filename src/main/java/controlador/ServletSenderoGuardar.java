package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.*;

import modelo.SenderoJB;
import datos.SenderoDAO;
import modelo.ZonaSenderoJB;
import datos.ZonaSenderoDAO;

@WebServlet("/ServletSenderoGuardar")

public class ServletSenderoGuardar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
	    int id_sendero = Integer.parseInt(request.getParameter("id_sendero"));
		
		String nombre = request.getParameter("nombre");
		String sede = request.getParameter("sede");
		int id_zona = Integer.parseInt(request.getParameter("id_zona"));
		
		Date year = null;
		String year_temp = request.getParameter("year");
		LocalDate year_local = null;
		//Conversion de la fecha al formato que se almacena en la BD
		try {
			year_local = LocalDate.parse(year_temp);
		    year = Date.valueOf(year_local);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}

		String url_recursos = request.getParameter("url_recursos");
		
		SenderoJB sendero = new SenderoJB(id_sendero, nombre, sede, year, id_zona, url_recursos);
		SenderoDAO senderodao = new SenderoDAO();
		
		if (id_sendero == 0 ) {
			//Verificamos si el registro se agregó correctamente
			//De ser asi, agregamos la referencia en la tabla-relacion
			int id_generado = senderodao.insert(sendero);
			if (id_generado!=0) {
				
				ZonaSenderoJB zonasendero = new ZonaSenderoJB(id_zona, id_generado);
				ZonaSenderoDAO zonasenderodao = new ZonaSenderoDAO();
				zonasenderodao.insert(zonasendero);
			}
			else {
				System.out.println("No se pudo obtener la id generada");
			}
		}
		else {
			senderodao.update(sendero);
		}
        
        
        response.sendRedirect("ServletSenderoLista");//("ServletContactoLista?numEmpleado=" + numEmpleado);

        
	}
}
