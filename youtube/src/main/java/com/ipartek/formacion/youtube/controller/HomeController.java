package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoArrayMysqlDAO;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoArrayMysqlDAO dao;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			String id = request.getParameter("id");
			if ( id != null ) {
				dao.delete(id);
			}
			
			
			VideoArrayMysqlDAO dao = VideoArrayMysqlDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		try {
			
			//recoger parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String idvideo = request.getParameter("idvideo");
			dao = VideoArrayMysqlDAO.getInstance();
			//insertar
			Video v = new Video(id, nombre,idvideo);
			dao.insert(v);
			
			//pedir listado
			
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
