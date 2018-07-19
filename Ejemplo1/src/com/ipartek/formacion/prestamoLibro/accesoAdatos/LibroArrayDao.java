package com.ipartek.formacion.prestamoLibro.accesoAdatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.prestamoLibro.pojo.Cliente;
import com.ipartek.formacion.prestamoLibro.pojo.Libro;
import com.ipartek.formacion.video.accesoadatos.VideoYoutubeArrayDAO;

public class LibroArrayDao implements CrudAble<Libro> {
	List <Libro> libros=new ArrayList<>();
	private static LibroArrayDao INSTANCE;
	private LibroArrayDao() {
		
	}
	public static synchronized LibroArrayDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibroArrayDao();
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
		// TODO Auto-generated method stub
		Libro lib=null;
		for(Libro l:libros)
			if(l.getId()==id)
			{
				return l;
			}
		return lib;
	}

	@Override
	public boolean insert(Libro pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			libros.add(pojo);
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
