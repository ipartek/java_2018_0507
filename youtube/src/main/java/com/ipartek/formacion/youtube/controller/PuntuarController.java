package com.ipartek.formacion.youtube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.accesodatos.VideoMySqlDAO;
import com.ipartek.formacion.youtube.model.Usuario;

@WebServlet("/puntuar")
public class PuntuarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String puntos = request.getParameter("rating");
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			VideoMySqlDAO.getInstance().insertPuntuacion(usuario, Long.parseLong(id), Integer.parseInt(puntos));
			
			request.getRequestDispatcher("/?idver=" + id).forward(request, response);
		} catch (Exception e) {
			throw new ControladorException(e.getMessage(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
