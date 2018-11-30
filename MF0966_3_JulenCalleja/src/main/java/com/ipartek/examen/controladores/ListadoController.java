package com.ipartek.examen.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.examen.DAO.GenteDAO;
import com.ipartek.examen.modelo.Gente;



@WebServlet("/listado")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<Gente> gente = (ArrayList<Gente>) GenteDAO.getInstance().getAll();
			request.setAttribute("gente", gente);
		} catch (ClassNotFoundException e) {
			throw new ControladroException("Fallo en el controlador");
		}
		request.getRequestDispatcher("/WEB-INF/jsps/listado.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
