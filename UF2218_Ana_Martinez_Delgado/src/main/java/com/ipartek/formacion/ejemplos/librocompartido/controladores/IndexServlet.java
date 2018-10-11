package com.ipartek.formacion.ejemplos.librocompartido.controladores;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplos.librocompartido.logica.LogicaNegocio;
import com.ipartek.formacion.ejemplos.librocompartido.pojos.Pagina;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("numPagina");
		
		
		System.out.println("Desde ir a la pagina llega pagina" + pagina);
		if (pagina!=null) {
			int numeroPagina = Integer.parseInt(pagina);
			
			String objetoPagina = LogicaNegocio.obtenerPaginaBD(numeroPagina);
			
			if(objetoPagina==null) {
				System.out.println("Pagina no encontrada");
			}else {
			//System.out.println("objetoPAgina"+objetoPagina);
			//int numeroPaginas = LogicaNegocio.obtenerNumeroPaginas();
			
			request.setAttribute("numero", numeroPagina);
			request.setAttribute("pagina", objetoPagina);
			
			request.getRequestDispatcher("WEB-INF/verPagina.jsp").forward(request, response);
			}
		}else {			
			
			int numeroPaginas = LogicaNegocio.obtenerNumeroPaginas();
			
			request.setAttribute("numeroPaginas", numeroPaginas);
			
			
			request.getRequestDispatcher("edicion.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
