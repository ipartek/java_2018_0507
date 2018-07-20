package com.ipartek.formacion.uf2216.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.uf2216.pojo.Revista;
import com.ipartek.formacion.video.accesodatos.VideoYoutubeArrayDAO;
import com.ipartek.formacion.video.pojo.VideoYoutube;
import com.ipartek.formacion.uf2216.pojo.*;


public class RevistasArrayDAO implements CrudAble<Revista>{

	
	private List<Revista> revistas = new ArrayList<>();

	private static RevistasArrayDAO INSTANCE;

	private RevistasArrayDAO(){
		
	}

	
	/**
	 * Pregunta si existe un hilo con una instancia, y sino la creamos
	 * 
	 * @return
	 */
	public static synchronized RevistasArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RevistasArrayDAO();
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
		//foreach
		for (Revista revistaIteracion : revistas) {
			if ( id == revistaIteracion.getId() ) {
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
		if ( revistaUpdate != null ) {
			//Iterator		
			Iterator<Revista> it = revistas.iterator();
			while( it.hasNext() ) {
				revistaIteracion = it.next();
				if ( revistaIteracion.getId() == revistaUpdate.getId() ) {
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
		
		Revista revistaIteracion= null;
		
		//buscar video a eliminar
		for (int i = 0; i < revistas.size(); i++) {
			
			revistaIteracion = revistas.get(i);   //video sobre el que iteramos
			
			if ( id == revistaIteracion.getId() ) {    // video encontrado
				resul = revistas.remove(revistaIteracion);
				break;
			}
		}
		
		return resul;
	}
	
	
	
	
	
}
