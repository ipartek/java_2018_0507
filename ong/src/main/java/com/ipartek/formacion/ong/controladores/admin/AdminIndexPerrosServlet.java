package com.ipartek.formacion.ong.controladores.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ong.accesoadatos.PerroTreeMapDAO;
import com.ipartek.formacion.ong.modelos.Perro;

@WebServlet("/admin/indexPerros")
public class AdminIndexPerrosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Conjunto de perros
		List<Perro> perros = PerroTreeMapDAO.getInstance().getAll();

		request.setAttribute("perros", perros);

		request.getRequestDispatcher("/WEB-INF/admin/indexPerros.jsp").forward(request, response);

	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
