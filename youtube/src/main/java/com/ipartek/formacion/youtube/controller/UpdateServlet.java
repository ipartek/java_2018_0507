package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
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
			Video v = new Video();
			v = dao.getById(id);
			//No esta recogiendo el video del getByID
			/*System.out.println("Este es el codigo del video " +v.getCodigo());
			System.out.println("Este es el nombre del video " +v.getNombre());
			System.out.println("Este es el id del video " +v.getId());
			System.out.println("Este es el idusuario del video " +v.getIdUsuario());*/
			request.setAttribute("video", v);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
