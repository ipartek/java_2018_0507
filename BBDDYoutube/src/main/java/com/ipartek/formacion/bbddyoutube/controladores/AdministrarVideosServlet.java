package com.ipartek.formacion.bbddyoutube.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bbddyoutube.accesodatos.CrudAble;
import com.ipartek.formacion.bbddyoutube.accesodatos.UsuarioMySqlDAO;
import com.ipartek.formacion.bbddyoutube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;

/**
 * Servlet implementation class AdministrarvideosServlet
 */
@WebServlet("/videos")
public class AdministrarVideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite una peticion que no tenga accion");
		}
		
		CrudAble<Video> dao = VideoMySqlDAO.getInstance();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) UsuarioMySqlDAO.getInstance().getAll();
		
		Long idL;
		Video video = null;
		
		switch (accion) {
			case "insertar":
				break;
			case "editar":
			case "borrar":
				idL = extraerId(id);
				video = dao.getById(idL);
				request.setAttribute("video", video);
				request.setAttribute("selectedUsuarioId", video.getIdUsuario());
				break;
			default:
				throw new ControladorException("No se admite una peticion que no sea insertar, editar o borrar");
		}
		
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/admin/operacionesvideo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PROCESAR LA OPCION SELECCIONADA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite una peticion que no tenga accion");
		}
		
		VideoMySqlDAO daoV = VideoMySqlDAO.getInstance();
		
		String idYoutube = request.getParameter("idYoutube");
		String nombre = request.getParameter("nombre");
		String idUsuario = request.getParameter("idUsuario");
		Long idUsuarioL;
		Long idL;

		Video video;
		String mensaje = "";
		
		switch (accion) {
			case "insertar":
				idUsuarioL = extraerId(idUsuario);
				video = new Video(idYoutube, nombre, idUsuarioL);
				daoV.insert(video);
				mensaje = "Inserción correcta del video " + video.getNombre();
				break;
				
			case "editar":
				idL = extraerId(id);
				idUsuarioL = extraerId(idUsuario);
				video = new Video(idL, idYoutube, nombre, idUsuarioL);
				daoV.update(video);
				mensaje = "Actualización correcta del video " + video.getNombre();
				break;
				
			case "borrar":
				idL = extraerId(id);
				daoV.delete(idL);
				mensaje = "Borrado correcto del video con id " + idL;
				break;
				
			default:
				throw new ControladorException("No se admite una peticion que no sea insertar, editar o borrar");
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("administrar?accion=videos").forward(request, response);
	}
	
	private long extraerId(String id) {
		long idLong;
		
		if (id == null) {
			throw new ControladorException("Necesito un id");
		}
		
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new ControladorException("El id no era numérico", e);
		}
		return idLong;
	}

}
