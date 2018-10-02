package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;
import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;


@WebServlet("/contenido")
public class ContenidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		//Usuario user = (Usuario) request.getAttribute("user");
		UsuarioMySqlDAO dao = UsuarioMySqlDAO.getInstance();
		
		Long idUser = dao.getUserId(user);
		
		ArrayList<Video> videos = (ArrayList<Video>) dao.getAllUserVideos(idUser);
		
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/WEB-INF/contenido.jsp").forward(request, response);
	}

}
