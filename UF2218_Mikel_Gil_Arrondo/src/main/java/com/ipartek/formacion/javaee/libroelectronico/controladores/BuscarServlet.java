package com.ipartek.formacion.javaee.libroelectronico.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libroelectronico.logica.LogicaNegocio;

@WebServlet("/buscar")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palabraABuscar = request.getParameter("buscador");
		
		if(palabraABuscar != null) {
			request.setAttribute("resultadosBusqueda", LogicaNegocio.buscarTexto(palabraABuscar));
		}
		
		request.getRequestDispatcher("index").forward(request, response);
	}
}
