package com.ipartek.formacion.accesoDatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.prestamoLibrosPojo.Libro;

public class LibroDAO implements CrudAbleLibro<Libro>{

	private List<Libro> libros = new ArrayList<>(); 

	// SINGLENTON
	private static LibroDAO INSTANCE;
	private LibroDAO() {}
	
	public static synchronized LibroDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
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
		
		//foreach
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
	public boolean update(Libro libro) {
		boolean resul = false;
		Libro lIteracion = null;
		int i = 0;
		
		if (libro != null){
			Iterator<Libro> it = libros.iterator();	// Iterator	
			while(it.hasNext()) {
				lIteracion = it.next();
				if (lIteracion.getId() == libro.getId()) {
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
		Libro lIteracion = null;
		
		// Buscar libro a eliminar
		for (int i = 0; i < libros.size(); i++) {
			lIteracion = libros.get(i);   			
			
			if (id == lIteracion.getId()) {    			
				resul = libros.remove(lIteracion);
				break;
			}
		}
			
		return resul;
	}

	
	
	@Override
	public Libro getByIsbn(String isbn) {
		Libro resul = null;
		
		for (Libro lIteracion : libros) {
			if (isbn == lIteracion.getIsbn()) {
				resul = lIteracion;
				break;
			}
		}
		return resul;
	}
	
}
