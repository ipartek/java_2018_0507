package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.ComentariosMySqlDAO;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;

@WebServlet("/inicio")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static VideoMySqlDAO dao;
	private static ComentariosMySqlDAO daocomentario;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("homeController doGET");
		String idVideo = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		System.out.println(request.getParameter("action"));
		System.out.println(request.getParameter("id"));
		try {
			String accion=request.getParameter("action");
			if(accion!=null && request.getParameter("id")!=null) {
				System.out.println("ACCION" + accion);
				String id = request.getParameter("id");
				 switch (accion) {
		            case "anadir":
		            	dao.insert(new Video(idVideo,nombre));
		                     break;
		            case "delete":
		            	System.out.println("Borrar de la bd el video con id="+ id);
						dao.delete(id);
	                    break;
	                default:break;
				
				 }
			}
		
			
			dao = VideoMySqlDAO.getInstance();
			
			System.out.println("AKI");
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
		
			System.out.println("AKI2");
			daocomentario = ComentariosMySqlDAO.getInstance();
			List<Comentario> comentarios =(List<Comentario>) daocomentario.getAll();
			System.out.println("AKI3");
			request.setAttribute("videos", videos);
			request.setAttribute("comentarios", comentarios);

		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("homeController doPOST");
		try {
			dao = VideoMySqlDAO.getInstance();
			daocomentario = ComentariosMySqlDAO.getInstance();

			// recoger parametros
			String idVideo = request.getParameter("id");
			String nombre = request.getParameter("nombre");

			// insertar
			Video v = new Video(idVideo, nombre);
			dao.insert(v);

			// pedir listado
			ArrayList<Video> videos = (ArrayList<Video>) dao.getAll();
			request.setAttribute("videos", videos);
			ArrayList<Comentario> comentarios = (ArrayList<Comentario>) daocomentario.getAll();
			request.setAttribute("comentarios", comentarios);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
}
