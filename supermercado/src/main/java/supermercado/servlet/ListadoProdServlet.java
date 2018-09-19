package supermercado.servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.accesodatos.ArticuloArrayDAO;
import supermercado.pojo.Articulo;
import supermercado.accesodatos.CrudAble;

/**
 * Servlet implementation class ListadoProdServlet
 */
public class ListadoProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.sendRedirect("contenidos/listadoprods.jsp");
		
			CrudAble<Articulo> dao = ArticuloArrayDAO.getInstance();
			
			/*for(Articulo art: dao.getAll()) {
				System.out.println("Articulo: "+art.getCategoria()+" "+art.getDescuento()+" "+art.getId()+" "+art.getNombre()+" "+art.getPrecio());
			}*/
		 
	}

}
