package com.ipartek.formacion.javaee.libroelectronico.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libroelectronico.accesodatos.LibroMapDAO;
import com.ipartek.formacion.javaee.libroelectronico.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Pagina;

/**
 * Servlet implementation class EditarLibroServlet
 */
@WebServlet("/editarLibro")
public class EditarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/escribirPagina.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		
		// Sumar 1 al numero de páginas
		int id = LogicaNegocio.obtenerPaginas() + 1;
		
		List<Pagina> paginas = LibroMapDAO.getInstance().getAll();
		
		Pagina pagina = new Pagina(id, texto, autor);
	
		// Validar el texto que se va a introducir
		boolean textoValido = LogicaNegocio.validarPagina(pagina);
		
		if(pagina.isCorrecto() && textoValido) {
			response.sendRedirect("index?page=" + id);
			paginas.add(pagina);
		} else {
			request.setAttribute("texto", texto);
			request.setAttribute("error", "Se deben rellenar 25 palabras mínimo");
			request.getRequestDispatcher("/WEB-INF/escribirPagina.jsp").forward(request, response);
		}
	}
}
