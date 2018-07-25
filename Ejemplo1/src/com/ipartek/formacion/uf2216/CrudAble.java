package com.ipartek.formacion.uf2216;

import java.util.List;

public interface CrudAble <L> {

		List<L> getAll();
		
		L getByID(long id);
		
		boolean insert(L pojo);


		
}
