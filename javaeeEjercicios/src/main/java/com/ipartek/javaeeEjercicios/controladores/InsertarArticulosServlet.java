package com.ipartek.javaeeEjercicios.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.javaeeEjercicios.accesodatos.ProductosArrayDAO;
import com.ipartek.javaeeEjercicios.pojos.Producto;

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
		
		String nombre = request.getParameter("inputNombre");
		String categoria = request.getParameter("inputCategoria");
		String descripcion = request.getParameter("textareaDescripcion");
		int precio = Integer.parseInt(request.getParameter("inputPrecio"));
		int decimal = Integer.parseInt(request.getParameter("inputDecimal"));
		int descuento = Integer.parseInt(request.getParameter("inputDescuento"));
		
		String precioTotal = precio + "." + decimal;
		//Double precioTotal2 = Double.parseDouble(precioTotal);
		
		//Discount = bill - (bill * discount / 100)
		Double precioTotal2 = Double.parseDouble(precioTotal) - (Double.parseDouble(precioTotal) * descuento / 100);
		
		producto = new Producto(nombre, categoria, descripcion, precio, decimal, descuento, precioTotal2);
		
		ProductosArrayDAO.getInstance().insert(producto);
		
		/*for(int i = 0; i < ProductosArrayDAO.getInstance().getAll().size(); i++) {
			System.out.println(ProductosArrayDAO.getInstance().getAll().get(i).getNombre());
		}*/
		
		
		response.sendRedirect("index.jsp");
			
		//System.out.println("id "+ id+" nombre "+nombre+ " descripcion "+ descripcion+ " precio " +precio);
		//response.sendRedirect("regProd.html");
	}

}
