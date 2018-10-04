package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoMySQLDAO;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = -5136805947201077663L;
	private static VideoMySQLDAO video = null;
	private static VideoMySQLDAO dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
			video = new VideoMySQLDAO();
		//
		try {
			dao=VideoMySQLDAO.getInstance();
			String id = request.getParameter("id");
			Video v;
			v = dao.getById(id);
			request.setAttribute("video", v);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			dao = VideoMySQLDAO.getInstance();
			Video v= new Video(Integer.parseInt(request.getParameter("id")),
					request.getParameter("codigo"), request.getParameter("nombre"),
					Integer.parseInt(request.getParameter("idusuario")));
			
			dao.update(v);

			dao = VideoMySQLDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

}
