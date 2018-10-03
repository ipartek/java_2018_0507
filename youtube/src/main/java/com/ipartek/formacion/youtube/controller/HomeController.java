package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoMySQLDAO;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	static String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	Connection conn;

	private static final long serialVersionUID = 1L;
	private static VideoMySQLDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			if (id != null) {
				dao.delete(id);
			}

			dao = VideoMySQLDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

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
		try {

			// recoger parametros
			int id = Integer.parseInt(request.getParameter("id"));
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");
			int idUsuario = Integer.parseInt(request.getParameter("idusuario"));
			
			// insertar
			Video v = new Video(id, codigo, nombre);
			dao.insert(v);
			// pedir listado
			dao = VideoMySQLDAO.getInstance();
			/*
			 * ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			 * request.setAttribute("videos", videos);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
	

}
