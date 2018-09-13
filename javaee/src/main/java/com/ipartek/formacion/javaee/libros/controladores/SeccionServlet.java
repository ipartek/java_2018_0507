package com.ipartek.formacion.javaee.libros.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libros.modelos.Cabecera;

public class SeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		String titulo;
		
		switch(id) {
		case "1":
			titulo = "Informática";
			break;
		case "2":
			titulo = "Empresa";
			break;
		default:
			throw new ServletException("No se identifica ese código");
		}
		
		request.setAttribute("cabecera", new Cabecera(titulo));
		request.getRequestDispatcher("seccion.jsp").forward(request, response);
	}
}
