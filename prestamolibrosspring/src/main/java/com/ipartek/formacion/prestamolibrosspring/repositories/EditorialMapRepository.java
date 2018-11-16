package com.ipartek.formacion.prestamolibrosspring.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.prestamolibrosspring.model.Editorial;

@Repository
public class EditorialMapRepository implements CrudAble<Editorial>{
	private TreeMap<Long, Editorial> editoriales = new TreeMap<>(); 
	
	public EditorialMapRepository() {
		editoriales.put(1L, new Editorial(1L, "Anaya"));
		editoriales.put(2L, new Editorial(2L, "McGraw Hill"));
	}
	
	@Override
	public List<Editorial> getAll() {
		return new ArrayList<Editorial>(editoriales.values());
	}

	@Override
	public Editorial getById(Long id) {
		return editoriales.get(id);
	}

	@Override
	public Long insert(Editorial e) {
		Long idAnterior;
		
		if(editoriales.size() == 0)
			idAnterior = 0L;
		else
			idAnterior = editoriales.lastKey(); 
		
		e.setId(idAnterior + 1);
		
		editoriales.put(e.getId(), e);
		
		return e.getId();
	}

	@Override
	public void update(Editorial e) {
		editoriales.put(e.getId(), e); //Si ya existe el id sustituye el objeto en lugar de crear uno nuevo
	}

	@Override
	public void delete(Long id) {
		editoriales.remove(id);
	}

}
