package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.youtube.model.Comentario;
import com.ipartek.formacion.youtube.model.Usuario;
import com.ipartek.formacion.youtube.model.Video;

@WebServlet("/enviarcomentario")
public class EnviarComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");

			String texto = request.getParameter("texto");

			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			Date hoy = new Date();
			Video video = VideoMySqlDAO.getInstance().getById(id);
			
			Comentario comentario = new Comentario(null, texto, usuario, hoy, video);
			
			System.out.println(comentario);
			
			request.getRequestDispatcher("/?idver=" + id).forward(request, response);
			
		} catch (Exception e) {
			throw new ControladorException("Error al guardar el comentario", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
