package com.ipartek.formacion.uf2216.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.ipartek.formacion.uf2216.pojo.Revista;

public class RevistasArrayDAO implements CrudAble<Revista>{

	private List<Revista> revista = new ArrayList<>();
	private static RevistasArrayDAO INSTANCE;
	
	private RevistasArrayDAO() {
	}
	public static synchronized RevistasArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistasArrayDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public List<Revista> getAll() {
		return revista;
	}

	@Override
	public Revista getById(long id) {
		Revista resul = null;
		//foreach
		for (Revista revistaIteracion : revista) {
			if ( id == revistaIteracion.getId() ) {
				resul = revistaIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Revista libro) {
		boolean resul = false;

		if (libro != null) {
			resul = revista.add(libro);
		}
		return resul;
	}

	@Override
	public boolean update(Revista revistaUpdate) {
		boolean resul = false;
		Revista revistaIteracion = null;
		int i = 0;
		if ( revistaUpdate != null ) {
			//Iterator		
			Iterator<Revista> it = revista.iterator();
			while( it.hasNext() ) {
				revistaIteracion = it.next();
				if ( revistaIteracion.getId() == revistaUpdate.getId() ) {
					revista.set(i, revistaUpdate);
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
		
		Revista rIteracion = null;
		
		//buscar libro a eliminar
		for (int i = 0; i < revista.size(); i++) {
			
			rIteracion = revista.get(i);   //revista sobre el que iteramos
			
			if ( id == rIteracion.getId() ) {    // revista encontrado
				resul = revista.remove(rIteracion);
				break;
			}
		}
		
		return resul;
	}
}
