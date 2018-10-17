package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoMySQLDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = -1404030432724811577L;
	static String url = "jdbc:mysql://localhost:3307/videoyoutube?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	Connection conn;

	
	private static VideoMySQLDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String id = request.getParameter("id");
			dao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.getRequestDispatcher("inicio").forward(request, response);
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
