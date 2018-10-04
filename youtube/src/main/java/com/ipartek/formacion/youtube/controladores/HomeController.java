package com.ipartek.formacion.youtube.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.accessoadatos.VideoMySqlDAO;
import com.ipartek.formacion.youtube.pojo.Video;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoMySqlDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
			}

			dao = VideoMySqlDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			
			System.out.println("VIDEOS: " + videos);
			
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dao = VideoMySqlDAO.getInstance();

			// recoger parametros
			String idVideo = request.getParameter("idVideo");
			String nombre = request.getParameter("nombre");
			Long id = Long.valueOf(request.getParameter("id"));
			String op = request.getParameter("op");


			// insertar
			
			Video v = new Video(idVideo, nombre);
			dao.insert(v);
			
			// pedir listado
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);
			
			//modificar		
			
			v.setNombre(nombre);
			v.setIdVideo(idVideo);
			v.setId(id);
			dao.update(v);
			 
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}

