package com.ipartek.formacion.javaee.libroelectronico.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.javaee.libroelectronico.pojo.Libro;

public class LibroDAO implements CrudAble<Libro>{

	private List<Libro> paginas = new ArrayList<>();
	
	private static LibroDAO INSTANCE;
	
	public LibroDAO() {
	}
	
	public static synchronized LibroDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		return INSTANCE;
	}
	
	public List<Libro> getAll(){
		return paginas;
	}

	@Override
	public Libro getById(long id) {
		return paginas.get((int) id);
	}

	@Override
	public boolean insert(Libro pagina) {
		boolean resul = false;

		if (pagina != null) {
			resul = paginas.add(pagina);
		}
		return resul;
	}

	@Override
	public boolean update(Libro pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*public List<Pagina> getRecords(int start, int total){
		List<Pagina> list = new ArrayList<Pagina>();
		
		
		for (int i = start; i<= total; i++) {
			list.add(employees.get(i+1));
			//list.add(getById(i));
		}
		
		return list;
	}*/
}

