package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Libro;

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
	public List<Libro> getAll() {
		// TODO Auto-generated method stub
		return libros;
	}

	@Override
	public Libro getById(long id) {
		Libro res = null;
		for(Libro libroIteracion : libros) {
			if(id == libroIteracion.getId())
				res = libroIteracion;
				break;
		}
		return res;
	}

	@Override
	public boolean insert(Libro pojo) {
		// TODO Auto-generated method stub
		return false;
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
