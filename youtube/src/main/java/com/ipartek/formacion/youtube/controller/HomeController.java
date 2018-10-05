package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoMySqlDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
<<<<<<< HEAD
			
			System.out.println("DOGET");
			Class.forName("com.mysql.jdbc.Driver");
			
			String idvideo = request.getParameter("id");
			
			if ( idvideo != null ) {
				dao.delete(idvideo);
=======
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
>>>>>>> refs/remotes/origin/master
			}

			dao = VideoMySqlDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
<<<<<<< HEAD
			System.out.println("HOMECONTROLER !");
		
		/*	VideoArrayListDAO vald = null;
			vald.getAll();*/
			//List lista=VideoArrayListDAO.getListBD();
			
			/*for(Video video:videos){
				System.out.println("FOR");
				System.out.println(video.getId()+"--"+video.getNombre()+"--"+video.getL());
				
			}*/
=======
			
			System.out.println("VIDEOS: " + videos);
>>>>>>> refs/remotes/origin/master
			
			request.setAttribute("videos", videos);
			//System.out.println("HomeController saliendo");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		
		doGet(request,response);
		
		/*try {
			System.out.println("DOPOST");
			//recoger parametros
			String id=request.getParameter("id");
=======
		try {
			dao = VideoMySqlDAO.getInstance();

			// recoger parametros
			String idVideo = request.getParameter("id");
>>>>>>> refs/remotes/origin/master
			String nombre = request.getParameter("nombre");
<<<<<<< HEAD
			
			
			//insertar
			//Video v = new Video(Long.parseLong("1") ,id, nombre);
			//dao.insert(v);
			
			//pedir listado
			dao = VideoArrayListDAO.getInstance();
=======

			// insertar
			Video v = new Video(idVideo, nombre);
			dao.insert(v);

			// pedir listado
>>>>>>> refs/remotes/origin/master
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}*/
	}
}
