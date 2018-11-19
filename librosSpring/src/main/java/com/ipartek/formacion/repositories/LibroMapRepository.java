package com.ipartek.formacion.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.ipartek.formacion.model.Libro;

@Component
public class LibroMapRepository implements CrudAble<Libro> {
	private TreeMap<Long, Libro> libros = new TreeMap<>();
	public LibroMapRepository() {
		this.insert(new Libro(1L, "caperucita", "anaya", "12223335554558", "candy clayn"));
		this.insert(new Libro(2L, "xoxo", "macgrought", "12223335554558", "candy clayn"));
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
	public Long insert(Libro e) {
		Long idAnterior;

		if (libros.size() == 0)
			idAnterior = 0L;
		else
			idAnterior = libros.lastKey();

		e.setId(idAnterior + 1);

		libros.put(e.getId(), e);

		return e.getId();
	}

	@Override
	public void update(Libro e) {
		libros.put(e.getId(), e); // Si ya existe el id sustituye el objeto en lugar de crear uno nuevo
	}

	@Override
	public void delete(Long id) {
		libros.remove(id);
	}
}