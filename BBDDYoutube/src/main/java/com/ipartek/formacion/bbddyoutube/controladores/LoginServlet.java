package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.logica.LogicaNegocio;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Recogida de datos de formularios, URLs, cookies, session...
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null || password == null) {
			throw new RuntimeException("Programador del login.jsp. Ya puedes poner un nick y un password.");
		}
		
		//2.Cargamos el modelo (en nuestro caso el pojo)
		Usuario usuario = new Usuario(nombre, password);
		
		//3.Lógica de negocio
		boolean usuarioValido = LogicaNegocio.validarUsuario(usuario);
		
		if(usuario.isCorrecto() && usuarioValido) {
			//4.Redirección a otra página con uno o varios modelos
			request.getSession().setAttribute("user", usuario);
			request.getRequestDispatcher("contenido").forward(request, response);
		} else {
			//4.Redirección a otra página con uno o varios modelos
			if(!usuarioValido) {
				request.setAttribute("errores", "El usuario no es válido");
			}
			request.setAttribute("user", usuario);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}
}
