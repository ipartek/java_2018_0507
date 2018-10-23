package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.List;

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
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		String id = request.getParameter("id");
		
		UsuarioMySqlDAO dao = UsuarioMySqlDAO.getInstance();
		VideoMySqlDAO daov = VideoMySqlDAO.getInstance();
		ComentarioMySqlDAO daoc = ComentarioMySqlDAO.getInstance();
		
		Long idUser = dao.getUserId(user);
		Video video = null;
		
		List<Video> videos = daov.getAll();
		List<Usuario> usuarios = dao.getAll();
		List<Comentario> comentarios = null;

		if(id != null) {
			Long idL = Long.parseLong(id);
			video = daov.getById(idL);
			comentarios = daoc.getAllFromVideo(video);
		} else {
			video= daov.getFirstVideo(idUser);
			comentarios = daoc.getAllFromVideo(video);
		}
		
		request.setAttribute("videos", videos);
		request.setAttribute("comentarios", comentarios);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("video", video);

		request.getRequestDispatcher("/WEB-INF/contenido.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
