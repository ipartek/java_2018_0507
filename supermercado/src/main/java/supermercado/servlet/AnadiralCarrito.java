package supermercado.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supermercado.accesodatos.Carrito;
import supermercado.accesodatos.CarritoDAO;
import supermercado.pojo.Articulo;

/**
 * Servlet implementation class AnadiralCarrito
 */
public class AnadiralCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Carrito carrito;
	
       
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
		String id = request.getParameter("id");
		String accion = request.getParameter("accion");
		
		String idprod=request.getParameter("id");
		
		carrito.setId(idprod);
		
		
		System.out.println("idprod"+idprod);
		CarritoDAO cardao=new CarritoDAO();
		cardao.insert(carrito);
		//carrito.add(e)*/
		
		
		if(request.getParameter("b1") != null) {

			HttpSession misession= request.getSession(true);
			Articulo miproducto= new Articulo(request.getParameter("b1"));
			misession.setAttribute("producto",miproducto);
			
		}
		if(request.getParameter("b2") != null) {

			HttpSession misession= request.getSession(true);
			Articulo miproducto= new Articulo(request.getParameter("b2"));
		
			misession.setAttribute("producto",miproducto);
			
		}
		response.sendRedirect("bebidas.jsp");
	}

}
