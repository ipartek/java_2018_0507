package com.ipartek.formacion.javaee.libros.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libros.modelo.Cabecera;

public class EtiquetaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws
			ServletException, IOException {
		//Id es string porque siempre va a recibir un string
		String id = request.getParameter("id");
		
		String titulo;
		
		switch(id){
		case "1":
			titulo = "Gato";
			break;
		case "2":
			titulo = "Gatazo";
			break;
			default:
				throw new ServletException("Code not identified");
		}
		request.setAttribute("cabecera", new Cabecera(titulo));
		//request.getRequestDispatcher("seccion.jsp").forward(request, response);
	}	
	
}
