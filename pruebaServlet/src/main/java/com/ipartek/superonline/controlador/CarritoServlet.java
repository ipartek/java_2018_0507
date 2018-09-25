package com.ipartek.superonline.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.superonline.logica.LogicaNegocio;
import com.ipartek.superonline.pojo.Producto;


/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarritoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String accion = request.getParameter("accion");

		HttpSession session = request.getSession();
		//si es la primera vez que entramos no hay carrito la session coje el carrito de esa sesion , si hemos entrado una vez ya hay carrito
		List<Producto> productos = (List<Producto>) session.getAttribute("carrito");
		
		//comprobamos si el carrito no existe(solo cuando es la primera vez , si no es la primera vez la lista puede contener algo o estar vacia pero existe)
		
		if(productos == null) { //si no existe el carrito
			
		productos = new ArrayList();  //se crea una lista vacia y ahora simpre va a existir y puede estar vacia o contener algo
		session.setAttribute("carrito", productos);  //se la metemos a la sesion
		
		}
		
		//continuamos aki ahora con un carrito vacio de productos pero que existe (en el caso q sea la primera vez)

		
		
		if(id != null && accion != null) {//si se ha dado al boton de añadir carrito de la index.jsp  o borrar de carrito.jsp
			Producto producto = LogicaNegocio.obtenerProductoPorId(Long.parseLong(id));	//se obtiene el producto
			
			switch(accion) {   //y si la accion es añadir se añade el prod al carrito
			case "add":
				productos.add(producto);
				break;
			case "delete":   // se borra del carrito
				productos.remove(producto);
				break;
			}
		}
		
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

