package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.prestamolibrosspring.model.Libro;
import com.ipartek.formacion.prestamolirbosspring.exceptions.RepositoryException;

public class LibroMapRepository implements CrudAble <Libro> {
	
	private TreeMap <Long,Libro> libros = new TreeMap<>();
	

	@Override
	public List<Libro> getAll() {
		return new ArrayList<Libro>(libros.values());
	}

	@Override
	public Libro getById(Long id) {
		return libros.get(id);
		
	}

	@Override
	public Long insert(Libro l) {
		
		Long idAnterior;
		
		if(libros.size() == 0) {
			idAnterior = 0L;
		}else {
			idAnterior=libros.lastKey();
		}
	l.setId(idAnterior+1);
	
	libros.put(l.getId(), l);
	return l.getId();
		
	}

	@Override
	public void update(Libro l) {
		
		if(libros.containsKey(l.getId())) {
			
			throw new RepositoryException("El libro no existe, asique no se puede editar");
		}
		
		libros.put(l.getId(), l);
		
	}

	@Override
	public void delete(Long id) {
	    libros.remove(id);
		
	}

	
}
