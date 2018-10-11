package com.ipartek.formacion.uf2216_recuperacion.movil;

import java.util.ArrayList;
import java.util.List;



public class MovilArrayDAO implements  CrudAble<Movil> {


	private List<Movil> movillist = new ArrayList<>();

	private static MovilArrayDAO INSTANCE;

	public MovilArrayDAO() {
	}

	public static synchronized MovilArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new MovilArrayDAO();
		}

		return INSTANCE;
	}
	public List<Movil> getAll() {
		return movillist;
	}


	@Override
	public List<Movil> insert(Movil movil) {
		CrudAble<Movil> dao = movil;
		if(dao.insert(movil) != null) {
			movillist.add(movil);
			System.out.println("Movil añadido");
		} else {
			System.out.println("Error al añadir");
		}
		
	
		List<Movil> movillist = null;

		if (movil != null) {
			movillist = movil.insert(movil);
			
			ManejoFichero.escribirFich(movil.toString());
		}
		
		for (int i=0;i<movillist.size();i++) {
			System.out.println(movillist.get(i));
		}
		return movillist;
	}

	@Override
	public Movil getMovil() {
		// TODO Auto-generated method stub
		return null;
	}
}
