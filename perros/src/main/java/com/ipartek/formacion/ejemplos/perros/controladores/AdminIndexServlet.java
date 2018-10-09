package com.ipartek.formacion.ejemplos.perros.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplos.perros.accesodatos.PerrosMySQLDAO;
import com.ipartek.formacion.ejemplos.perros.modelos.Chip;
import com.ipartek.formacion.ejemplos.perros.modelos.Perro;

@WebServlet("/admin/index")
public class AdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String peso = request.getParameter("peso");
		String raza = request.getParameter("raza");
		String apadrinado = request.getParameter("apadrinado");
		String identificacion = request.getParameter("identificacion");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		
		Chip chip = new Chip(identificacion, latitud, longitud);
		Perro perro = new Perro(nombre, edad, raza, peso, chip, apadrinado);
		
		if(!perro.isCorrecto()) {
			request.setAttribute("perro", perro);
			request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
			return;
		}
		
		PerrosMySQLDAO.getInstance().insert(perro);
		
		response.sendRedirect("../");
	}

}
