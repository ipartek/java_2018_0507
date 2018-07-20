package com.ipartek.formacion.uf2216.revista;

import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Libro;

	public interface CrudAble<R> {
	
	
		List<Revista> getAll();
		
		Revista getRevistas(long id);
		

		boolean insert(R pojo);
	
	}

