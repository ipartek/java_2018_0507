package com.ipartek.formacion.javaee.libroelectronico.controladores;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libroelectronico.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Pagina;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageId = request.getParameter("page");
		
		if(pageId == null) {
			pageId = "1";
		}
		
		int pageNum = Integer.parseInt(pageId);
		
		// Obtener la página pasandole el id
		Pagina objetoPagina = LogicaNegocio.obtenerPaginaPorId(pageNum);
		
		// Obtener las páginas totales del libro
		int paginasTotales = LogicaNegocio.obtenerPaginas();
		
		request.setAttribute("numeroPaginas", paginasTotales);
		request.setAttribute("pagina", objetoPagina);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
