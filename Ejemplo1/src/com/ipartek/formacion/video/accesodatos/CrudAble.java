package com.ipartek.formacion.video.accesodatos;

import java.util.List;

//CREATE, RETRIEVE, UPDATE, DELETE
public interface CrudAble<P> {		//ACCESO A DATOS
	//Retrieve
	List<P> getAll();
	
	P getById(long id);
	
	//Create
	void insert(P pojo);
	//Upadte
	void update(P pojo);
	//Delete
	void delete(P pojo);
}
