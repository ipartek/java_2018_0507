package com.ipartek.formacion.ong.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ong.logica.LogicaNegocio;
import com.ipartek.formacion.ong.pojo.Chip;

@WebServlet("/agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("agregar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		long id = Long.parseLong(request.getParameter("id"));
		long chip = Long.parseLong(request.getParameter("chip"));
		int edad = Integer.parseInt(request.getParameter("edad"));
		int peso = Integer.parseInt(request.getParameter("peso"));
		String apadrinado = request.getParameter("apadrinado");
		double latitud = Double.parseDouble(request.getParameter("latitud"));
		double longitud = Double.parseDouble(request.getParameter("longitud"));
		if (raza.equals(null) || raza.equals("")) {
			raza = "milrazas";
		}
		try {
			Chip perro = new Chip(id,nombre,edad,raza,peso,apadrinado,chip,latitud,longitud);
			LogicaNegocio.AgregarPerro(perro);
		} catch(Exception e) {
			request.setAttribute("error", e.getMessage());
			return;
		}
		request.setAttribute("mensaje", "Operacion correcta");
		request.getRequestDispatcher("index").forward(request, response);
		
	}

}
