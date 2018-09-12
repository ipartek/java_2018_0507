package com.ipartek.formacion.javaee.libros.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
            throws ServletException, IOException {
        
		String email = request.getParameter("inputEmail");
        String pass = request.getParameter("inputPassword");
        
		request.setAttribute("datosLogin", new Login(email, pass));
        request.getRequestDispatcher("plantilla.jsp").forward(request, response);
    }  
	
}
