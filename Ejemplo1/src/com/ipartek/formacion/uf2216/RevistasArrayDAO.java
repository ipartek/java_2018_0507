package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;



public class RevistasArrayDAO implements CrudAble<Revistas> {
	
	
	private List <Revistas> revistas = new ArrayList<>();
	private static RevistasArrayDAO INSTANCE;
	
	public static synchronized RevistasArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new RevistasArrayDAO();
		}

		return INSTANCE;
	}
	

	public List<Revistas> getAll() {
		
		return revistas;
	}

	@Override
	public Revistas getByID(long id) {
		
		Revistas re = null;
		
		for(Revistas r: revistas) {
			if (id == r.getId())
				re =r;
		}
		return re;
	}


	public boolean insert(Revistas revis) {
		
		boolean resultado = false;
		
		
		if (revis != null) {
			resultado = revistas.add(revis);
		}
		
		return resultado;
	}



	
}
