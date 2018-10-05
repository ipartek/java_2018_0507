package com.ipartek.formacion.youtube.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuarios;
import com.ipartek.formacion.youtube.model.UsuariosMySqlDAO;
import com.ipartek.formacion.youtube.model.VideoMySqlDAO;


@WebServlet("/listado")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuariosMySqlDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			dao = UsuariosMySqlDAO.getInstance();
			ArrayList<Usuarios> usus = (ArrayList<Usuarios>)dao.getAll();
			
			request.setAttribute("listausus", usus);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
