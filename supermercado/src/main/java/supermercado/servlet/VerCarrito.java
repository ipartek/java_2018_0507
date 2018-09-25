package supermercado.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supermercado.pojo.Articulo;


@WebServlet("/carrito")
public class VerCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String accion = request.getParameter("accion");
		
		HttpSession session = request.getSession();
		
		List<Articulo> productos = (List<Articulo>)session.getAttribute("carrito");
		
		if(productos == null) {
			productos = new ArrayList<Articulo>();
			session.setAttribute("carrito", productos);
			System.out.println("carrito"+productos);
		}
		
		
		
		request.getRequestDispatcher("vercarrito.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
