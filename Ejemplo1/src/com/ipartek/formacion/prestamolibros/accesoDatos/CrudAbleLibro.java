package com.ipartek.formacion.prestamolibros.accesoDatos;

import com.ipartek.formacion.video.accesodatos.CrudAble;

public interface CrudAbleLibro<P> extends CrudAble<P> {

	/**
	 * Buscamos un libro por su isbn
	 * @param id string identificador
	 * @return P pojo si no lo encuentra, null si no encuentra
	 * */
	P getByIsbn(String isbn);
}
