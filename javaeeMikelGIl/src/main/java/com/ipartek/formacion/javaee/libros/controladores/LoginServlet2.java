package com.ipartek.formacion.javaee.libros.controladores;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libros.modelos.Login;

/** 
 * Servlet implementation class LoginServlet2
 */
public class LoginServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        
		String email = request.getParameter("inputEmail");
        String pass = request.getParameter("inputPassword");
        
		request.setAttribute("datosLogin", new Login(email, pass));
    }  
	
}
