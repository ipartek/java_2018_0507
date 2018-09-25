package supermercado.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.accesodatos.ArticuloArrayDAO;
import supermercado.accesodatos.CrudAble;
import supermercado.pojo.Articulo;

/**
 * Servlet implementation class InicioServlet
 */
public class RegistroProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		   Cookie[] cookies = request.getCookies();
	        for (int i = 0; i < cookies.length; i++) {
	            Cookie c = cookies[i];
	            String name = c.getName();
	            String value = c.getValue();
	            System.out.println("Cookie "+name + " = " + value);
	        }
		
		
		String nombre=request.getParameter("nombre");//nombre
		String precio=request.getParameter("precio");
		String categoria=request.getParameter("categoria");
		String descuento=request.getParameter("descuento");
		
		//System.out.println(request.getParameter("nombre")+" "+request.getParameter("precio")
		//			+" "+request.getParameter("categoria")+" "+request.getParameter("descuento"));
		
		
		
		Articulo art=new Articulo(nombre,  categoria,  precio,  descuento);

		CrudAble<Articulo> dao = ArticuloArrayDAO.getInstance();
		dao.insert(art);
		
		
		
		/**/
		//System.out.println(art.getCategoria() + " " +art.getDescuento() + " "+art.getId() + " "+art.getNombre() + " " + art.getPrecio());
		/**/
		
		dao.getAll();
		
		 // print out cookies

     
		
		response.sendRedirect("registroprod.jsp");
		
		//Ya he creado el nuevo articulo y ahora tengo que mostrarlo desde la otra web
	}

}
