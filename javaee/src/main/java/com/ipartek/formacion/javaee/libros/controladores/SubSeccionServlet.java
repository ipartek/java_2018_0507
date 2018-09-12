package com.ipartek.formacion.javaee.libros.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libros.modelos.Cabecera;
import com.ipartek.formacion.javaee.libros.modelos.Descripciones;

public class SubSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			String id = request.getParameter("id");
			String subId = request.getParameter("subId");
			String des = request.getParameter("des");
			
			String titulo="";
			
			
			switch(subId) {
			case "1":
				titulo = "Historia";
				des="En esta seccion podras encontrar los libros mas nuevos sobre historia";
				break;
			case "2":
				titulo = "Fantasia";
				des="En esta seccion podras encontrar los libros mas nuevos sobre fantasia";
				break;
			case "3":
				titulo = "Drama";
				des="En esta seccion podras encontrar los libros mas nuevos sobre drama";
				break;
			
			}
			
			request.setAttribute("cabecera", new Cabecera(titulo));
			request.setAttribute("descripciones", new Descripciones(des));
			request.getRequestDispatcher("subSeccion.jsp").forward(request, response);
	}

}
