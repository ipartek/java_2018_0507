package com.ipartek.formacion.javaee.uf2218.controladores;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.uf2218.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.uf2218.pojo.Pagina;



@WebServlet("/nueva")
public class NuevaPaginaServlet extends HttpServlet {

	private static final long serialVersionUID = -6633735927655470959L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/nuevaPagina.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("5");
		String nombre = request.getParameter("nombre");
		String texto = request.getParameter("texto");

		Pagina pagina = null;

		pagina = new Pagina(Long.parseLong(id), nombre, texto);
		LogicaNegocio.agregarPagina(pagina);
		response.sendRedirect(request.getContextPath() + "/main.jsp");
	}

}
