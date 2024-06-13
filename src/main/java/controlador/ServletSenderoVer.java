package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.SenderoDAO;
import modelo.SenderoJB;
import datos.EstacionDAO;
import modelo.EstacionJB;

@WebServlet("/ServletSenderoVer")

//Este servlet será usado para cargar la vista del registro de nuevos senderos ó cargar los datos 
//de uno ya existente para la modificacion de éstos.

public class ServletSenderoVer extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		SenderoJB sendero = new SenderoJB();
		SenderoDAO senderodao = new SenderoDAO();
	  	
	  	int id_sendero = Integer.parseInt(request.getParameter(("id_sendero")));
	  	
	  	List<EstacionJB> estaciones = new ArrayList<>();
	  	
	  	if (id_sendero!=0) {
		    sendero = senderodao.select(id_sendero);
		    request.setAttribute("sendero", sendero);
		    
			EstacionDAO estaciondao = new EstacionDAO();
			estaciones = estaciondao.selectPorSendero(id_sendero,true);	
	  	}
	  	
	  	request.setAttribute("estaciones",estaciones);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("senderoViewer.jsp");
	    dispatcher.forward(request, response);
	 
	}
}