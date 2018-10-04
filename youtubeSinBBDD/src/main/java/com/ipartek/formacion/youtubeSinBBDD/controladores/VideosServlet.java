package com.ipartek.formacion.youtubeSinBBDD.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtubeSinBBDD.accesodatos.CrudAble;
import com.ipartek.formacion.youtubeSinBBDD.accesodatos.VideoTreeMapDAO;
import com.ipartek.formacion.youtubeSinBBDD.modelos.Video;

@WebServlet("/videos")
public class VideosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//MOSTRAR PANTALLA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		if (accion == null) {
			throw new ControladorException("No se admite una petición que no tenga accion");
		}

		CrudAble<Video> dao = VideoTreeMapDAO.getInstance();
		//VideoTreeMapDAO dao = VideoTreeMapDAO.getInstance();
		
		long longId;
		
		Video video;
		
		switch (accion) {
		case "insert":
			break;
		case "update":
		case "delete":
			longId = extraerId(id);
			
			video = dao.getById(longId);
			request.setAttribute("video", video);
			break;
		default:
			throw new ControladorException("No se admite una petición que no sea insert, update o delete");
		}

		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/video.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PROCESAR OPCION SELECCIONADA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		if (accion == null) {
			throw new ControladorException("No se admite una petición que no tenga accion");
		}

		CrudAble<Video> dao = VideoTreeMapDAO.getInstance();
		//VideoTreeMapDAO dao = VideoTreeMapDAO.getInstance();
		
		long longId;
		String idVideo = request.getParameter("idVideo");
		String nombre = request.getParameter("nombre");
		
		Video video;
		
		String mensaje = "";
		
		switch (accion) {
		case "insert":
			video = new Video(idVideo, nombre);
			dao.insert(video);
			mensaje = "Inserción correcta del video " + video.getIdVideo();
			break;
		case "update":
			longId = extraerId(id);
			video = new Video(longId, idVideo, nombre);
			dao.update(video);
			mensaje = "Actualización correcta del video " + video.getIdVideo();
			break;
		case "delete":
			longId = extraerId(id);
			dao.delete(longId);
			mensaje = "Borrado correcto del video id " + longId;
			
			video = dao.getById(longId);
			request.setAttribute("video", video);
			break;
		default:
			throw new ControladorException("No se admite una petición que no sea insert, update o delete");
		}

		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/admin/index").forward(request, response);
	}

	private long extraerId(String id) {
		long longId;
		
		if(id == null) {
			throw new ControladorException("Necesito un id");
		}
		
		try {
			longId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new ControladorException("El id no era numérico", e);
		}
		return longId;

	}

}
