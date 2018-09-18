package com.ipartek.formacion.javaeeEjercicios.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaeeEjercicios.accesodatos.ProductosArrayDAO;
import com.ipartek.formacion.javaeeEjercicios.pojos.Producto;

/**
 * Servlet implementation class ArticuloServlet
 */
public class InsertarArticulosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Producto producto;
	ProductosArrayDAO productos;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		String descripcion = request.getParameter("descripcion");
		int precio = Integer.parseInt(request.getParameter("precio"));
		int decimal = Integer.parseInt(request.getParameter("decimal"));
		int descuento = Integer.parseInt(request.getParameter("descuento"));
		
		producto = new Producto(nombre, categoria, descripcion, precio, decimal, descuento);
		
		ProductosArrayDAO.getInstance().insert(producto);
		
		for(int i = 0; i < ProductosArrayDAO.getInstance().getAll().size(); i++) {
			System.out.println(ProductosArrayDAO.getInstance().getAll().get(i).getNombre());
		}
			
		//System.out.println("id "+ id+" nombre "+nombre+ " descripcion "+ descripcion+ " precio " +precio);
		//response.sendRedirect("regProd.html");
	}

}
