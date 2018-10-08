package com.ipartek.controlador;

import java.io.IOException;
import java.rmi.server.UID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.logica.LogicaNegocio;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class AnadirUsuario
 */
@WebServlet("/anadir")
public class AnadirUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario user = new Usuario(email, password);
		
		
		LogicaNegocio logica = new LogicaNegocio();
		//comprobamos que ese usuario no existe
		boolean resultado =  logica.validarUsuario(user);
		
		//si el usuario existe devolvemos error y redirigimos a anadirUsuario.jsp
		if(resultado) {
			
			request.setAttribute("error", "El usuario ya existe");
			request.getRequestDispatcher("admin/anadirUsuario.jsp").forward(request, response);
			
		} else {
			
			
			//almacenamos en un boolean lo que nos devuelve insertarUsuario que sera true o false
			boolean correcto = logica.insertarUsuario(user);
			//si lo ha insertado le redirigimos a listado
			if(correcto) {
				request.getRequestDispatcher("listado").forward(request, response);
				//si no ponemos un error y redirigimos a anadirUsuario
			}else {
				request.setAttribute("error", "El usuario no se ha insertado, no es valido");
				request.getRequestDispatcher("admin/anadirUsuario.jsp").forward(request, response);
			}
			
		
			
			
			
		}
		
		
		
	}

}
