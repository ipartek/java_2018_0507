package com.ipartek.superonline.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.superonline.modelo.ProductoDAO;
import com.ipartek.superonline.pojo.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	Producto producto;
	ProductoDAO productos;
	
	
	
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		PrintWriter out=response.getWriter();
		
		long id=Long.parseLong(request.getParameter("id"));
		String nombre=request.getParameter("nombre");
		String descripcion=request.getParameter("descripcion");
		int precio=Integer.parseInt(request.getParameter("precio"));
		producto=new Producto(nombre, descripcion, precio , id);
		ProductoDAO.getInstance().insert(producto);
		
		//response.sendRedirect("regProd.html");
		System.out.println("id "+ id+" nombre "+nombre+ " descripcion "+ descripcion+ " precio " +precio);
		//response.sendRedirect("regProd.html");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
