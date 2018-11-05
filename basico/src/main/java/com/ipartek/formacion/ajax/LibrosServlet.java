package com.ipartek.formacion.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class LibrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<Libro> libros = new ArrayList<Libro>();
	
	static {
		libros.add(new Libro(1L, "Libro1"));
		libros.add(new Libro(2L, "Libro2"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		Gson gson = new Gson();
		
		response.getWriter().append(gson.toJson(libros));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("libro");
		
		Gson gson = new Gson();
		
		System.out.println(json);
		
		Libro libro = gson.fromJson(json, Libro.class);
		
		System.out.println(libro);
		
		libros.add(libro);
		
		doGet(request, response);
	}

}
