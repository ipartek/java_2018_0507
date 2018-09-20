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
		
		/*
		 String idprod1=request.getParameter("b1");
		String idprod2=request.getParameter("b2");
		String idprod3=request.getParameter("b3");
		String idprod4=request.getParameter("b4");
		String idprod5=request.getParameter("b5");
		String idprod6=request.getParameter("b6");
		String idprod7=request.getParameter("b7");
		String idprod8=request.getParameter("b8");
		String idprod9=request.getParameter("b9");
		String idprod10=request.getParameter("b10");
		System.out.println(idprod1);
		System.out.println(idprod2);
		System.out.println(idprod3);
		System.out.println(idprod4);
		System.out.println(idprod5);
		System.out.println(idprod6);
		carrito.setId(idprod1);
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
		response.sendRedirect("contenidos/bebidas.jsp");
	}

}
