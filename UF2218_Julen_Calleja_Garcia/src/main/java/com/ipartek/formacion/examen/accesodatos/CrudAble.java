package com.ipartek.formacion.examen.accesodatos;

import java.util.List;

public interface CrudAble <P>{

	List<P> getAll();
	
	P getById(long id);
	
	boolean insert(P pojo);

}
