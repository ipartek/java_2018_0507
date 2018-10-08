package com.ipartek.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.logica.LogicaNegocio;
import com.ipartek.modelo.UsuarioDAO;
import com.ipartek.pojo.Usuario;


@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//se recogen los parametros
		String email = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		//creamos un usuario con los datos introducidos
		Usuario user = new Usuario(email,password);
		
		//llamamos a la logica de negicio que valida el usuario para comprobar si existe 
	    LogicaNegocio logica = new LogicaNegocio();
	    boolean resultado = logica.validarUsuario(user);
	
	    //si existe usuario se le mete en la session y se le redirige a la pag index
	    
		if(resultado) {
			
			request.getSession().setAttribute("usuario", user);
			request.getRequestDispatcher("index").forward(request, response);
			
			//si no se crea un error y se le pasa a la jsp
		}else {
			
			request.setAttribute("emailFail", email );
			request.setAttribute("error", "El usuario o contrase�a es incorrecto");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
	}

}
