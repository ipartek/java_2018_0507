package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.youtube.model.Usuario;
import com.ipartek.formacion.youtube.model.Video;

@WebServlet("/gestionvideos")
public class GestionVideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
			
			String accion = request.getParameter("accion");

			switch (accion) {
			case "insert":
				// recoger parametros
				String idVideo = request.getParameter("idvideo");
				String nombre = request.getParameter("nombre");

				// insertar
				Video v = new Video(idVideo, nombre, usuario);
				VideoMySqlDAO.getInstance().insert(v);
				
				request.getRequestDispatcher("/").forward(request, response);
				break;
			case "delete":
				String id = request.getParameter("id");

				if (id != null) {
					VideoMySqlDAO.getInstance().delete(id);
				}

				request.getRequestDispatcher("/").forward(request, response);
				
				break;
			default:
				throw new ControladorException("No se conoce la acción " + accion);
			}
			
			
		} catch (Exception e) {
			throw new ControladorException(e.getMessage(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
