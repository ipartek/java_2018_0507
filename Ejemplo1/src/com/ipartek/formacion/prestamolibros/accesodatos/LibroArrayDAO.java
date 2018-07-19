package com.ipartek.formacion.prestamolibros.accesodatos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.*;



public class LibroArrayDAO implements CrudAble<Libro> {

	private List<Libro> libros = new ArrayList<>();
	
	private static LibroArrayDAO INSTANCE;
	
	private LibroArrayDAO() {
	}

	/**
	 * metodo para crear una sola instancia de esta clase fuera de ella.
	 * si no hay una instancia creada se crea una y la devuelve
	 * @return INSTANCE
	 */
	public static synchronized LibroArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroArrayDAO();
		}

		return INSTANCE;
	}
	
	
	
	@Override
	public List<Libro> getAll() {
		return libros;
	}

	@Override
	public Libro getById(long id) {
		Libro resul = null;
		// foreach
		for (Libro libroIteracion : libros) {
			if (id == libroIteracion.getId()) {
				resul = libroIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Libro libro) {
		boolean resul = false;

		if (libro != null) {
			resul = libros.add(libro);
		}
		return resul;
	}

	@Override
	public boolean update(Libro libroUpdate) {
		boolean resul = false;
		Libro videoIteracion = null;
		int i = 0;
		if (libroUpdate != null) {
			// Iterator
			Iterator<Libro> it = libros.iterator();
			while (it.hasNext()) {
				videoIteracion = it.next();
				if (videoIteracion.getId() == libroUpdate.getId()) {
					libros.set(i, libroUpdate);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;

		Libro lIteracion = null;

		// buscar video a eliminar
		for (int i = 0; i < libros.size(); i++) {

			lIteracion = libros.get(i); // libro sobre el que iteramos

			if (id == lIteracion.getId()) { // libro encontrado
				resul = libros.remove(lIteracion);
				break;
			}
		}

		return resul;
	}
	
	
	

}
