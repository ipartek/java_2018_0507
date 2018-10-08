package com.ipartek.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.logica.LogicaNegocio;
import com.ipartek.pojo.Perro;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class ListadoProd
 */
@WebServlet("/listadoprod")
public class ListadoProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private LogicaNegocio logica;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String botones = request.getParameter("accion");

		if (botones != null) {

			switch (botones) {
			case "add":
				request.getRequestDispatcher("admin/anadirProducto.jsp").forward(request, response);
				break;

			case "delete":
				
				Long idBorrar = Long.parseLong(request.getParameter("id"));
				logica = new LogicaNegocio();
				boolean res = logica.deleteProd(idBorrar);
				LogicaNegocio logica = new LogicaNegocio();
				request.setAttribute("listadoProductos", logica.obtenerTodosProductos());
				request.getRequestDispatcher("admin/listadoProd.jsp").forward(request, response);
				
				break;

			case "edit":
				
				//id es el nombre del paramentro de la jsp no del valor del parametro
				
				Long id = Long.parseLong(request.getParameter("id"));
			
				logica = new LogicaNegocio();
				Perro prod = logica.obtenerProductoId(id);
				request.setAttribute("productoId", prod);
				
				request.getRequestDispatcher("admin/editarProducto.jsp").forward(request, response);
				
				

				break;

			}
		} else {
			
			LogicaNegocio logica = new LogicaNegocio();
			request.setAttribute("listadoProductos", logica.obtenerTodosProductos());
			request.getRequestDispatcher("admin/listadoProd.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
