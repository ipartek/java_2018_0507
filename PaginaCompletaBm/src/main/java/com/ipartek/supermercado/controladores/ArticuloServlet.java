package com.ipartek.supermercado.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.supermercado.accesoadatos.ArticuloArrayDao;
import com.ipartek.supermercado.pojo.Articulo;

/**
 * Servlet implementation class ArticuloServlet
 */
public class ArticuloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Articulo articulo;
	ArticuloArrayDao articulos;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		long id=Long.parseLong(request.getParameter("id"));
		String nombre=request.getParameter("nombre");
		String descripcion=request.getParameter("descripcion");
		int precio=Integer.parseInt(request.getParameter("precio"));
		articulo=new Articulo(id, precio, nombre, descripcion);
		ArticuloArrayDao.getInstance().insert(articulo);
		response.sendRedirect("regProd.html");
		//System.out.println("id "+ id+" nombre "+nombre+ " descripcion "+ descripcion+ " precio " +precio);
		//response.sendRedirect("regProd.html");
	}

}
