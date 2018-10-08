package com.ipartek.formacion.ong.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ong.accesoadatos.UsuarioTreeMapDAO;
import com.ipartek.formacion.ong.modelos.Usuario;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null || password == null) {
			throw new RuntimeException("Introduce un usuario y contrase�a.");
		}
		
		Usuario usuario = new Usuario(nombre, password);
		
		//Recibo el usuario valido, que contiene el id del usuario
				Usuario usuarioValido = UsuarioTreeMapDAO.validarUsuario(usuario);
				
				if(usuarioValido != null) {	
					request.getSession().setAttribute("usuario", usuarioValido);
					request.getRequestDispatcher("index").forward(request, response); 
				} else {
					
					if(usuarioValido == null) {
						request.setAttribute("errores", "El usuario o contraseña no son validos");
					}
					request.setAttribute("usuario", usuario);
					request.getRequestDispatcher("login.jsp").forward(request, response); 
					
				}
	}
	

}