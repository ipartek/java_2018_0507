package com.ipartek.formacion.javaee.supermercado.servlets;

import java.io.IOException;
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
		String i = request.getParameter("ID");
		String nombre = request.getParameter("Nombre");
		String p = request.getParameter("Precio");
		String precioUm = request.getParameter("PrecioUm");
		String d = request.getParameter("Descuento");
		String ruta = request.getParameter("Ruta");
		
		long id = Long.parseLong(i);
		long precio = Long.parseLong(p);
		long descuento = Long.parseLong(d);
		
		//Producto prod = new Producto(id, nombre, precio, precioUm, descuento, ruta);
		//ArrayList<Producto> product = new ArrayList<Producto>();
		dao.insert(new Producto(id, nombre, precio, precioUm, descuento, ruta));
		//dao.insert(prod);
		Producto prod = new Producto(id, nombre, precio, precioUm, descuento, ruta);

		System.out.println(id);
		System.out.println(ruta);
	}

}
