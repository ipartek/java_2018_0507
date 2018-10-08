package com.ipartek.formacion.examen.crud.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.examen.crud.accesodatos.CrudAble;
import com.ipartek.formacion.examen.crud.modelos.Perros;
import com.ipartek.formacion.examen.crud.accesodatos.PerrosTreeMapDAO;

@WebServlet("/perros")
public class PerrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("perros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creación de variables
		String id = request.getParameter("id");
		CrudAble<Perros> dao = PerrosTreeMapDAO.getInstance();
		long longId = Long.parseLong(id);
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String raza = request.getParameter("raza");
		String peso = request.getParameter("peso");
		String apadrinado = request.getParameter("apadrinado");
		String chip = request.getParameter("chip");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		//Conversión de datos
		int edadint = Integer.parseInt(edad);
		int pesoint = Integer.parseInt(peso);
		boolean apadrinadoboolean = Boolean.parseBoolean(apadrinado);
		int latitudint = Integer.parseInt(latitud);
		int longitudint = Integer.parseInt(longitud);
		
		//Inserción objeto perros
		Perros perros;
		String mensaje = "";
		perros = new Perros(longId, nombre, edadint, raza, pesoint, apadrinadoboolean, chip, latitudint, longitudint);
		dao.insert(perros);
		mensaje = "Inserción correcta del perro " + perros.getNombre();
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("select").forward(request, response);
	}

}
