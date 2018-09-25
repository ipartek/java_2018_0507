package supermercado.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import supermercado.pojo.Articulo;

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
		

		HttpSession misession= request.getSession(true);
		System.out.println("Sessionantesde: "+ misession.toString());
		
		misession.setAttribute("user",user);
		misession.setAttribute("pass", pass);
		
		Cookie cok = new Cookie("usuario",user);
		response.addCookie(cok);
		
		
	
		System.out.println("Sessiondespuesde: "+ misession.toString());
		
		response.sendRedirect("bebidas.jsp");
		System.out.println(misession.getAttribute(user));
	}
}
