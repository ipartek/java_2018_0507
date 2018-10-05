package com.ipartek.formacion.youtubeSinBBDD.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtubeSinBBDD.accesodatos.VideoTreeMapDAO;
import com.ipartek.formacion.youtubeSinBBDD.modelos.Video;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Conjunto de videos
		List<Video> videos = VideoTreeMapDAO.getInstance().getAll();

		request.setAttribute("videos", videos);

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
