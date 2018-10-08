package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		if(nombre==null || password==null) {
			throw new RuntimeException("Ninguno de los dos campos pueden quedar en blanco");
		}
		
		Usuario usuario = new Usuario(nombre, password);
		
		if(nombre.equalsIgnoreCase("scobby") && password.equals("galletas")){
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("/admin/index").forward(request, response);;
		}else {
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
