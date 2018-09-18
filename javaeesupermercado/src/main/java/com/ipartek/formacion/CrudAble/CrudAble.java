package com.ipartek.formacion.CrudAble;

import java.util.List;

public interface CrudAble <L> {
	
	List <L> getAll();
	
	L getByID(long id);
	
	boolean insert(L pojo);
	boolean update(L pojo);
	boolean delete(long id);
	
	
}
