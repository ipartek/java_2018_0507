package com.ipartek.prestamolibros.accesoDatos;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.ipartek.prestamolibros.pojo.PrestamoLibros;

public class PrestamoLibrosDAO implements CrudAble<PrestamoLibros>{

	private List<PrestamoLibros> libros = new ArrayList<>();
	private static PrestamoLibrosDAO INSTANCE;
	
	private PrestamoLibrosDAO() {
	}
	public static synchronized PrestamoLibrosDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PrestamoLibrosDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public List<PrestamoLibros> getAll() {
		return libros;
	}

	@Override
	public PrestamoLibros getById(long id) {
		PrestamoLibros resul = null;
		//foreach
		for (PrestamoLibros libroIteracion : libros) {
			if ( id == libroIteracion.getId() ) {
				resul = libroIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(PrestamoLibros libro) {
		boolean resul = false;

		if (libro != null) {
			resul = libros.add(libro);
		}
		return resul;
	}

	@Override
	public boolean update(PrestamoLibros libroUpdate) {
		boolean resul = false;
		PrestamoLibros libroIteracion = null;
		int i = 0;
		if ( libroUpdate != null ) {
			//Iterator		
			Iterator<PrestamoLibros> it = libros.iterator();
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
		
		PrestamoLibros vIteracion = null;
		
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
