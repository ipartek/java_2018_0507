package supermercado.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supermercado.pojo.Articulo;

/**
 * Servlet implementation class de session
 */
public class VerCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VerCarrito() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misession= (HttpSession) request.getSession();
		 
		Articulo miproducto= (Articulo) misession.getAttribute("producto");
		
		 
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>"+ miproducto.getId()+"</body> </html>");
		pw.close();
		response.sendRedirect("../vercarrito.jsp");
		
		
	}

}
