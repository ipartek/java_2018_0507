package com.ipartek.formacion.uf2216rec.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.uf2216rec.pojo.Moviles;

public class MovilesArrayDAO implements CrudAble<Moviles>{

	private List<Moviles> moviles = new ArrayList<>();
	
	private static MovilesArrayDAO INSTANCE;
	
	private MovilesArrayDAO() {
		
	}
	
	public static synchronized MovilesArrayDAO getInstace() {
		if(INSTANCE == null) {
			INSTANCE = new MovilesArrayDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public List<Moviles> getAll() {
		return moviles;
	}

	@Override
	public Moviles getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Moviles movil) {
		boolean resul = false;
		
		if(movil != null) {
			resul = moviles.add(movil);
		}
		return resul;
	}

	@Override
	public boolean update(Moviles pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
