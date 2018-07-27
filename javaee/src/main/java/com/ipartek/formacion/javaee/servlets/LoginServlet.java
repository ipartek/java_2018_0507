package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.println("Si querías hacer un login, tienes que venir por post");
		
		pw.println("Hola a todos: " + new java.util.Date());
		
		String ruta = request.getContextPath();
		
		pw.println(ruta);
			
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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

}
