package com.ipartek.formacion.javaee.libroelectronico.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.javaee.libroelectronico.pojo.Pagina;

public class LibroMapDAO implements CrudAble<Pagina>{

	private List<Pagina> paginas = new ArrayList<>();
	
	private static LibroMapDAO INSTANCE;
	
	public LibroMapDAO() {
	}
	
	public static synchronized LibroMapDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroMapDAO();
		}
		return INSTANCE;
	}
	
	public List<Pagina> getAll(){
		return paginas;
	}
	
	@Override
	public Pagina getById(long id) {
		return paginas.get((int) id);
	}

	@Override
	public boolean insert(Pagina pagina) {
		boolean resul = false;

		if (pagina != null) {
			resul = paginas.add(pagina);
		}
		return resul;
	}

	@Override
	public boolean update(Pagina pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
}

