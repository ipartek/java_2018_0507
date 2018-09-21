package supermercado.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		//System.out.println("USerLOGOUT");
		 
		//Borrar usuario logueado
		session.invalidate();
		
		response.sendRedirect("contenidos/login.jsp");
	}

}
