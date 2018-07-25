package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.Persona;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw;	
	String nombre,ruta,password;//peticion					//respuesta
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pw=response.getWriter();
		pw.println("hola a todos "+ new java.util.Date());
		pw.println("habe venido por post");
		ruta=request.getContextPath();		
		pw.println(ruta);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		nombre=request.getParameter("nombre");	
		password=request.getParameter("password");	
		
		if(nombre==null || password==null ) {
			nombre="DESCONOCIDO";
			throw new RuntimeException("no se han recibido los datos de nombre y/o password");
		}
		Persona login=new Persona(nombre,password);
		if("ñaki".equals(login.getNombre())	&& "ñ".equals(login.getPassword())) {
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("principal.jsp");				
			}
		else {
		//response.sendRedirect("error.html");
		//login.setMensajeError("usuario incorrecto");
		System.out.println(login.getNombre());
		request.setAttribute("login", login);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//if(nombre=="DESCONOCIDO" || password==)
		}
	}


}
