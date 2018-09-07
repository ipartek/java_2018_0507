package com.ipartek.formacion.uf2216.accesoDatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.uf2216.pojo.Revista;

public class RevistaArrayDAO implements CrudAbleRevista<Revista>{
	
	private List<Revista> revistas = new ArrayList<>(); 
	
	// SINGLETON
	private static RevistaArrayDAO INSTANCE = null;
	private RevistaArrayDAO() {	}
	public static synchronized RevistaArrayDAO getInstance() {
		if ( INSTANCE == null ) {
			INSTANCE = new RevistaArrayDAO(); 
		}
		return INSTANCE;
	}

	/** 
	 * Metodo para listar todas las revistas
	 * */
	@Override
	public List<Revista> getAll() {
		return revistas;
	}

	/*
	 * Metodo para lista una revista basandose en su id
	 * */
	@Override
	public Revista getById(long id) {
		Revista resul = null;
		
		for (Revista revistaIteracion : revistas) {
			if (id == revistaIteracion.getId()) {
				resul = revistaIteracion;
				break;
			}
		}
		return resul;
	}

	/**
	 * Metodo para insertar una nueva revista
	 * */
	@Override
	public boolean insert(Revista revista) {
		boolean resul = false;
		
		if (revista != null) {
			resul = revistas.add(revista);
		}
		return resul;
	}

	/**
	 * Metodo para modificar una revista
	 * */
	@Override
	public boolean update(Revista revista) {
		boolean resul = false;
		Revista revistaIteracion = null;
		int i = 0;
		
		if (revista != null) {
			Iterator<Revista> it = revistas.iterator();
			while (it.hasNext()) {
				revistaIteracion = it.next();
				if (revistaIteracion.getId() == revista.getId()) {
					revistas.set(i, revista);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	/**
	 * Metodo para borrar una revista pasandole un id
	 * */
	@Override
	public boolean delete(long id) {
		boolean resul = false;		
		Revista lIteracion = null;
		
		// Buscar una revista para eliminar
		for (int i = 0; i < revistas.size(); i++) {
			lIteracion = revistas.get(i);   			
			
			if (id == lIteracion.getId()) {    			
				resul = revistas.remove(lIteracion);
				break;
			}
		}
			
		return resul;
	}
	@Override
	public Revista getByIsbn(String isbn) {
		Revista resul = null;
		
		for (Revista rIteracion : revistas) {
			if (isbn.equals(rIteracion.getIsbn())) {
				resul = rIteracion;
				break;
			}
		}
		return resul;
	}
	@Override
	public List<Revista> getAllByFormatos(boolean isFormato) {
		ArrayList<Revista> resul = new ArrayList<>();
		String formatoCorrecto;
		if (isFormato == true) {
			formatoCorrecto = "Digital";
		}else {
			formatoCorrecto = "Papel";
		}
		for (Revista revista: revistas) {
			if (revista.isFormato().equals(formatoCorrecto)) {
				resul.add(revista);
			}
		}
		return resul;
	}
}