package com.ipartek.formacion.uf2216.RevistaAccesoadatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.ipartek.formacion.uf2216.RevistaPojo.Revista;


public class RevistaArrayDao implements CrudAble<Revista> {
	List <Revista> revistas=new ArrayList<>();
	private static RevistaArrayDao INSTANCE;
	private RevistaArrayDao() {
		
	}
	public static synchronized RevistaArrayDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RevistaArrayDao();
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
		Revista rev=null;
		for(Revista r:revistas)
			if(r.getId()==id)
			{
				rev=r;
				return rev;
			}
		return rev;
	}

	@Override
	public boolean insert(Revista pojo) {
		// TODO Auto-generated method stub
		boolean echo=false;
		
		if(pojo!=null) {
			revistas.add(pojo);
			echo=true;
		}
		return echo;
	}

	@Override
	public boolean update(Revista revUpdate) {
		boolean resul = false;
		Revista revIteracion = null;
		int i = 0;
		if ( revUpdate != null ) {
			//Iterator		
			Iterator<Revista> it = revistas.iterator();
			while( it.hasNext() ) {
				revIteracion = it.next();
				if (revIteracion.getId() == revUpdate.getId() ) {
					revistas.set(i, revUpdate);
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
		
		Revista revIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < revistas.size(); i++) {
			
			revIteracion = revistas.get(i);   //video sobre el que iteramos
			
			if ( id == revIteracion.getId() ) {    // video encontrado
				resul = revistas.remove(revIteracion);
				break;
			}
		}
		
		return resul;
	}

	


}
