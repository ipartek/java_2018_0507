package com.ipartek.superonline.controlador.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.superonline.logica.LogicaNegocio;
import com.ipartek.superonline.pojo.Producto;



/**
 * Servlet implementation class AdminEdicionServlet
 */
@WebServlet("/admin/edicion")


public class AdminEdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String ADD = "Añadir", UPDATE = "Modificar", DELETE = "Borrar";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEdicionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String accion = request.getParameter("accion");

		String textoAccion = null;

		switch (accion) {
		case "add":
			textoAccion = ADD;
			break;
		case "update":
			textoAccion = UPDATE;
			cargarProducto(request, id);
			break;
		case "delete":
			textoAccion = DELETE;
			cargarProducto(request, id);
		}

		request.setAttribute("accion", textoAccion);
		request.getRequestDispatcher("edicion.jsp").forward(request, response);
		
	}

	private void cargarProducto(HttpServletRequest request, String id) {
		Producto producto;
		producto = LogicaNegocio.obtenerProductoPorId(Long.parseLong(id));
		request.setAttribute("prod", producto);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
