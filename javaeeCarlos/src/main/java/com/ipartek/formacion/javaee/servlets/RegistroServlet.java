package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String clave = request.getParameter("clave");
		String repiteClave = request.getParameter("repiteClave");
		String dni = request.getParameter("dni");
		
		RegistroForm registro = new RegistroForm(nombre, apellido, clave, repiteClave, dni);
		
		if (nombre == null || clave == null || apellido == null || repiteClave == null || dni == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		
		if (nombre.equals("")) {
			registro.setMensajeErrorNombre("No se ha introducido el nombre");
		}else {
			registro.setNombre(nombre);
			//request.getSession().setAttribute("usuario", login);
		}
		if (apellido.equals("")) {
			registro.setMensajeErrorApellido("No se ha introducido el apellido");
		}else {
			registro.setApellido(apellido);
			
		}
		if (dni.equals("")) {
			registro.setMensajeErrorDni("No se ha introducido el DNI");
		}else {
			registro.setDni(dni);
		}
		if (clave.equals("")) {
			registro.setMensajeErrorClave("No se ha introducido la clave");
		}else if (!clave.equals("") && !repiteClave.equals(clave)){
			registro.setMensajeErrorRepiteClave("La clave no es la misma");
		}else if (!clave.equals("") && repiteClave.equals(clave)) {
			registro.setClave(clave);
		}
	}

}
