package com.ipartek.formacion.javaee.supermercado.servlets;

import java.io.IOException;
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
		String i = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String p = request.getParameter("precio");
		String precioUm = request.getParameter("precioUm");
		String d = request.getParameter("descuento");
		String ruta = request.getParameter("ruta");
		
		long id = Long.parseLong(i); 
		long precio = Long.parseLong(p);
		long descuento = Long.parseLong(d);
		
		Producto prod = new Producto(id, nombre, precio, precioUm, descuento, ruta);
		
		dao.insert(prod);
		
		
	}

}
