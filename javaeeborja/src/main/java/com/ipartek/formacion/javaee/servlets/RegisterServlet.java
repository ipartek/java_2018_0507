//package com.ipartek.formacion.javaee.servlets;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ipartek.formacion.javaee.modelos.LoginForm;
//import com.ipartek.formacion.javaee.modelos.RegisterForm;
//
///**
// * Servlet implementation class RegisterServlet
// */
//public class RegisterServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		
//		String nombre = request.getParameter("nombre");
//		String password = request.getParameter("password");
//		String email= request.getParameter("email");
//		System.out.println(nombre);
//		
//		if(nombre == null || password == null || email==null) {
//			//response.sendRedirect("error.html");
//			((ServletRequest) response).getRequestDispatcher("error.html");
//		}
//		
//		//RegisterForm login = new RegisterForm(nombre, password,email,);
//			
//		if(validar(login)) {
//			request.getSession().setAttribute("usuario", login);
//			response.sendRedirect("index.jsp");
//			
//			
//			
//		} else {
//			//response.sendRedirect("error.html");
//		//	login.setMensajeError("El usuario o contraseña no son correctos");
////			request.setAttribute("login", login);
////			request.getRequestDispatcher("index.jsp").forward(request, response);
//			response.sendRedirect("error.html");
//
//		}
//			
//		
//		//		PrintWriter pw = response.getWriter();
////		
////		pw.append("Hola ").append(nombre);
//		
//		//pw.println("Hola " + nombre);
//		//pw.println(new StringBuilder("Hola ").append(nombre).toString());
//			
//		
//		
//		
//		
//	}
//	
//private boolean validar(RegisterForm login) {
//		
//		
//		return "borjañ".equals(login.getNombre()) && "contra".equals(login.getPassword()) && "email@email.com".equals(login.getEmail());
//
//}
//}
