package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Libro;

public class mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public mostrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("numero");
		int numero=Integer.parseInt(num);
		if(numero<Libro.getLibro().size()&& numero>=0){
		request.setAttribute("Pagina", Libro.getLibro().get(numero)); 
		request.getRequestDispatcher("mostrar.jsp").forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
