package com.ipartek.formacion.javaee.uf2218.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.uf2218.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.uf2218.pojo.Pagina;

@WebServlet("/buscador")
public class BuscaPalabrasServlet extends HttpServlet {

	private static final long serialVersionUID = -1996693404767821397L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palabra = request.getParameter("palabra");
		
		if(palabra != null) {
			request.setAttribute("resultadosBusqueda", LogicaNegocio.buscarTexto(palabra));
		}
		Pagina pagina = LogicaNegocio.obtenerPaginasPorId(Long.parseLong("1"));
		request.setAttribute("pagina",pagina);
		int numPaginas = LogicaNegocio.obtenerNumeroPaginas();
		request.setAttribute("numPaginas", numPaginas);
		request.getRequestDispatcher("main").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
