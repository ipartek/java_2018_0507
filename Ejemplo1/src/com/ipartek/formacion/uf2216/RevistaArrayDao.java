package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Gestionar Revistas Array
 * @author Cristina Martin
 *
 */

public class RevistaArrayDao implements CrudAble<Revista> {
		// Metodo sigleton
		private List<Revista> revistas = new ArrayList<>();

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
		public List<Revista> getAll() { //TODO: obligatorio listar todas las revistas
			return revistas;
		}

		@Override
		public Revista getById(long id) { //TODO: obligatorio listar segun id
			Revista resul = null;
	
			for (Revista rIteracion : revistas) {
				if (id == rIteracion.getId()) {
					resul = rIteracion;
					break;
				}
			}
			return resul;
		}

		@Override
		public boolean insert(Revista pojo) { //TODO: obligatorio crear revistas
			boolean resul = false;

			if (pojo != null) {
				resul = revistas.add(pojo);
			}
			return resul;
		}

		@Override
		public boolean update(Revista pojo) { //TODO: no obligatorio actualizar rev
			boolean resul = false;
			Revista rIteracion = null;
			int i = 0;
			
			if (pojo != null) {
				// Iterator
				Iterator<Revista> it = revistas.iterator();
				
				while (it.hasNext()) {
					rIteracion = it.next();
					
					if (rIteracion.getId() == pojo.getId()) {
						revistas.set(i, pojo);
						resul = true;
						break;
					}
					i++;
				}
			}
			return resul;
		}

		@Override
		public boolean delete(long id) { //TODO: no obligatorio eliminar
			boolean resul = false;
			Revista rIteracion = null;

			for (int i = 0; i < revistas.size(); i++) {
				rIteracion = revistas.get(i); 

				if (id == rIteracion.getId()) { 
					resul = revistas.remove(rIteracion);
					break;
				}
			}
			return resul;
		}

}
