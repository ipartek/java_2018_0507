
//CONTROLADOR

package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		PrintWriter pw=response.getWriter();
//		pw.println("si querias hacer un login debes ir por post");
//		
//		pw.println("hola a todos\n"+new java.util.Date());
//		
//		String ruta=request.getContextPath();
//		pw.println(ruta);
//		String nombre=request.getParameter("nombre");
//		
//		if(nombre==null) {
//			nombre="DESCONOCIDO";
//		}
//		
//		pw.append("Hola ").append(nombre);
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();

		String nombre=request.getParameter("nombre");
		String password=request.getParameter("password");

		if(nombre==null||password==null) {
throw new RuntimeException("no se han recibido los datos del nombre o pass");
}
		
	LoginForm login=new LoginForm(nombre, password);
		
		
		if(validar(login)) {
			
			response.sendRedirect("principal.html");
		}
		else {
			//response.sendRedirect("error.html");
			//request.setAttribute("errores", "");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
		
		pw.append("Hola ").append(nombre);
		doGet(request, response);
	}

	private boolean validar(LoginForm login) {
		return "borjañ".equals(login.getNombre()) && "contra".equals(login.getPassword());
	}

}
