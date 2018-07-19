package com.ipartek.formacion.prestamolibros.accesodatos;

import java.util.List;

public interface CrudableLibro<Libro> extends CrudAble<> {
	
	
	List<P> getAllDisponibles();

}
