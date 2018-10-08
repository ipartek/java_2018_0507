package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.accesodatos.PerroMySqlDAO;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Perro;

/**
 * Servlet implementation class BuscadorServlet
 */
@WebServlet("/buscador")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String nombre = request.getParameter("buscarNombre");
		String chip = request.getParameter("buscarChip");
		
		PerroMySqlDAO dao = PerroMySqlDAO.getInstance();
		
		ArrayList<Perro> perros = null;
		
		switch (type) {
		case "nombre":
			perros = (ArrayList<Perro>) dao.seachBy(type,nombre);
			
			request.setAttribute("perros", perros);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			break;
			
		case "chip":
			perros = (ArrayList<Perro>) dao.seachBy(type,chip);
			
			request.setAttribute("perros", perros);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			break;

		default:
			request.getRequestDispatcher("index").forward(request, response);
			break;
		}
	}

}
