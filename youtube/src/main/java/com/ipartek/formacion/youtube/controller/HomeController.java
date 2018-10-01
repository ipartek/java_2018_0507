package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

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

			String id = request.getParameter("id");

			dao = VideoArrayListDAO.getInstance();

			if (id != null) {
				dao.delete(id);
			}

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

		// insertar videos y q aparezcan en la interfaz

		try {

			// recoger parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");

			// insertar
			Video v = new Video(id, nombre);
			dao.insert(v);

			// pedir listado
			dao = VideoArrayListDAO.getInstance();
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

		// borrar actualizar y buscar videos y que desaparezcan o cambien
		// recoger parametros

		String idbb = request.getParameter("idbuscarborrar");
		String btnborrar = request.getParameter("btnupd");
		String btnbuscar = request.getParameter("btnupd");
		String btnupdate = request.getParameter("btnupd");

		if (btnborrar.equalsIgnoreCase("borrar")) {

			if (!dao.getAll().isEmpty()) {
				// borrar
				dao.delete(idbb);
			}else {
				request.setAttribute("error", "No hay videos que borrar");
				//request.getRequestDispatcher("home.jsp").forward(request, response);
			}

		}
		
		
		if(btnbuscar.equalsIgnoreCase("buscar")) {
			
			dao.getById(idbb);
			
			
		}else {
			request.setAttribute("error", "exixte el video");
		}
		
		
		
		
		

	}

}
