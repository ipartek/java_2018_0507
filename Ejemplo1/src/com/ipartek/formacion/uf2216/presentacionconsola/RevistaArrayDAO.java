package com.ipartek.formacion.uf2216.presentacionconsola;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RevistaArrayDAO implements CrudAble<Revista> {

	private static List<Revista> revistas = new ArrayList<>();
	
	private static RevistaArrayDAO INSTANCE;
	
	private RevistaArrayDAO() {
		
	}

	public static synchronized RevistaArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistaArrayDAO();
		}
		return INSTANCE;
	}


	
	@Override
	public List<Revista> getAll() {
		// TODO Auto-generated method stub
		return revistas;
	}

	@Override
	public Revista getById(long id) {
		// TODO Auto-generated method stub
		Revista resul = null;
		for(Revista revistaIteracion : revistas) {
			if(id == revistaIteracion.getId()) {
				resul = revistaIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Revista revista) {
		// TODO Auto-generated method stub
		boolean resul = false;
		
		if(revista != null) {
			resul = revistas.add(revista);
		}
		return resul;
	}

	@Override
	public boolean update(Revista revistaUpdate) {
		// TODO Auto-generated method stub
		boolean resul = false;
		Revista revistaIteracion = null;
		int i = 0;
		if( revistaUpdate != null) {
			Iterator<Revista> it = revistas.iterator();
			while(it.hasNext()) {
				revistaIteracion = it.next();
				if(revistaIteracion.getIsbn() == revistaUpdate.getIsbn()) {
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
		// TODO Auto-generated method stub
		boolean resul = false;
		Revista rIteracion = null;
		
		for(int i=0;i<revistas.size();i++) {
			
		rIteracion = revistas.get(i);
			
		if(id == rIteracion.getId()) {
				resul = revistas.remove(rIteracion);
				break;
			}
		}
		
		
		return resul;
	}

	@Override
	public List<Revista> getAllFormato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Revista getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

