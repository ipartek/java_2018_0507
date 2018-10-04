package com.ipartek.examen.controladores;

import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Crudable")
public interface CrudAble<S> {

	List<S> getAll();
	S getById(long id);
	boolean insert(S pojo);
	boolean update(S pojo);
	boolean delete(long id);
}
