package com.ipartek.formacion.examen.txakuretxe.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.txakuretxe.modelo.Usuario;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("principal").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(nombre, password);
		
		if (nombre.equals("scooby") && password.equals("galletas")) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("principal").forward(request, response);
		}
		else {
			request.getRequestDispatcher("principal").forward(request, response);
		}
			
	}

}
