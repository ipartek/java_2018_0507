package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;

/**
 * Servlet implementation class AdministrarServlet
 */
@WebServlet("/administrar")
public class AdministrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch (accion) {
		case "users":
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) UsuarioMySqlDAO.getInstance().getAll();
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("/WEB-INF/admin/administrarUsers.jsp").forward(request, response);
			break;
			
		case "videos":
			ArrayList<Video> videos = (ArrayList<Video>) VideoMySqlDAO.getInstance().getAllAndUsers();
			request.setAttribute("videos", videos);
			request.getRequestDispatcher("/WEB-INF/admin/administrarVideos.jsp").forward(request, response);
			break;

		default:
			request.getRequestDispatcher("contenido").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
