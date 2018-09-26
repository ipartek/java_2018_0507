package com.ipartek.ebook.controlador;

import com.ipartek.ebook.logica.LogicaNegocio;
import com.ipartek.ebook.pojo.Pagina;
import com.ipartek.ebook.pojo.Usuario;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/editorPagina")
public class EditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditorServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String texto = request.getParameter("texto");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		String error = "";
		if (usuario == null) {
			error = "Tiene que iniciar sesion para escribir";
			request.setAttribute("error", error);
			request.getRequestDispatcher("editorPagina.jsp").forward(request, response);
		} else {
			Pagina pagina = new Pagina();
			pagina.setTexto(texto);
			pagina.setAutor(usuario.getNombre());
			LogicaNegocio.agregarPagina(pagina);
			request.getRequestDispatcher("principal").forward(request, response);
		}

	}

}
