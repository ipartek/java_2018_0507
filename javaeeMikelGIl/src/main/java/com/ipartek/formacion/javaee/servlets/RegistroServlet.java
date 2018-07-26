package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("password2");
		
		/*if (nombre.isEmpty() || apellido.isEmpty() || password.isEmpty() || passwordRepeat.isEmpty()) {
			throw new RuntimeException("No se han recibido los datos correctos");
		}*/
		
		LoginForm registro = new LoginForm();
		
		if (validar(registro, nombre, apellido, password, passwordRepeat)) {
			response.sendRedirect("registro.jsp");
		}else {
			registro.setNombre(nombre);
			registro.setApellido(apellido);
			registro.setPassword(password);
			System.out.println("Nombre: " + registro.getNombre() + " apellido: " + registro.getApellido() + " password " + registro.getPassword() + " Repeatpassword: " + passwordRepeat);
			
			request.setAttribute("registro", registro);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}
	}
	
	private boolean validar(LoginForm registro, String nombre, String apellido, String password, String passwordRepeat) {
		boolean resultado = true;
		
		if (nombre.isEmpty()) {
			registro.setErrorNombre("Es obligatorio rellenar el nombre");
			resultado = false;
		}
		if (apellido.isEmpty()) {
			registro.setErrorApellido("Es obligatorio rellenar el apellido");
			resultado = false;
		}
		if (password.isEmpty()) {
			registro.setErrorPassword("Es obligatorio rellenar el password");
			resultado = false;
		}
		if (password != passwordRepeat) {
			registro.setErrorPassword("Las contraseñas deben ser identicas");
			resultado = false;
		}
		
		System.out.println("Nombre: " + nombre + " apellido: " + apellido + " password " + password + " Repeatpassword: "+passwordRepeat);
		
		return resultado;
	}

}
