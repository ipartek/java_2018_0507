package com.ipartek.formacion.GestionLibros;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.video.pojo.VideoYoutube;

public class GestionLibrosDao implements CrudAble<Libro> {

	
	private List<Libro> libros = new ArrayList<>();
	
	
	private GestionLibrosDao() {
		
	}
	
	
	public List<Libro> getAll(){
		return libros;
	}
	
	public Libro getById(long id) {
		Libro resultado = null;
		
		for (Libro l : libros) {
			if ( id == l.getId() ) {
				resultado = l;
				break;
			}
		}
		return resultado;
	}
	
	public boolean insert (Libro libro) {
		
		boolean resultado = false;
		
		if(libro != null) {
			resultado = libros.add(libro);
		}
		return resultado;
	}
	
	public boolean delete (long id) {
		boolean resultado = false;
		
		Libro libroIteracion = null;
		
		for (int i = 0; i < libros.size(); i++) {
			libroIteracion = libros.get(i);
		}
		if (id == libroIteracion.getId()) {
			resultado = libros.remove(libroIteracion);
		}
		
		return resultado;
	}



	@Override
	public boolean update(Libro pojo) {
		
		return false;
	}


	@Override
	public Libro getByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean delete(Libro pojo) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
