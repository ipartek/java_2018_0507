package com.ipartek.formacion.accesoDatos;

import java.util.List;

// Create
// Retrieve
// Update
// Delete
public interface CrudAble<P>{
	// Retrieve
	List<P> getAll();
	
	// Create
	void insert(P pojo);
	
	// Update
	void update(P pojo);
	
	// Delete
	void delete(P pojo);
}
