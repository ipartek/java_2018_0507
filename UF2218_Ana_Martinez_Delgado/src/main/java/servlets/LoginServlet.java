package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 4286940923785367241L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Recogida de datos de formularios, URLs, cookies, session...
		request.setCharacterEncoding("UTF-8");
		
		String user = request.getParameter("user");
		System.out.println("user "+user);
		String pass = request.getParameter("pass");
		
		/*
		debemos poder Iniciar sesión con los siguientes usuarios

		[William , Shakespeare]
		[cervantes, saavedra]
		[pablo, neruda]
		[paulo, cohelo]*/
				
		//if(user!=null && pass!=null) {
		if(user.equals("William") && pass.equals("Shakespeare") 
				|| (user.equals("cervantes") && pass.equals("saavedra")
				|| (user.equals("pablo") && pass.equals("neruda")
				|| (user.equals("paulo") && pass.equals("cohelo"))))) {
			
			request.getSession().setAttribute("user", user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			System.out.println("Usuario nulo");
		}
		
	
	}
}
