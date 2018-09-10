package com.ipartek.formacion.uf2216_recuperacion.movil;

import java.util.List;

	public interface CrudAble<R> {
	
		//Retrieve
		
		List<R> getAll();
	
		List<Movil> insert(R pojo);

		

		Movil getMovil();
		
		
	}


