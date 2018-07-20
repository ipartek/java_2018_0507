package com.ipartek.formacion.uf2216.revista;

import java.util.ArrayList;
import java.util.List;


public class RevistaArrayDAO implements  CrudAble<Revista> {


	private List<Revista> revista = new ArrayList<>();

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
		return revista;
	}

	@Override
	public boolean insert(Revista revista) {
		
		System.out.println("Titulo de Revista"+revista.getTitulo());
		boolean resul = false;

		if (revista != null) {
			resul = revista.insert(revista);
			System.out.println("Revista guardada");
		}
		return resul;
	}

	@Override
	public Revista getRevistas(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
