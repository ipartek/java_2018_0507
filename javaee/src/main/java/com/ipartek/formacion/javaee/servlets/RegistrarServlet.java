package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.LoginFormException;

public class RegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<LoginForm> listalogins = new ArrayList<LoginForm>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		
		LoginForm lf = new LoginForm(); //USO LA CLASE LOGIN PORQUE VOY A COGER LOS MISMOS CAMPOS QUE HE USADO
														   //EN EL LOGIN NORMAL
		try {
			lf.setNombre(nombre);
		}
		catch (LoginFormException e){
			lf.setErrorNombre(nombre);
		}
		try {
			lf.setPassword(password);
		} catch (LoginFormException e) {
			lf.setErrorPassword("*");
		}
		
		if(!lf.isErroneo()) {
			lf.setNombre(nombre);
			lf.setPassword(password);
			listalogins.add(lf);
			request.setAttribute("DatosUsu", lf);
			request.getRequestDispatcher("index.jsp").forward(request, response);		
		}
		else{
			lf.setMensajeError(lf.getMensajeError() + "No han llegado los datos a la lista");
//			request.setAttribute("login", lf);
//			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
//	
//		private boolean validar(LoginForm login) {
//
//			for (int i = 0; i < listalogins.size(); i++) {
//				
//			}
//			
//		}

		
	}

}
