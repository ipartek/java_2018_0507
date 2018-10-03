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
import com.ipartek.formacion.youtube.model.VideoArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoArrayListDAO dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			System.out.println("DOGET");
			Class.forName("com.mysql.jdbc.Driver");
			
			String idvideo = request.getParameter("id");
			
			if ( idvideo != null ) {
				dao.delete(idvideo);
			}
			
			
			dao = VideoArrayListDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			System.out.println("HOMECONTROLER !");
		
		/*	VideoArrayListDAO vald = null;
			vald.getAll();*/
			//List lista=VideoArrayListDAO.getListBD();
			
			/*for(Video video:videos){
				System.out.println("FOR");
				System.out.println(video.getId()+"--"+video.getNombre()+"--"+video.getL());
				
			}*/
			
			request.setAttribute("videos", videos);
			//System.out.println("HomeController saliendo");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
		
		/*try {
			System.out.println("DOPOST");
			//recoger parametros
			String id=request.getParameter("id");
			String nombre = request.getParameter("nombre");
			
			
			//insertar
			//Video v = new Video(Long.parseLong("1") ,id, nombre);
			//dao.insert(v);
			
			//pedir listado
			dao = VideoArrayListDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}*/
	}

}
