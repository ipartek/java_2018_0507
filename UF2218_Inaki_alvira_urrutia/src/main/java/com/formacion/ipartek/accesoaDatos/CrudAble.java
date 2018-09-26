package com.formacion.ipartek.accesoaDatos;

import java.util.List;

//Create
//Retrieve
//Update
//Delete
public interface CrudAble<P> {
	//retrieve(obtener Todo)
	//recupera todos los pojos si 
	//no exixten retotna lista vacia no null
	List<P> getAll();	
	//buscamos un pojo por su identificador 
	//P pojo si lo encuentra,null si no encuentra
	P getById(long id);
	//create
	boolean insert(P pojo);
	//Update
	boolean update(long id ,P pojo);
	boolean update(P pojo);
	//Delete
	boolean delete(long id);
}
