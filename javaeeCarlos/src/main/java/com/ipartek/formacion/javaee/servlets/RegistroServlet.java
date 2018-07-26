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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * //response.getWriter().append("Served at: ").append(request.getContextPath())
	 * ; }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean checkedName=false;
		boolean checkedSurname=false;
		boolean checkedDni=false;
		boolean checkedPass=false;
		
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String clave = request.getParameter("clave");
		String repiteClave = request.getParameter("repiteClave");
		String dni = request.getParameter("dni");
		
		RegistroForm registro = new RegistroForm(nombre, apellido, clave, dni);
		
		if (nombre == null || clave == null || apellido == null || repiteClave == null || dni == null) {
			throw new RuntimeException("No se han recibido los datos de nombre y/o password");
		}
		
		if (nombre.equals("")) {
			registro.setMensajeErrorNombre("No se ha introducido el nombre");
		}else {
			registro.setNombre(nombre);
			checkedName=true;
			registro.setMensajeErrorNombre("");
		}
		if (apellido.equals("")) {
			registro.setMensajeErrorApellido("No se ha introducido el apellido");
		}else {
			registro.setApellido(apellido);
			checkedSurname=true;
			registro.setMensajeErrorApellido("");
		}
		if (dni.equals("")) {
			registro.setMensajeErrorDni("No se ha introducido el DNI");
		}else if (dni.length()>9){
			registro.setMensajeErrorDni("Ha introducido más de 9 digitos DNI");
		}else if (dni.length()<9){
			registro.setMensajeErrorDni("Ha introducido menos de 9 digitos DNI");
		}else if (!(dni.length()<9) && !(dni.length()>9)){
			checkDni(dni.substring(0, 8), dni.substring(9, 9));
				if(checkDni(dni.substring(0, 8), dni.substring(9, 9))){
					registro.setDni(dni);
					checkedDni=true;
					registro.setMensajeErrorDni("");
				}
		}
		if (clave.equals("")) {
			registro.setMensajeErrorClave("No se ha introducido la clave");
		}else if (!clave.equals("") && !repiteClave.equals(clave)){
			registro.setMensajeErrorRepiteClave("La clave no es la misma");
		}else if (!clave.equals("") && repiteClave.equals(clave)) {
			registro.setClave(clave);
			checkedPass=true;
			registro.setMensajeErrorClave("");
			registro.setMensajeErrorRepiteClave("");
		}
		if(checkedName && checkedSurname && checkedDni && checkedPass) {
//		if(checkedName && checkedSurname) {
			System.out.println("¿HE LLEGADO?");
			response.sendRedirect("Principal.jsp");
		}else {
			System.out.println("¿Y AQUI?");
			request.setAttribute("registro", registro);
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
	}

	public boolean checkDni(String dni, String letter) {
		int check;
		String[] letters = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				"H", "L", "C", "K", "E" };

		check = Integer.parseInt(dni)%23;
		System.out.println("¿HOLA?");
			if (letters[check].equals(letter)) {
				return true;
			} else {
				return false;
			}
	}
}
