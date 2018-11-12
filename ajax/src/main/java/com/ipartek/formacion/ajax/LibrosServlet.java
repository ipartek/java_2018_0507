package com.ipartek.formacion.ajax;

import java.io.IOException;
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

	private static TreeMap<Long, Libro> libros = new TreeMap<Long, Libro>();

	static {
		libros.put(1L, new Libro(1L, "Libro1"));
		libros.put(2L, new Libro(2L, "Libro2"));
	}

	private static Gson gson = new Gson();

	// GET /libros
	// GET /libros/5
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		Long id = getIdFromUrl(request);

		if (id == null) {
			response.getWriter().append(gson.toJson(libros.values()));
		} else {
			Libro libro = libros.get(id);

			if (libro == null) {
				response.sendError(404, "No se ha encontrado el libro especificado cuyo id es " + id);
			} else {
				response.getWriter().append(gson.toJson(libro));
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Libro libro = gson.fromJson(request.getReader(), Libro.class);

		libro.setId(libros.lastKey() + 1);

		libros.put(libro.getId(), libro);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Libro libro = gson.fromJson(request.getReader(), Libro.class);

		if(libros.containsKey(libro.getId())) {
			libros.put(libro.getId(), libro);
		} else {
			response.sendError(500, "No se puede actualizar un libro NO existente");
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = getIdFromUrl(request);

		if(libros.containsKey(id)) {
		libros.remove(id);
		} else {
			response.sendError(500, "No puedo borrar un libro que no existe");
		}
	}

	private Long getIdFromUrl(HttpServletRequest request) {
		if (request.getPathInfo() == null || request.getPathInfo().equals("/")) {
			return null;
		}

		return Long.parseLong(request.getPathInfo().split("/")[1]);
	}
}
