package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.accesodatos.PerroMySqlDAO;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Perro;


/**
 * Servlet implementation class AdministrarvideosServlet
 */
@WebServlet("/videos")
public class AdministrarPerrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite una peticion que no tenga accion");
		}
		
		PerroMySqlDAO dao = PerroMySqlDAO.getInstance();
		
		Long idL;
		Perro perro = null;
		
		switch (accion) {
			case "insertar":
				break;
			case "editar":
			case "borrar":
				idL = extraerId(id);
				perro = dao.getById(idL);
				request.setAttribute("perro", perro);
				request.setAttribute("selectedUsuarioId", video.getIdUsuario());
				break;
			default:
				throw new ControladorException("No se admite una peticion que no sea insertar, editar o borrar");
		}
		
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/admin/operacionesVideo.jsp").forward(request, response);
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
