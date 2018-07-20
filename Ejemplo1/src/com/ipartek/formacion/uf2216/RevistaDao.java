package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RevistaDao implements CrudAble<Revista>{

	private List<Revista> revistas = new ArrayList<>();
	
	private static RevistaDao INSTANCE;
	
	private RevistaDao() {
		
	}
	
	public static synchronized RevistaDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistaDao();
		}
		
		return INSTANCE;
	}
	
	@Override
	public List<Revista> getAll() {
		return revistas;
	}

	@Override
	public Revista getById(long id) {
		Revista resul = null;
		for(Revista revistaIteracion : revistas) {
			if (id == revistaIteracion.getId()) {
				resul = revistaIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Revista revista) {
		boolean resul = false;
		
		if (revista != null) {
			resul = revistas.add(revista);
		}
		return resul;
		
	}

	@Override
	public boolean update(Revista revistaUpdate) {
		boolean resul = false;
		Revista revistaIteracion = null;
		int i = 0;
		if (revistaUpdate != null) {
			Iterator<Revista> it = revistas.iterator();
			while( it.hasNext()) {
				revistaIteracion = it.next();
				if (revistaIteracion.getId() == revistaUpdate.getId()) {
					revistas.set(i, revistaUpdate);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		
		Revista revistaIteracion = null;
		for (int i = 0; i < revistas.size(); i++) {
			revistaIteracion = revistas.get(i);
			
			if (id == revistaIteracion.getId()) {
				resul = revistas.remove(revistaIteracion);
				break;
			}
		}
		return resul;
	}

	
}
