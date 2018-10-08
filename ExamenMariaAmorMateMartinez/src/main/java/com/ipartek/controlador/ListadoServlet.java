package com.ipartek.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.logica.LogicaNegocio;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class ListadoServlet
 */
@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LogicaNegocio logica;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String botones = request.getParameter("accion");

		if (botones != null) {

			switch (botones) {
			case "add":
				request.getRequestDispatcher("admin/anadirUsuario.jsp").forward(request, response);
				break;

			case "delete":
				
				Long idBorrar = Long.parseLong(request.getParameter("id"));
				logica = new LogicaNegocio();
				boolean res = logica.delete(idBorrar);
				LogicaNegocio logica = new LogicaNegocio();
				request.setAttribute("listadoUsuarios", logica.obtenerTodosUsuarios());
				request.getRequestDispatcher("admin/listado.jsp").forward(request, response);
				
				break;

			case "edit":
				
				//id es el nombre del paramentro de la jsp no del valor del parametro
				
				Long id = Long.parseLong(request.getParameter("id"));
			
				logica = new LogicaNegocio();
				Usuario user = logica.obtenerUsuarioId(id);
				request.setAttribute("usuarioId", user);
				
				request.getRequestDispatcher("admin/editarUsuario.jsp").forward(request, response);
				
				

				break;

			}
		} else {
			
			LogicaNegocio logica = new LogicaNegocio();
			request.setAttribute("listadoUsuarios", logica.obtenerTodosUsuarios());
			request.getRequestDispatcher("admin/listado.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
