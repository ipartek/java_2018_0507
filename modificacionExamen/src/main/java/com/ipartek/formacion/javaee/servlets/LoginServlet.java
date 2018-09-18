package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 98629951452290912L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entra en get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(!user.equals("batman")) {
			System.out.println("usuario incorrecto");
		}
		if(user.equals("batman")&&pass.equals("batman")) {
			System.out.println("usuario y contraseña correctos correcto");
		}
		
	}

}
