package com.borja.libreria.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.libreria.logica.LogicaNegocio;
import com.borja.libreria.pojo.Pagina;

/**
 * Servlet implementation class EdicionServlet
 */
@WebServlet("/EdicionServlet")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("suuuu");
		request.setCharacterEncoding("UTF-8");
		String accion = request.getParameter("accion");

		String id = request.getParameter("id");
		String texto = request.getParameter("texto");
		String nick = request.getParameter("nick");

		Pagina pagina= null;

		RequestDispatcher edicion = request.getRequestDispatcher("edicion");

		try {
			switch (accion) {
			case "add":
				pagina = new Pagina(Long.parseLong(id), texto, nick);
				LogicaNegocio.agregarPagina(pagina);
				break;
			case "update":
				pagina = new Pagina(Long.parseLong(id), texto, nick);
				LogicaNegocio.modificarPagina(pagina);
				break;
			case "delete":
				LogicaNegocio.borrarPagina(Long.parseLong(id));
				break;
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.setAttribute("pag", pagina);
			edicion.forward(request, response);
			return;
		}

		request.setAttribute("mensaje", "Operación correcta");
		request.getRequestDispatcher("index").forward(request, response);
	}

}
