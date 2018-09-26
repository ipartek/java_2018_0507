package com.ipartek.formacion.examen.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.logica.LogicaLibro;
import com.ipartek.formacion.examen.pojo.Libro;


@WebServlet("/escritura")
public class EscribirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String texto = request.getParameter("texto");
		
		Libro lb = new Libro(2,texto);
		
		LogicaLibro.agregarPagina(lb);
		
		request.getRequestDispatcher("index").forward(request, response);
		
	}

}
