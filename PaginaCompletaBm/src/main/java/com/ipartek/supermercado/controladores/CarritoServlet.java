package com.ipartek.supermercado.controladores;

import java.awt.SecondaryLoop;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.supermercado.accesoadatos.ArticuloArrayDao;
import com.ipartek.supermercado.pojo.Articulo;
import com.ipartek.supermercado.pojo.Carrito;

/**
 * Servlet implementation class CarritoServlet
 */
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String  numBoton,borrar;
       Articulo art;
      Carrito carro;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		carro=(Carrito)session.getAttribute("carro");
		 numBoton=request.getParameter("idBoton");
		 if(request.getParameter("borrarDelCarro")!=null) {
			 borrar=request.getParameter("borrarDelCarro");
			 carro.borrarArticulo(Long.parseLong(borrar));
		 }else {
		 art=ArticuloArrayDao.getInstance().getById(Long.parseLong(numBoton));
		 if(carro!=null)
		 carro.insertarArticulo(art);
		 }
		//session.setAttribute("carro", carro);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
