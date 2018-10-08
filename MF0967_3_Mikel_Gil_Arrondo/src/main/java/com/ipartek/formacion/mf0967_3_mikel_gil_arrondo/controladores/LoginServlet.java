package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.logica.LogicaNegocio;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Usuario;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
			request.getSession().setAttribute("user", usuario);
		} else {
			if(!usuarioValido) {
				request.setAttribute("errores", "El usuario no es válido");
			}		}
		request.getRequestDispatcher("index").forward(request, response);
	}
}
