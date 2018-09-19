package supermercado.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String user=request.getParameter("usuario");
		String pass=request.getParameter("contrasena");
		System.out.println("Recibidos:  User "+user+" Pass "+pass);
		
		
		
		
		if(user.length()>0) {
		
			//System.out.println("User OK:");
			if(pass.length()>0) {
				//////////////
				Cookie c = new Cookie("usuario", user);
				c.setMaxAge(60 * 60 * 24 * 365 * 100);
				response.addCookie(c);
				///////////////////

				
				
				request.getSession().setAttribute("usuario", user);
				response.sendRedirect("index.jsp");
				
			}else {
				response.sendRedirect("contenidos/login.jsp");
			}
			
		}else {
			response.sendRedirect("contenidos/login.jsp");
		}
		
		
		
		
	}

}
