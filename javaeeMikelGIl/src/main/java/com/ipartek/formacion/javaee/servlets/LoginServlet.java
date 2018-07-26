package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;
import com.ipartek.formacion.javaee.modelos.LoginFormException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final String USUARIO_POR_DEFECTO = "antxon";
	private static final String PASSWORD_POR_DEFECTO = "asdf";
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Recogida de datos
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");	
		
		// Empaquetado en modelo
		LoginForm login = new LoginForm();
		
		try {
			login.setNombre(nombre);			//SetNombre comprueba que no esta vacio
		}catch (LoginFormException e) {
		}
		
		
		try {
			login.setPassword(password);	//SetPassword comprueba que no esta vacio
		}catch (LoginFormException e){		//Excepcion para sustituir el error por un *
			login.setErrorPassword("*");
		}
		
		// Llamada a logica de negocio
		if (!login.isErroneo() && validar(login)) {
			// Redireccion a vista
			request.getSession().setAttribute("usuario", login);
			response.sendRedirect("principal.jsp");
		}else {
			// Redireccion a vista
			login.setMensajeError("El usuario o contraseña no son correctos");
			request.setAttribute("login", login);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private boolean validar(LoginForm login) {
		return USUARIO_POR_DEFECTO.equals(login.getNombre()) && PASSWORD_POR_DEFECTO.equals(login.getPassword());
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("hola a todos\n" + new java.util.Date());

		String ruta = request.getContextPath();
		pw.println(ruta);

		
		pw.println("\nSi quieres introducir usuario y contraseña hagalo por POST");
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	

}
