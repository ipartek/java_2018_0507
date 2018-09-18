package com.ipartek.formacion.CrudAble;

import java.util.List;

public interface CrudAble <B> {
	
	List <B> getAll();
	
	B getByID(long id);
	
	boolean insert(B pojo);
	boolean update(B pojo);
	boolean delete(long id);
	
	
}
