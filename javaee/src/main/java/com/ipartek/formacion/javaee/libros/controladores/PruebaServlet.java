package com.ipartek.formacion.javaee.libros.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libros.modelos.Prueba;

public class PruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("prueba", new Prueba("Prueba"));
		request.getRequestDispatcher("prueba.jsp").forward(request, response);
	}

}
