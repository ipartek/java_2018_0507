package com.ipartek.formacion.javaee.supermercado.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.supermercado.accesodatos.CrudAble;
import com.ipartek.formacion.javaee.supermercado.accesodatos.ProductoArrayDAO;
import com.ipartek.formacion.javaee.supermercado.pojo.Producto;




public class EditorServlet extends HttpServlet {
	static CrudAble<Producto> dao = 
			ProductoArrayDAO.getInstance();
	private static final long serialVersionUID = 7407550949072439775L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String i = request.getParameter("ID");
		String nombre = request.getParameter("Producto");
		String p = request.getParameter("Precio");
		String precioUm = request.getParameter("PrecioUm");
		String d = request.getParameter("Descuento");
		String ruta = request.getParameter("Ruta");
		
		long id = Long.parseLong(i);
		long precio = Long.parseLong(p);
		long descuento = Long.parseLong(d);
		
		//dao.insert(new Producto(id, nombre, precio, precioUm, descuento, ruta));
		//Producto prod = new Producto(id, nombre, precio, precioUm, descuento, ruta);
		
		for (int x = 0; x < 15; x++) {
			dao.insert(new Producto(x, "nimbre", x, "fsd", 12,"imgs/100x140.png"));
		}
		for(Producto prod: dao.getAll()) {
			
			System.out.println(prod.getNombre());
			
			
		}
			


	

	}
}
