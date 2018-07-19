package com.ipartek.prestamolibros.accesoDatos;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import com.ipartek.prestamolibros.Libro;


public class LibrosArrayDAO implements CrudAble<Libro>{

	private List<Libro> libros = new ArrayList<>();
	private static LibrosArrayDAO INSTANCE;
	
	private LibrosArrayDAO() {
	}
	public static synchronized CrudAble<Libro> getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibrosArrayDAO();
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
			if ( id == libroIteracion.getId() ) {
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
		Libro libroIteracion = null;
		int i = 0;
		if ( libroUpdate != null ) {
			//Iterator		
			Iterator<Libro> it = libros.iterator();
			while( it.hasNext() ) {
				libroIteracion = it.next();
				if ( libroIteracion.getId() == libroUpdate.getId() ) {
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
		
		Libro vIteracion = null;
		
		//buscar libro a eliminar
		for (int i = 0; i < libros.size(); i++) {
			
			vIteracion = libros.get(i);   //libro sobre el que iteramos
			
			if ( id == vIteracion.getId() ) {    // libro encontrado
				resul = libros.remove(vIteracion);
				break;
			}
		}
		
		return resul;
	}
	
	

}
