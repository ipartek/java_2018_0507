package com.ipartek.formacion.uf2216.revista;

import java.util.List;

	public interface CrudAble<R> {
	
	
		List<Revista> getAll();
		
		Revista getRevistas(long id);
		

		boolean insert(R pojo);
	
	}

