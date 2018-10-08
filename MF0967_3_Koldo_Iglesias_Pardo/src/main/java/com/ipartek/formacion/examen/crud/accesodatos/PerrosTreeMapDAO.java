package com.ipartek.formacion.examen.crud.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.examen.crud.modelos.Perros;


public class PerrosTreeMapDAO implements CrudAble<Perros> {

	//PRINCIPIO SINGLETON
	private static final PerrosTreeMapDAO dao = new PerrosTreeMapDAO();
	
	private PerrosTreeMapDAO() {}
	
	public static PerrosTreeMapDAO getInstance() { return dao; }
	//FIN SINGLETON
	
	//CONSTRUCTOR ESTÃ�TICO
	static {
		//CREAR UN CONJUNTO DE USUARIOS DE PRUEBA QUE SERÃ�N
		//1, email1@email.com, contra1
		//2, email2@email.com, contra2
		//...
		//10, email10@email.com, contra10
		for(long i = 1; i <= 10; i++) {
			dao.insert(new Perros(i, null, 0, null, 0, false, null, 0, 0));
		}
	}
	//FIN
	
	private TreeMap<Long, Perros> perrosmap = new TreeMap<>();
	
	private Long idUltimo = 0L;

	@Override
	public List<Perros> getAll() {
		return new ArrayList<Perros>(perrosmap.values());
	}

	@Override
	public Perros getById(long id) {
		return perrosmap.get(id);
	}

	@Override
	public void insert(Perros perrosmap) {
				Long id = ++idUltimo;
				perrosmap.setId(id);
				this.perrosmap.put(perrosmap.getId(), perrosmap);
	}


	
}
