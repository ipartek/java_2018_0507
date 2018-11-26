package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.model.Libro;

@Repository
public class LibroMapRepository implements CrudAble<Libro> {

	private TreeMap<Long, Libro> libros = new TreeMap<>();
	
	@Override
	public List<Libro> getAll() {
		return new ArrayList<Libro>(libros.values());
	}

	@Override
	public Libro getById(Long id) {
		return libros.get(id);
	}

	@Override
	public Long insert(Libro libro) {
		Long idAnterior;
		
		if(libros.size() == 0)
			idAnterior = 0L;
		else
			idAnterior = libros.lastKey(); 
		
		libro.setId(idAnterior + 1);
		
		libros.put(libro.getId(), libro);
		
		return libro.getId();
	}

	@Override
	public void update(Libro libro) {
		if(!libros.containsKey(libro.getId())) {
			throw new RepositoryException("El libro no existe, por lo que no se puede modificar"); 
		}
		
		libros.put(libro.getId(), libro);
	}

	@Override
	public void delete(Long id) {
		if(!libros.containsKey(id)) {
			throw new RepositoryException("El libro no existe, por lo que no se puede modificar"); 
		}
		
		libros.remove(id);
	}

}
