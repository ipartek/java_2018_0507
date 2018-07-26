package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

public class RegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		
		String error = "";
		
		LoginForm lf = new LoginForm(nombre, password); //USO LA CLASE LOGIN PORQUE VOY A COGER LOS MISMOS CAMPOS QUE HE USADO
														   //EN EL LOGIN NORMAL
		
		List<LoginForm> listalogins = new ArrayList<LoginForm>();
		
		if (nombre.equals("") || nombre == null || password.equals("") || password == null) {
			error = "campo vacio";
			System.out.println(error);
		}
		else {
			listalogins.add(lf);
			request.getSession().setAttribute("DatosUsu", lf);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
		
	}

}
