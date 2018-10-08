package com.ipartek.pabloDAO.paginaExamen.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.pabloDAO.paginaExamen.accesodatos.PerroMapDAO;
import com.ipartek.pabloDAO.paginaExamen.modelos.Perro;

@WebServlet("/admin/index")
public class IndexAdminServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Crea una nueva lista de clase Usuario usuarios y llama a UsuarioMapDAO
		//y al getInstance llama a la Instancia en usuarioMapDAO
		List<Perro> perros = PerroMapDAO.getInstance().getAll();
		// el "usuarios" es el que se utiliza para mostrar lo datos en pantallan en index.jsp
		// y el usuarios es la variable que contiene la lista de la instancia de usuario
		request.setAttribute("perros", perros);
		
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
