package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Libro;


public class LibroArrayDAO implements  CrudAble<Libro> {

	private List<Libro> libros = new ArrayList<>();

	private static LibroArrayDAO INSTANCE;

	private LibroArrayDAO() {
	}

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

	public Libro getById(long id) {
		Libro resul = null;
		//foreach
		for (Libro libroIteracion : libros) {
			if ( id == libroIteracion.getId() ) {
				resul = libroIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Libro libro) {
		
		System.out.println("libro.getTitulo()"+libro.getTitulo());
		boolean resul = false;

		if (libro != null) {
			resul = libros.add(libro);
			System.out.println("LibroAñadido");
		}
		return resul;
	}

	@Override
	public boolean update(Libro libro) {
		boolean resul = false;
		Libro videoIteracion = null;
		int i = 0;
		if ( libro != null ) {
			//Iterator		
			Iterator<Libro> it = libros.iterator();
			while( it.hasNext() ) {
				videoIteracion = it.next();
				if ( videoIteracion.getId() == libro.getId() ) {
					libros.set(i, libro);
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
		
		Libro vIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < libros.size(); i++) {
			
			vIteracion = libros.get(i);   //video sobre el que iteramos
			
			if ( id == vIteracion.getId() ) {    // video encontrado
				resul = libros.remove(vIteracion);
				break;
			}
		}
		
		return resul;
	}
}
