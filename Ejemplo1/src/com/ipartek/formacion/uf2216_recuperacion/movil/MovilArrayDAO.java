package com.ipartek.formacion.uf2216_recuperacion.movil;

import java.util.ArrayList;
import java.util.List;


public class MovilArrayDAO implements  CrudAble<Movil> {


	private List<Movil> movil = new ArrayList<>();

	private static MovilArrayDAO INSTANCE;

	private MovilArrayDAO() {
	}

	public static synchronized MovilArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new MovilArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public List<Movil> getAll() {
		return movil;
	}

	@Override
	public boolean insert(Movil movil) {
		
	
		boolean resul = false;

		if (movil != null) {
			resul = movil.insert(movil);
			
			ManejoFichero.escribirFich(movil.toString());
		}
		return resul;
	}

	@Override
	public Movil getMovil(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
