package com.ipartek.formacion.ajax;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/libros/*")
public class LibrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Map<Long, Libro> libros = new TreeMap<Long, Libro>();
	
	static {
		libros.put(1L, new Libro(1L, "Libro1"));
		libros.put(2L, new Libro(2L, "Libro2"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String path = request.getPathInfo();
		
		Long id = path == null ? null : Long.parseLong(path.replace("/", ""));
		
		Gson gson = new Gson();
		
		if(id == null) {
			response.getWriter().append(gson.toJson(libros.values()));
		} else {
			response.getWriter().append(gson.toJson(libros.get(id)));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("libro");
		
		Gson gson = new Gson();
		
		System.out.println(json);
		
		Libro libro = gson.fromJson(json, Libro.class);
		
		System.out.println(libro);
		
		libros.put(0L, libro);
		
		doGet(request, response);
	}

}
