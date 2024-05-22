package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.SenderoDAO;
import modelo.SenderoJB;
import datos.ZonaDAO;
import modelo.ZonaJB;

@WebServlet("/ServletSenderoModificar")

//Este servlet será usado para cargar la vista del registro de nuevos senderos ó cargar los datos 
//de uno ya existente para la modificacion de éstos.

public class ServletSenderoModificar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		SenderoJB sendero = new SenderoJB();
		SenderoDAO senderodao = new SenderoDAO();
	  	
	  	int id_sendero = Integer.parseInt(request.getParameter(("id_sendero")));
	  	
	  	if (id_sendero!=0) {
		    sendero = senderodao.select(id_sendero);
		    request.setAttribute("sendero", sendero);
	  	}
	  	

	    
	    //Tambien mando los fabricantes para mostrarlos en el <option>
		ZonaDAO zonadao = new ZonaDAO();
	    List<ZonaJB> zonas = zonadao.selectAll();
	    request.setAttribute("zonas",zonas);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("senderoEditor.jsp");
	    dispatcher.forward(request, response);
	 
	}
}