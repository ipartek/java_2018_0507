package com.ipartek.formacion.javaee.libroelectronico.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libroelectronico.accesodatos.LibroMapDAO;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Libro;

/**
 * Servlet implementation class BuscarServlet
 */
@WebServlet("/buscar")
public class BuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palabraABuscar = request.getParameter("buscador");
		
		List<Libro> paginas = LibroMapDAO.getInstance().getAll();
		
		for(Libro pagina : paginas){
			if (palabraABuscar.equals(pagina.getTexto())) {
				//TODO: POR PROBAR
				// Palabra encontrada
				int id = (int) pagina.getId();
				// Cargar la pagina con la id sacada.
				 Libro libro = paginas.get(id);
				request.setAttribute("libro", libro);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			}else {
			 	// Palabra no encontrada
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		}
	}
}
