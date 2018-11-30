package com.ipartek.examen.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.examen.DAO.GenteDAO;
import com.ipartek.examen.modelo.Gente;


@WebServlet("/modificar")
public class ModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsps/insertar.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String portal = request.getParameter("portal");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		String puesto = request.getParameter("puesto");
		
		
		Gente persona = new Gente(nombre,apellido,direccion,Integer.parseInt(portal),email,dni,puesto);
		
		try {
			GenteDAO.getInstance().insert(persona);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("listado").forward(request, response);
	}

}
