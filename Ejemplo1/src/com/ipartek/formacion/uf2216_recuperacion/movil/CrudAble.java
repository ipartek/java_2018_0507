package com.ipartek.formacion.uf2216_recuperacion.movil;

import java.util.List;

	public interface CrudAble<R> {
	
	
		List<Movil> getAll();
		
		Movil getMovil(long id);
		

		boolean insert(R pojo);
	
	}

