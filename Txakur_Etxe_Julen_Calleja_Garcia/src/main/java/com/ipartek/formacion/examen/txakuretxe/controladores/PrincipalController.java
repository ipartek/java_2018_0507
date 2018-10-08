package com.ipartek.formacion.examen.txakuretxe.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.txakuretxe.accesodatos.PerroTreeMapDAO;
import com.ipartek.formacion.examen.txakuretxe.modelo.Chip;


@WebServlet("/principal")
public class PrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Chip> perros = PerroTreeMapDAO.getInstance().getAll();
		
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("/WEB-INF/principal.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
