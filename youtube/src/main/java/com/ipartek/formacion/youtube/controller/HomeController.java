package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Usuarios;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.ComentariosMySqlDAO;
import com.ipartek.formacion.youtube.model.UsuariosMySqlDAO;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoMySqlDAO dao;
	private static ComentariosMySqlDAO daoC;
	private static UsuariosMySqlDAO daoU;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
			}

			dao = VideoMySqlDAO.getInstance();
			daoC = ComentariosMySqlDAO.getInstance();
			daoU = UsuariosMySqlDAO.getInstance();
			
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			//ArrayList<Comentario> comentario = (ArrayList<Comentario>) daoC.ObtenerPrimerVideo();
			ArrayList<Usuarios> emails = (ArrayList<Usuarios>) daoU.ObtenerEmailComentarios();
			
			
			request.setAttribute("videos", videos);
			//request.setAttribute("comentario", comentario);
			request.setAttribute("emails", emails);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dao = VideoMySqlDAO.getInstance();

			// recoger parametros
			String idVideo = request.getParameter("id");
			String nombre = request.getParameter("nombre");

			// insertar
			Video v = new Video(idVideo, nombre);
			dao.insert(v);

			// pedir listado
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
}
