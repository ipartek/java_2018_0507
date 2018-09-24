package com.ipartek.formacion.javaee.supermercado.controladores.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.supermercado.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.supermercado.pojo.Producto;


@WebServlet("/admin/procesaredicion")
public class AdminProcesarEdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String accion = request.getParameter("accion");

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");

		Producto producto = null;

		RequestDispatcher edicion = request.getRequestDispatcher("edicion");
		try {
			switch (accion) {
			case "add":
				producto = new Producto(Long.parseLong(id), nombre, new BigDecimal(precio));
				LogicaNegocio.agregarProducto(producto);
				break;
			case "update":
				producto = new Producto(Long.parseLong(id), nombre, new BigDecimal(precio));
				LogicaNegocio.modificarProducto(producto);
				break;
			case "delete":
				LogicaNegocio.borrarProducto(Long.parseLong(id));
				break;
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.setAttribute("prod", producto);
			edicion.forward(request, response);
			return;
		}

		request.setAttribute("mensaje", "Operación correcta");
		request.getRequestDispatcher("index").forward(request, response);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


}
