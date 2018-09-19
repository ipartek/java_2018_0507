package com.ipartek.formacion.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.DAO.BotellaArrayDAO;
import com.ipartek.formacion.pojo.supermercado.Botella;


public class registroProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String precio = request.getParameter("precio");
		
		
		
//		PrintWriter out = response.getWriter();
//		out.println(nombre);
		
		Botella bot = new Botella(Long.parseLong(id),nombre, tipo, Double.parseDouble(precio));
		BotellaArrayDAO.getInstance().insert(bot);
		
		
		request.setAttribute("botellas", BotellaArrayDAO.getInstance().getAll());
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}

}
