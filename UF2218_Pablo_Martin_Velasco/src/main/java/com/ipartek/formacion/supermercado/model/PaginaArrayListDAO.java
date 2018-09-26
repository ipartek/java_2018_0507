package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.List;

public class PaginaArrayListDAO implements CrudAble<Pagina>{
	
	
	private static PaginaArrayListDAO INSTANCE = null;
	private static List<Pagina> paginas = null;
	
	
	private PaginaArrayListDAO() {
		paginas = new ArrayList<Pagina>();
		
		try {
			paginas.add(new Pagina(0, "entradilla", "Erase una vez..."));
			paginas.add(new Pagina(1, "inicio", "fwef wefcincw cwjbn cwe wc cwe we wwe cwe wcw wewecw wcwewcewc cwe."));
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static synchronized PaginaArrayListDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PaginaArrayListDAO();
		}
		return INSTANCE;
	}
	

	public boolean insert(Pagina pojo) {
		return paginas.add(pojo);
	}

	public List<Pagina> getAll() {
		return paginas;
	}

	public Pagina getById(String id) {
		Pagina resul = null;
		if(id != null) {
			for(Pagina p : paginas) {
				if(id.equals(p.getId())) {
					resul = p;
				}
			}
		}
		return resul;
	}

	public boolean update(Pagina pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
