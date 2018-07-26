package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.Persona;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String nombre,apellido,dni,pass,repPass;
	Persona p;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		nombre=request.getParameter("nombre");
		apellido=request.getParameter("apellido");
		dni=request.getParameter("dni");
		pass=request.getParameter("password");
		repPass=request.getParameter("repPass");
		p=new Persona(nombre,apellido,dni,pass,repPass);
		//response.sendRedirect("registro.jsp");
		request.setAttribute("registroServlet", p);
		request.getRequestDispatcher("registro.jsp").forward(request, response);

	}

}
