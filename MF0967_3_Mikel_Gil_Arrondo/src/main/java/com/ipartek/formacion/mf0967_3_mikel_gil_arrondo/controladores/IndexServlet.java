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
 * Servlet implementation class index
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Perro> perros = (ArrayList<Perro>) PerroMySqlDAO.getInstance().getAll();
		request.setAttribute("perros", perros);
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
