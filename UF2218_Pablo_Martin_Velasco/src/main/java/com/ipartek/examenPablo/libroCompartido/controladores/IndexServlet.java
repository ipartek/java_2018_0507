package com.ipartek.examenPablo.libroCompartido.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.examenPablo.libroCompartido.logica.LogicaNegocio;
import com.ipartek.examenPablo.libroCompartido.pojo.Pagina;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("pagina");
		
		if(pagina == null) {
			pagina = "1";
		}
		
		int numeroPagina = Integer.parseInt(pagina);
		
		Pagina objetoPagina = LogicaNegocio.obtenerPagina(numeroPagina);
		
		int numeroPaginas = LogicaNegocio.obtenerNumeroPaginas();
		
		request.setAttribute("numeroPaginas", numeroPaginas);
		request.setAttribute("pagina", objetoPagina);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
