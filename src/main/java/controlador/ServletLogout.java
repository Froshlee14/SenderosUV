package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletLogout")

//Este servlet será usado eliminar el usuario en sesion

public class ServletLogout extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
        
        if (session != null) {
            session.removeAttribute("usuario");
            session.invalidate();
        }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	    dispatcher.forward(request, response);
	 
	}
}