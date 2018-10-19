package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.youtube.model.Video;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("idver");
			
			ArrayList<Video> videos = (ArrayList<Video>) VideoMySqlDAO.getInstance().getAll();
			
			Video videoInicio = null;
			
			if(id != null) {
				videoInicio = VideoMySqlDAO.getInstance().getById(id);
			} else {
				videoInicio = new Video();
	      		
				if ( !videos.isEmpty() ){
	      			videoInicio = videos.get(0);
				}
			}
			
			request.setAttribute("videoInicio", videoInicio);
			request.setAttribute("videos", videos);

			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ControladorException(e.getMessage(), e);
		} 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
}
