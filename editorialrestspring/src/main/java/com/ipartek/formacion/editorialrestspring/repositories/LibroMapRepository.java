package com.ipartek.formacion.editorialrestspring.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.editorialrestspring.modelos.Editorial;
import com.ipartek.formacion.editorialrestspring.modelos.Libro;

@Repository
public class LibroMapRepository implements CrudAble<Libro> {

	private TreeMap<Long, Libro> libros = new TreeMap<>();
	
	public LibroMapRepository() {
		libros.put(1L, new Libro(1L, "El señor de los anillos", "123456789112A", new Editorial(1L, "Anaya")));
		libros.put(2L, new Libro(2L, "Musashi", "123456789112B", new Editorial(2L, "McGraw Hill")));
	}
	
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
		if (!libros.containsKey(libro.getId())) {
			throw new RepositoryException("El libro no existe, con lo que no se puede modificar");
		}
		
		libros.put(libro.getId(), libro);
	}

	@Override
	public boolean delete(Long id) {
		if (!libros.containsKey(id)) {
			throw new RepositoryException("El libro no existe, con lo que no se puede borrar");
		}
		
		libros.remove(id);
		return true;
	}

}
