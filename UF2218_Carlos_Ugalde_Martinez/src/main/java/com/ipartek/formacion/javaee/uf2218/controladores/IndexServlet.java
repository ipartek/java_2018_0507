package com.ipartek.formacion.javaee.uf2218.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.uf2218.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.uf2218.pojo.Pagina;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 5842348314775091239L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("pagina");
		
		if(pagina == null) {
			pagina = "1";
		}
		
		int numeroPagina = Integer.parseInt(pagina);
		
		Pagina objetoPagina = LogicaNegocio.obtenerPaginasPorId(numeroPagina);
		
		int numeroPaginas = LogicaNegocio.obtenerNumeroPaginas();
		int numPaginas = LogicaNegocio.obtenerNumeroPaginas();
		request.setAttribute("numPaginas", numPaginas);
		request.setAttribute("numeroPaginas", numeroPaginas);
		request.setAttribute("pagina", objetoPagina);
request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
