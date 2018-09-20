package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.accesodatos.CarroArrayDAO;
import com.ipartek.formacion.javaee.accesodatos.CrudAble;
import com.ipartek.formacion.javaee.modelo.pojo.Carro;

public class CarroServlet extends HttpServlet {
	
	private static final long serialVersionUID = -7759264280495216368L;
	
	static CrudAble<Carro> dao = 
			CarroArrayDAO.getInstance();
	public static long id;
	public static int precio;
	public static String producto;
	public static int cantidad;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("prod1");
		String pass = request.getParameter("prod2");
		
		
		
	}
	private static void  anadirAlCarro() throws IOException{
		//datos
		id=0;
		dao.insert(new Carro(id, producto, precio,  cantidad));
		

	}
}
