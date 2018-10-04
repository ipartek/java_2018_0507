package com.ipartek.formacion.uf2216;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.ipartek.formacion.uf2216.Revistas;;

public class RevistasArrayDAO implements CrudAble<Revistas> {

		private List<Revistas> revistas = new ArrayList<>();
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
		public List<Revistas> getAll() {
			return revistas;
		}

		@Override
		public Revistas getById(long id) {
			Revistas resul = null;
			for (Revistas revistasIteracion : revistas) {
				if ( id == revistasIteracion.getId() ) {
					resul = revistasIteracion;
					break;
				}
			}
			return resul;
		}

		@Override
		public boolean insert(Revistas revista) {
			boolean resultado = false;
			if (revista != null) {
				resultado = revistas.add(revista);
			}
			return resultado;
		}

		@Override
		public boolean update(Revistas revistasUpdate) {
			boolean resultado = false;
			Revistas revistasIteracion = null;
			int i = 0;
			if ( revistasUpdate != null ) {
				Iterator<Revistas> iterator_cur = revistas.iterator();
				while( iterator_cur.hasNext() ) {
					revistasIteracion = iterator_cur.next();
					if ( revistasIteracion.getId() == revistasUpdate.getId() ) {
						revistas.set(i, revistasUpdate);
						resultado = true;
						break;					
					}	
					i++;
				}		
			}	
			return resultado;
		}

		@Override
		public boolean delete(long id) {
			// TODO Auto-generated method stub
			boolean resultado = false;			
			Revistas revistasIteracion = null;
			for (int i = 0; i < revistas.size(); i++) {			
				revistasIteracion = revistas.get(i);   		
				if ( id == revistasIteracion.getId() ) {   
					resultado = revistas.remove(revistasIteracion);
					break;
				}
			}		
			return resultado;
		}

}
