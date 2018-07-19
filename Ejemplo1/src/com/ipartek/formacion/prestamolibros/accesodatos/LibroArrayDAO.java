package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Cliente;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;

public class LibroArrayDAO implements CrudAble<Libro>{

	private List<Libro> libros=new ArrayList<>();
	private static LibroArrayDAO INSTANCE;
	private LibroArrayDAO(){
		
	}
	
	public static synchronized LibroArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroArrayDAO();
		}

		return INSTANCE;
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
		
		Libro lIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < libros.size(); i++) {
			
			lIteracion = libros.get(i);   //video sobre el que iteramos
			
			if(id==lIteracion.getId() ) {    // video encontrado
				resul = libros.remove(lIteracion);
				break;
			}
		}
		
		return resul;
	}
	
	
	
	@Override
	public List<Libro> getAll() {
		// TODO Auto-generated method stub
		return libros;
	}

	@Override
	public Libro getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
}
