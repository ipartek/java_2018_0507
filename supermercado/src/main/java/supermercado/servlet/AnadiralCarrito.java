package supermercado.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supermercado.accesodatos.Carrito;
import supermercado.pojo.Articulo;

/**
 * Servlet implementation class AnadiralCarrito
 */
public class AnadiralCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Carrito carrito;
	List<Articulo> articulos;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadiralCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CARRITO");
		
		
		String accion = request.getParameter("accion");
		
		String idprod=request.getParameter("id");
		
		
		System.out.println("idprod "+idprod);
		String nombre=request.getParameter("nombre");
		String precio=request.getParameter("precio");
		
		System.out.println("nombre "+nombre);
		System.out.println("precio "+precio);
		
		HttpSession session = request.getSession();
		
		
		
		carrito.setNombre(nombre);
		carrito.setPrecio(precio);
	
		
		response.sendRedirect("bebidas.jsp");
	}

}
