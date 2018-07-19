package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class LibrosArrayDAO implements CrudAble<Libro> {
	
	private List <Libro> libros = new ArrayList<>();
	
	private static LibrosArrayDAO INSTANCE;
	
	private LibrosArrayDAO() {
		
	}
	
	public static synchronized LibrosArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibrosArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<Libro> getAll() { //todos los libros
		return null;
	}

	@Override
	public Libro getById(long id) { //buscar por id libro
		Libro res = null;
		//foreach
		for (Libro LibInt : libros) {
			if ( id == LibInt.getId() ) {
				res = LibInt;
				break;
			}
		}
		return res;
	}
	
	@Override
	public boolean insert(Libro pojo) { //añadir un libro
		boolean res = false;

		if (pojo != null) {
			res = libros.add(pojo);
		}
		return res;
	}

	@Override
	public boolean update(Libro pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
