package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;
import com.ipartek.formacion.bbddyoutube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.bbddyoutube.logica.LogicaNegocio;

/**
 * Servlet implementation class NuevoContenidoServlet
 */
@WebServlet("/anadirContenido")
public class NuevoContenidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioMySqlDAO userDao = UsuarioMySqlDAO.getInstance();
	VideoMySqlDAO videoDao = VideoMySqlDAO.getInstance(); 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("user");
		
		String idVideo = request.getParameter("idVideo");
		String nombreVideo = request.getParameter("nombreVideo");
		
		if (idVideo == null || nombreVideo == null) {
			request.getRequestDispatcher("/WEB-INF/contenido.jsp").forward(request, response);
		}
		
		Video video = new Video(idVideo, nombreVideo);
		
		boolean videoValido = LogicaNegocio.validarVideo(video);
		
		// Si el video NO esta en la bbdd
		if (!videoValido){
			// Se inserta
			videoDao.insert(video);
			
			// Obtiene el id del video de la bbdd y lo pone en el objeto video
			video.setId(videoDao.getVideoId(idVideo));
			
			// Se inserta el id del video y del usuario en la tabla para relacionarlos
			videoDao.insertIntoUser(video,userDao.getUserId(usuario));
		}else {
			// Se comprueba que esta en la tabla usuariosvideos
			 video.setId(videoDao.getVideoId(idVideo));
			 if(!videoDao.searchInUser(video.getId(),userDao.getUserId(usuario))) {
				 // NO esta en la tabla usuariosvideos: Se inserta
				
				 videoDao.insertIntoUser(video,userDao.getUserId(usuario));
			 }
		}
		request.getRequestDispatcher("contenido").forward(request, response);
	}
}
