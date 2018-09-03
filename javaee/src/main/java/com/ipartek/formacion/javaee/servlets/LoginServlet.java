package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.util.ArrayList;
=======
>>>>>>> refs/heads/master

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.LoginFormException;

public class LoginServlet extends HttpServlet {

	private static final String USUARIO_POR_DEFECTO = "javierniño";
	private static final String PASSWORD_POR_DEFECTO = "contra";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		


		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		String boton=request.getParameter("boton");
		int bot=0;
		try {
			bot=Integer.parseInt(boton);
		}catch(Exception e) {
			System.out.println("error al combertir el boton en numero");
		} 
		if(nombre == null || password == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		LoginForm login = new LoginForm(nombre, password);
		System.out.println(bot);
<<<<<<< HEAD
		if(bot==1){
		if(validar(login)) {
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("principal.jsp");
		}else {
			if(!validarnombre(login)) {
				login.setNombre("nombre incorrecto");
			}else {
				login.setNombre("");
			}
			if(!validarcontraseina(login)) {
				login.setPassword("pasword incorrecto");
			}else {
				login.setPassword("");
			}
		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		}
		if(bot==2) {
			if(validar(login)==false) {
				LoginForm.getLista().add(login);
				login.setMensajeError("usuario añadido");
				response.sendRedirect("index.jsp");
			}else {
				login.setMensajeError("usuario no añadido");
				response.sendRedirect("index.jsp");
			}
		}
		
=======
		
		System.out.println(nombre);
		
		//Empaquetado en Modelo
		LoginForm login = new LoginForm();
		
		try {
			login.setNombre(nombre);
		} catch (LoginFormException e) {
			login.setErrorNombre("*");
		}
>>>>>>> refs/heads/master
			
<<<<<<< HEAD
	}

	private boolean validar(LoginForm login) {
		ArrayList<LoginForm> listi=LoginForm.getLista();
		for(int i=0; i<listi.size();i++) {
			
			if((login.getNombre().equals(listi.get(i).getNombre()))&&(login.getPassword().equals(listi.get(i).getPassword()))){
				return listi.get(i).getNombre().equals(login.getNombre()) && listi.get(i).getPassword().equals(login.getPassword());
				
			}
		}
		return false;
		
	}
	private boolean validarcontraseina(LoginForm login) {
		ArrayList<LoginForm> listi=LoginForm.getLista();
		for(int i=0; i<listi.size();i++){
			
			if(login.getPassword().equals(listi.get(i).getPassword())){
				return true;
				
			}
			}return false;
		}
		
	
	private boolean validarnombre(LoginForm login) {
		ArrayList<LoginForm> listi=LoginForm.getLista();
		for(int i=0; i<listi.size();i++){
			
			if(login.getNombre().equals(listi.get(i).getNombre())){
				return true;
				
			}
			}return false;
		}
=======
		if(bot==1) {
		if(validar(login)) {
=======
		try {
			login.setPassword(password);
		} catch (LoginFormException e) {
			login.setErrorPassword("*");
		}

		//Llamada a lógica de negocio
		if(!login.isErroneo() && validar(login)) {
			//Redirección a vista
>>>>>>> refs/heads/master
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("principal.jsp");
		} else {
<<<<<<< HEAD
			//response.sendRedirect("error.html");
			//login.setMensajeError("El usuario o contraseña no son correctos");
=======
			//Redirección a vista
			login.setMensajeError(login.getMensajeError() + " El usuario o contraseña no son correctos");
>>>>>>> refs/heads/master
			request.setAttribute("login", login);
<<<<<<< HEAD
			if(!validarnombre(login)) {
				login.setNombre("error nombre");
			}else {
				login.setNombre("");
			}
			if(!validarcontraseina(login)) {
				login.setPassword("error pasword");
			}else {
				login.setPassword("");
			}
			if(!validarcontraseina(login)&&!validarnombre(login)) {
			login.setMensajeError("contraseña  y usuario incorrectos");
			}else {
				login.setPassword("");
				login.setNombre("");
			}
			
		}
		}
		if(bot==2) {
			if(validar(login)==false) {
				LoginForm.getLista().add(login);
				login.setMensajeError("usuario añadido");
				response.sendRedirect("index.jsp");
			}else {
				login.setMensajeError("usuario no añadido");
				response.sendRedirect("index.jsp");
			}
		}
		
			
=======
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
>>>>>>> refs/heads/master
	}

	private boolean validar(LoginForm login) {
<<<<<<< HEAD
		ArrayList<LoginForm> listi=LoginForm.getLista();
		for(int i=0; i<listi.size();i++) {
			
			if((login.getNombre().equals(listi.get(i).getNombre()))&&(login.getPassword().equals(listi.get(i).getPassword()))){
				return listi.get(i).getNombre().equals(login.getNombre()) && listi.get(i).getPassword().equals(login.getPassword());
				
			}
		}
		return false;
		
=======
		return USUARIO_POR_DEFECTO.equals(login.getNombre()) && PASSWORD_POR_DEFECTO.equals(login.getPassword());
>>>>>>> refs/heads/master
	}
	private boolean validarcontraseina(LoginForm login) {
		return "contra".equals(login.getPassword());
	}
	private boolean validarnombre(LoginForm login) {
		return "javierniño".equals(login.getNombre());
	}
>>>>>>> refs/remotes/origin/tt

	private static final long serialVersionUID = 1L;
}
