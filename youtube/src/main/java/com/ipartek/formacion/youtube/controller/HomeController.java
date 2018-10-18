package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.VideoMySQLDAO;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	static String url = "jdbc:mysql://localhost:3307/videoyoutube?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	Connection conn;

	private static final long serialVersionUID = 1L;
	private static VideoMySQLDAO dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO descomentar el doGet. Ahora lo ejecuto desde el post
	/*	try {
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
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		//Switch para poder elegir que quieres hacer
		String accion = request.getParameter("accion");
		
		
		
		//TODO Descomentar el insert
		/*try {

			// recoger parametros
			//TODO No entro aqui al cargar el servlet
			//Esta parte es dependiente del insert, no deberia llegar aqui
			int id = Integer.parseInt(request.getParameter("id"));
			//System.out.println("Valor del " + id);
			String codigo = request.getParameter("codigo");
			//System.out.println("Valor del " + codigo);
			String nombre = request.getParameter("nombre");
			//System.out.println("Valor del " + nombre);	
			int idUsuario = Integer.parseInt(request.getSession().getId());
			System.out.println("Valor del " + idUsuario);
			
			// insertar
			//Video v = new Video(id, codigo, nombre, idUsuario);
			///////dao.insert(v);
			// pedir listado
			////////dao = VideoMySQLDAO.getInstance();
			/*
			 * ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			 * request.setAttribute("videos", videos);
			 */
/*
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}*/
	}
	

}
