package com.ipartek.formacion.javaee.libro.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libro.pojo.Pagina;
import com.ipartek.formacion.javaee.libro.pojo.Usuario;

/**
 * Servlet implementation class EditarLibroServlet
 */

@WebServlet("/editarLibro")
public class EditarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 1.Recogida de datos de formularios
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");

		// 2.Cargamos el modelo (en nuestro caso el pojo)
		Pagina pagina = new Pagina(0, autor, texto);
		
		request.setAttribute("pagina", pagina);
		request.getRequestDispatcher("/index.jsp").forward(request, response);


	}
}