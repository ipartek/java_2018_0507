package com.ipartek.formacion.MF0967_3.modelo;

import java.util.List;

public interface CrudAble<P> {
			//Create
			boolean insert(P pojo);
			
			//Read
			List<P> getAll();
			
			//Read by Id
			P getById(String id);
			
			//Upadte
			boolean update(P pojo);
			
			//Delete
			boolean delete(String id);
}
