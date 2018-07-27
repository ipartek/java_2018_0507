
package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.RegisterForm;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		pw.println("Si querías hacer un login, tienes que venir por post");

		pw.println("Hola a todos: " + new java.util.Date());

		String ruta = request.getContextPath();

		pw.println(ruta);

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
 System.out.println("adauidfbwiuefobwoifbwS");
		

		String nombrer = request.getParameter("nombre");
		String passwordr = request.getParameter("password");
		String emailr = request.getParameter("email");
		
		String mensaje="xD";
//		System.out.println(nombre);
//		System.out.println(password);
//		
//		System.out.println(nombrer);
//		System.out.println(passwordr);
//		System.out.println(emailr);
//		if(nombre == null || password == null) {
//			//throw new RuntimeException("No se han recibido los datos de nombre y/o password");
//			response.sendRedirect("error.html");
//		}
		
		
			
		

//		
		
		
		
	

			RegisterForm loginr = new RegisterForm(nombrer, passwordr, emailr,mensaje);
			if (validarr(loginr)) {
				//request.getSession().setAttribute("usuario", loginr);
				request.getSession().setAttribute("usuario", loginr);
				//response.sendRedirect("principal.jsp");
				System.out.println(validarr(loginr));
				loginr.setNombre(nombrer);
				loginr.setEmail(emailr);
				loginr.setPassword(passwordr);
				
				System.out.println(loginr.getNombre());
				System.out.println(loginr.getPassword());
				System.out.println(loginr.getEmail());
				System.out.println(loginr.getMensajeError());
				//request.getRequestDispatcher("index.jsp").forward(request, response);

				response.sendRedirect("index.jsp");
				

			} else {
				response.sendRedirect("error.html");

			}

		

	}

	// PrintWriter pw = response.getWriter();
	//
	// pw.append("Hola ").append(nombre);

	// pw.println("Hola " + nombre);
	// pw.println(new StringBuilder("Hola ").append(nombre).toString());



	private boolean validarr(RegisterForm login) {
if(login.getNombre()==""||login.getEmail()==""||login.getPassword()=="") {
	System.out.println(login.getNombre());
		return false;
	
}
else {
return true;}

}

}
