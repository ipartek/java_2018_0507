package com.ipartek.formacion.javaee.uf2218.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.uf2218.logica.LogicaNegocio;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = -2004523021066993005L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("paginas", LogicaNegocio.obtenerPaginas());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
