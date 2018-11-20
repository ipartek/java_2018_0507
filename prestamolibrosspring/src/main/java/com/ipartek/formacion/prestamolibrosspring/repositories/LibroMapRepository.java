package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;
import com.ipartek.formacion.prestamolibrosspring.model.Libro;

@Repository
public class LibroMapRepository implements CrudAble<Libro>{
	private TreeMap<Long, Libro> libros = new TreeMap<>(); 
	
	public LibroMapRepository() {
		libros.put(1L, new Libro("Titulo1", "Anaya",1L,1));
		libros.put(2L, new Libro("Titulo2", "planeta",2L,2));
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
	public Long insert(Libro l) {
	
		Long idAnterior;
		
		if(libros.size() == 0)
			idAnterior = 0L;
		else
			idAnterior = libros.lastKey(); 
		
		l.setId((int) (idAnterior + 1));
		
		libros.put((long) l.getId(), l);
		
		return (long) l.getId();
	}

	@Override
	public void update(Libro l) {
		libros.put((long) l.getId(), l); //Si ya existe el id sustituye el objeto en lugar de crear uno nuevo
	}

	@Override
	public void delete(Long id) {
		libros.remove(id);
	}

}
