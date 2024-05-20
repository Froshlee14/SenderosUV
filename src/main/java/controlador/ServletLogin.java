package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.UsuarioJB;
import datos.UsuarioDAO;

@WebServlet("/ServletLogin")

public class ServletLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      	UsuarioDAO userdao = new UsuarioDAO();
      	String user_name = request.getParameter("inputUsuario");
      	String password = request.getParameter("inputPassword").trim();
      	
        UsuarioJB usuario = userdao.selectPorNombre(user_name);
    	//System.out.println("hola");
        
        if (usuario!=null) {
        	if (usuario.get_contrasena().equals(password)) {
              
        		request.setAttribute("usuario",usuario);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                
        	}
        	else {
        		System.out.println("contraseña invalida");
            	request.setAttribute("mensaje_login","Contraseña invalida");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
        	}
        	
        }
        else {
        	System.out.println("usuario invalido");
        	request.setAttribute("mensaje_login","Usuario invalido");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
            
        

    }

}
