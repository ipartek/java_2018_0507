package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.pojos.Comentario;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;
import com.ipartek.formacion.bbddyoutube.accesodatos.ComentarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.VideoMySqlDAO;


@WebServlet("/contenido")
public class ContenidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = (Usuario) request.getSession().getAttribute("user");

		UsuarioMySqlDAO dao = UsuarioMySqlDAO.getInstance();
		VideoMySqlDAO daov = VideoMySqlDAO.getInstance();
		ComentarioMySqlDAO daoc = ComentarioMySqlDAO.getInstance();
		
		Long idUser = dao.getUserId(user);
		
		ArrayList<Video> videos = (ArrayList<Video>) daov.getAll();
		Video firstVideo = daov.getFirstVideo(idUser);
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) dao.getAll();
		ArrayList<Comentario> comentarios = (ArrayList<Comentario>) daoc.getAllFromVideo(firstVideo);
		
		request.setAttribute("comentarios", comentarios);
		request.setAttribute("firstVideo", firstVideo);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/WEB-INF/contenido.jsp").forward(request, response);
	}

}
