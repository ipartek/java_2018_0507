package com.ipartek.formacion.crudNuevo.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.crudNuevo.accesoadatos.UsuarioTreeMapDAO;
import com.ipartek.formacion.crudNuevo.modelos.Usuario;

@WebServlet("/admin/index")
public class AdminIndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = UsuarioTreeMapDAO.getInstance().getAll();
		
		request.setAttribute("usuarios", usuarios);
		
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
