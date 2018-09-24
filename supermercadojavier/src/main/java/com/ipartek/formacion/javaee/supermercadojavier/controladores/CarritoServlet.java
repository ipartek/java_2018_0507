package com.ipartek.formacion.javaee.supermercadojavier.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.javaee.supermercadojavier.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.supermercadojavier.pojo.Producto;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String accion = request.getParameter("accion");
		
		HttpSession session = request.getSession();
		
		List<Producto> productos = (List<Producto>)session.getAttribute("carrito");
		
		if(productos == null) {
			productos = new ArrayList<Producto>();
			session.setAttribute("carrito", productos);
		}
		
		if(id != null && accion != null) {
			Producto producto = LogicaNegocio.obtenerProductoPorId(Long.parseLong(id));
			
			productos.add(producto);
			
			session.setAttribute("carrito", productos);
		}
		
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
