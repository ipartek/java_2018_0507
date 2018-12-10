package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.ComentariosMySqlDAO;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoMySqlDAO dao;
	private static ComentariosMySqlDAO daocomentario;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
			}
			System.out.println("COMENTARIOS1");
			dao = VideoMySqlDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			System.out.println("COMENTARIOS2");
			
			daocomentario = ComentariosMySqlDAO.getInstance();
			List<Comentario> comentarios =(List<Comentario>) daocomentario.getAll();
			
			for(Comentario str : comentarios)
			{
			   
			    System.out.println("Pinto el el homeControler"+ str.getUsuario() +" " +str.getComentario());
			}
			 
			 
			System.out.println("COMENTARIOS3");
			System.out.println("VIDEOS: " + videos.toString());
			//System.out.println("COMENTARIOS" + comentarios.toString());

			request.setAttribute("videos", videos);
			request.setAttribute("comentarios", comentarios);

		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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