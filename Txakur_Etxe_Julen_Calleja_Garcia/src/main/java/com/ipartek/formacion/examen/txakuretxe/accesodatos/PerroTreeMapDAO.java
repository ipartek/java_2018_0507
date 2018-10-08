package com.ipartek.formacion.examen.txakuretxe.accesodatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.examen.txakuretxe.modelo.Chip;
import com.ipartek.formacion.examen.txakuretxe.modelo.Perro;

public class PerroTreeMapDAO implements CrudAble<Chip> {

private static final PerroTreeMapDAO dao = new PerroTreeMapDAO();
	
	private PerroTreeMapDAO() {}
	
	public static PerroTreeMapDAO getInstance() { return dao; }
	
	static {
		
		for(long i = 1; i <= 10; i++) {
			dao.insert(new Chip(0, "pastor aleman",i,"Toby", i, true, i, i));
		}
		
	}
	
	private TreeMap<Long, Chip> perros = new TreeMap<>();
	private Long idUltimo = 0L;
	
	@Override
	public List<Chip> getAll() {
		return new ArrayList<Chip>(perros.values());
	}

	@Override
	public Chip getById(long id) {
		return perros.get(id);
	}

	@Override
	public void insert(Chip perro) {
		Long id = ++idUltimo;
		perro.setId(id);
		perros.put(perro.getId(), perro);
		
	}

	
}
