package com.ipartek.formacion.examen.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.pojo.Usuario;
import com.ipartek.formacion.examen.logica.LogicaLibro;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre == null || password == null) {
			throw new RuntimeException("Tienes que insertar los datos en cada campo");
		}
		
		Usuario usuario = new Usuario(nombre, password);
		
		boolean usuarioValido = LogicaLibro.validarUsuario(usuario);
		
		if(usuario.isCorrecto() && usuarioValido) {
			
			request.getSession().setAttribute("user", usuario);
			request.getRequestDispatcher("//crear una servlet princiapl y rediderccionar").forward(request, response);
		} else {
			if(!usuarioValido) {
				request.setAttribute("errores", "El usuario no es válido");
			}
			request.setAttribute("user", usuario); 
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
