package com.ipartek.formacion.libroelectronico.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.libroelectronico.logica.LogicaNegocio;

@WebServlet("/buscarPalabra")
public class BuscarPalabraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palabra = request.getParameter("palabra");
		
		if(palabra != null) {
			request.setAttribute("resultadosBusqueda", LogicaNegocio.buscarTexto(palabra));
		}
		
		request.getRequestDispatcher("index").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
