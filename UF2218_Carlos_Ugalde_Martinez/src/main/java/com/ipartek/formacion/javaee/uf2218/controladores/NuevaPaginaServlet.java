package com.ipartek.formacion.javaee.uf2218.controladores;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.uf2218.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.uf2218.pojo.Pagina;



@WebServlet("/nueva")
public class NuevaPaginaServlet extends HttpServlet {

	private static final long serialVersionUID = -6633735927655470959L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numPaginas = LogicaNegocio.obtenerNumeroPaginas();
		request.setAttribute("numPaginas", numPaginas);
		request.getRequestDispatcher("nuevaPagina.jsp").forward(request, response);
//		request.setAttribute("paginas", LogicaNegocio.obtenerPaginas());
//		response.sendRedirect(request.getContextPath() + "/nuevaPagina.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//String id = request.getParameter("27");
		long id = LogicaNegocio.obtenerNumeroPaginas() + 1;
		String nombre = request.getParameter("nombre");
		String texto = request.getParameter("texto");

		Pagina pag = null;
		
		pag = new Pagina(id, nombre, texto);
		boolean correcto = LogicaNegocio.agregarPagina(pag);
		Pagina pagina = LogicaNegocio.obtenerPaginasPorId(Long.parseLong("1"));
		request.setAttribute("pagina",pagina);
		int numPaginas = LogicaNegocio.obtenerNumeroPaginas();
		request.setAttribute("numPaginas", numPaginas);
		response.sendRedirect(request.getContextPath() + "/main.jsp");
	}

}
