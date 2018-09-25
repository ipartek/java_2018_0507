package com.borja.libreria.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.libreria.logica.LogicaNegocio;
import com.borja.libreria.pojo.Producto;

@WebServlet("/admin/edicion")
public class AdminEdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String ADD = "Añadir", UPDATE = "Modificar", DELETE = "Borrar";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String accion = request.getParameter("accion");

		String textoAccion = null;

		switch (accion) {
		case "add":
			textoAccion = ADD;
			break;
		case "update":
			textoAccion = UPDATE;
			cargarProducto(request, id);
			break;
		case "delete":
			textoAccion = DELETE;
			cargarProducto(request, id);
		}

		request.setAttribute("accion", textoAccion);
		request.getRequestDispatcher("edicion.jsp").forward(request, response);
	}

	private void cargarProducto(HttpServletRequest request, String id) {
		Producto producto;
		producto = LogicaNegocio.obtenerProductoPorId(Long.parseLong(id));
		request.setAttribute("prod", producto);
	}
}
