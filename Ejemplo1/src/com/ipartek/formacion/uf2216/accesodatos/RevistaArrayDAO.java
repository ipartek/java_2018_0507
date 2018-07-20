package com.ipartek.formacion.uf2216.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.uf2216.pojo.Revista;

public class RevistaArrayDAO implements CrudAble<Revista>{
	
	private List<Revista> revistas = new ArrayList<>();
	
	private static RevistaArrayDAO INSTANCE;
	
	private RevistaArrayDAO() {
		
	}
	
	public static synchronized RevistaArrayDAO getInstance() {
		if(INSTANCE ==null) {
			INSTANCE = new RevistaArrayDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Revista> getAll() {
		return revistas;
	}

	@Override
	public Revista getById(long id) {
		Revista result = null;
		for(Revista revistaIteracion : revistas) {
			if(id==revistaIteracion.getId()) {
				result = revistaIteracion;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean insert(Revista revista) {
		boolean result = false;
		
		if(revista != null) {
			result = revistas.add(revista);
		}
		return result;
	}

	@Override
	public boolean update(Revista revistaUpdate) {
		boolean result = false;
		Revista revistaIteracion = null;
		int i = 0;
		if(revistaUpdate != null) {
			Iterator<Revista> it = revistas.iterator();
			while( it.hasNext() ) {
				revistaIteracion = it.next();
				if ( revistaIteracion.getId() == revistaIteracion.getId() ) {
					revistas.set(i, revistaUpdate);
					result = true;
					break;					
				}	
				i++;
			}		
		}	
		return result;
	}

	@Override
	public boolean delete(long id) {
		boolean result = false;
		
		Revista rIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < revistas.size(); i++) {
			
			rIteracion = revistas.get(i);  
			
			if ( id == rIteracion.getId() ) {  
				result = revistas.remove(rIteracion);
				break;
			}
		}
		
		return result;
	}

}
